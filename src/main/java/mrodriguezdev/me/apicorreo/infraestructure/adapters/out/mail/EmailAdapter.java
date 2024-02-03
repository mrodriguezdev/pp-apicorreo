package mrodriguezdev.me.apicorreo.infraestructure.adapters.out.mail;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Template;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apicorreo.domain.configuration.Apicorreo;
import mrodriguezdev.me.apicorreo.domain.model.email.EmailResponse;
import mrodriguezdev.me.apicorreo.infraestructure.ws.BadRequestException;
import mrodriguezdev.me.apicorreo.infraestructure.ws.InternalServerErrorException;
import mrodriguezdev.me.apicorreo.infraestructure.ports.out.EmailOutputPort;

import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class EmailAdapter implements EmailOutputPort {

    private final Logger logger = Logger.getLogger(EmailAdapter.class.getName());

    @Inject
    Template correo_template;

    @Inject
    Apicorreo configs;

    @Inject
    Mailer mailer;

    @Override
    public void sendMail(EmailResponse emailResponse) {
        try {
            this.validateEmailParameters(emailResponse);
            String content = this.generateHtmlContent(emailResponse);
            Mail mail = this.buildEmail(content);
            this.mailer.send(mail);
        } catch (BadRequestException e) {
            this.logger.log(Level.WARNING, "Validation error while processing the email sending.", e);
            throw e;
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "Unexpected error while processing the email sending.", e);
            throw new InternalServerErrorException("An unexpected error occurred while processing the email.");
        }
    }

    private void validateEmailParameters(EmailResponse emailResponse) {
        if(emailResponse == null ||
                emailResponse.getAsunto() == null ||
                emailResponse.getMensaje() == null ||
                emailResponse.getNombre() == null ||
                emailResponse.getCorreo() == null) throw new BadRequestException("Missing information in the contact form. Please review the resource documentation.");
    }

    private String generateHtmlContent(EmailResponse emailResponse) {
        return correo_template.data("email", emailResponse).render();
    }

    private Mail buildEmail(String contenidoHtml) {
        Mail mail = Mail.withHtml(this.configs.bussinesEmail(), "Nuevo mensaje del formulario de contacto", contenidoHtml);
        mail.addCc(this.configs.personalEmail());
        return mail;
    }
}
