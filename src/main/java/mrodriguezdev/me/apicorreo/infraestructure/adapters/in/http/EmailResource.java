package mrodriguezdev.me.apicorreo.infraestructure.adapters.in.http;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mrodriguezdev.me.apicorreo.domain.model.email.EmailDTO;
import mrodriguezdev.me.apicorreo.infraestructure.ports.in.EmailInputPort;

@Path("email")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmailResource {

    @Inject
    EmailInputPort emailInputPort;

    @POST
    public Response sendMail(EmailDTO emailDTO) {
        this.emailInputPort.sendMail(emailDTO);
        return Response.ok().entity("Email sent successfully").build();
    }
}
