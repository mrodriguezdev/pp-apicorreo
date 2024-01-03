package mrodriguezdev.me.apicorreo.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apicorreo.domains.models.EmailDTO;
import mrodriguezdev.me.apicorreo.domains.ports.in.EmailInputPort;
import mrodriguezdev.me.apicorreo.domains.ports.out.EmailOutputPort;

@ApplicationScoped
public class EmailUserCase implements EmailInputPort {

    @Inject
    EmailOutputPort emailOutputPort;

    @Override
    public void sendMail(EmailDTO emailDTO) {
        this.emailOutputPort.sendMail(emailDTO);
    }
}
