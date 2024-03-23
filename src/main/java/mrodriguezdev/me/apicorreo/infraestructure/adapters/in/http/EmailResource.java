package mrodriguezdev.me.apicorreo.infraestructure.adapters.in.http;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mrodriguezdev.me.apicorreo.domain.model.email.EmailMessage;
import mrodriguezdev.me.apicorreo.domain.ports.in.EmailInputPort;

@Path("email")
public class EmailResource {

    @Inject
    EmailInputPort emailInputPort;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendMail(EmailMessage emailMessage) {
        this.emailInputPort.sendMail(emailMessage);
        return Response.ok().entity("EmailMessage sent successfully").build();
    }
}
