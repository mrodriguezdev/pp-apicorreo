package mrodriguezdev.me.apicorreo.application;

import jakarta.inject.Inject;
import mrodriguezdev.me.apicorreo.domain.model.email.EmailMessage;
import mrodriguezdev.me.apicorreo.infraestructure.common.UseCase;
import mrodriguezdev.me.apicorreo.domain.ports.in.EmailInputPort;
import mrodriguezdev.me.apicorreo.domain.ports.out.EmailOutputPort;

@UseCase
public class EmailUseCase implements EmailInputPort {

    @Inject
    EmailOutputPort emailOutputPort;

    @Override
    public void sendMail(EmailMessage emailMessage) {
        this.emailOutputPort.sendMail(emailMessage);
    }
}
