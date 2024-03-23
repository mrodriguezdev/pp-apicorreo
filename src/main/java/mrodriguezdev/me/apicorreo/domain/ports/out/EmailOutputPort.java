package mrodriguezdev.me.apicorreo.domain.ports.out;

import mrodriguezdev.me.apicorreo.domain.model.email.EmailMessage;

public interface EmailOutputPort {
    void sendMail(EmailMessage emailMessage);
}
