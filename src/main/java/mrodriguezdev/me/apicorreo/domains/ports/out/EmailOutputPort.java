package mrodriguezdev.me.apicorreo.domains.ports.out;

import jakarta.enterprise.context.ApplicationScoped;
import mrodriguezdev.me.apicorreo.domains.models.EmailResponse;

@ApplicationScoped
public interface EmailOutputPort {
    void sendMail(EmailResponse emailResponse);
}
