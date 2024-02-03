package mrodriguezdev.me.apicorreo.infraestructure.ports.out;

import mrodriguezdev.me.apicorreo.domain.model.email.EmailResponse;

public interface EmailOutputPort {
    void sendMail(EmailResponse emailResponse);
}
