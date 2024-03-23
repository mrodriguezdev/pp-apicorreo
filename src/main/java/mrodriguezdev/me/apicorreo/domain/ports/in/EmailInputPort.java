package mrodriguezdev.me.apicorreo.domain.ports.in;

import mrodriguezdev.me.apicorreo.domain.model.email.EmailMessage;

public interface EmailInputPort {
    void sendMail(EmailMessage emailMessage);
}
