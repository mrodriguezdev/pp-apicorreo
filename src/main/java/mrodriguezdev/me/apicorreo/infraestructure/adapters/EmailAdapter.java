package mrodriguezdev.me.apicorreo.infraestructure.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import mrodriguezdev.me.apicorreo.domains.models.EmailResponse;
import mrodriguezdev.me.apicorreo.domains.ports.out.EmailOutputPort;

@ApplicationScoped
public class EmailAdapter implements EmailOutputPort {

    @Override
    public void sendMail(EmailResponse emailResponse) {
        System.out.println("Información a enviar: " + emailResponse);
    }
}
