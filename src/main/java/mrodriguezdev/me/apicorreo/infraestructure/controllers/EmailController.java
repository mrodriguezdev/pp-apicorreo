package mrodriguezdev.me.apicorreo.infraestructure.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mrodriguezdev.me.apicorreo.domains.models.EmailDTO;
import mrodriguezdev.me.apicorreo.domains.ports.in.EmailInputPort;

@Path("email")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmailController {

    @Inject
    EmailInputPort emailInputPort;

    @POST
    public Response sendMail(EmailDTO emailDTO) {
        this.emailInputPort.sendMail(emailDTO);
        return Response.ok().build();
    }
}
