package mrodriguezdev.me.apicorreo.infraestructure.ports.in;

import mrodriguezdev.me.apicorreo.domain.model.email.EmailDTO;

public interface EmailInputPort {
    void sendMail(EmailDTO emailDTO);
}
