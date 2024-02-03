package mrodriguezdev.me.apicorreo.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apicorreo.domain.configuration.Apicorreo;
import mrodriguezdev.me.apicorreo.domain.model.email.EmailDTO;
import mrodriguezdev.me.apicorreo.domain.model.email.EmailResponse;
import mrodriguezdev.me.apicorreo.infraestructure.ports.in.EmailInputPort;
import mrodriguezdev.me.apicorreo.infraestructure.ports.out.EmailOutputPort;

import java.time.LocalDate;

@ApplicationScoped
public class EmailUseCase implements EmailInputPort {

    @Inject
    Apicorreo configs;

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
        emailResponse.setDomain(this.configs.webApp().domain());
        emailResponse.setCurrentyear(LocalDate.now().getYear());
        return emailResponse;
    }
}
