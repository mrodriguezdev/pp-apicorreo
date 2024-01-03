package mrodriguezdev.me.apicorreo.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apicorreo.domains.configuration.Apicorreo;
import mrodriguezdev.me.apicorreo.domains.models.EmailDTO;
import mrodriguezdev.me.apicorreo.domains.models.EmailResponse;
import mrodriguezdev.me.apicorreo.domains.ports.in.EmailInputPort;
import mrodriguezdev.me.apicorreo.domains.ports.out.EmailOutputPort;

import java.time.LocalDate;

@ApplicationScoped
public class EmailUserCase implements EmailInputPort {

    @Inject
    Apicorreo apicorreo;

    @Inject
    EmailOutputPort emailOutputPort;

    @Override
    public void sendMail(EmailDTO emailDTO) {
        EmailResponse emailResponse = this.generateEmailResponse(emailDTO);
        this.emailOutputPort.sendMail(emailResponse);
    }

    private EmailResponse generateEmailResponse(EmailDTO emailDTO) {
        EmailResponse emailResponse = new EmailResponse();
        emailResponse.setNombre(emailDTO.getNombre());
        emailResponse.setCorreo(emailDTO.getCorreo());
        emailResponse.setAsunto(emailDTO.getAsunto());
        emailResponse.setMensaje(emailDTO.getMensaje());
        emailResponse.setDomain(this.apicorreo.webAppDomain());
        emailResponse.setCurrentyear(LocalDate.now().getYear());
        return emailResponse;
    }
}
