package mrodriguezdev.me.apicorreo.infraestructure.exceptions;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import mrodriguezdev.me.apicorreo.domains.models.CustomExceptionResponse;

@Provider
public class CustomExceptionHandler implements ExceptionMapper<CustomException> {
    @Override
    public Response toResponse(CustomException customException) {
        CustomExceptionResponse<?> errorMessage = new CustomExceptionResponse<>();
        if(customException.getResponse() == null) {
            this.setHttpStatus(customException, errorMessage);
            errorMessage.description = customException.getMessage();
            errorMessage.error = customException.getCause().toString();
        } else {
            errorMessage = customException.getResponse();
        }

        return Response.status(errorMessage.status).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }

    private void setHttpStatus(Throwable ex, CustomExceptionResponse<?> customExceptionResponse) {
        customExceptionResponse.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();

        if(ex instanceof CustomException && ((CustomException) ex).getResponse() != null) {
            customExceptionResponse.status = (((CustomException) ex).getResponse().status);
        }
    }
}