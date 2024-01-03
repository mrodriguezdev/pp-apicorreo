package mrodriguezdev.me.apicorreo.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import mrodriguezdev.me.apicorreo.domains.models.EmailDTO;

@ApplicationScoped
public interface EmailInputPort {
    void sendMail(EmailDTO emailDTO);
}
