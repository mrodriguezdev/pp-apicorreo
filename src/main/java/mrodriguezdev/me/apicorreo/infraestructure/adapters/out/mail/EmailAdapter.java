package mrodriguezdev.me.apicorreo.infraestructure.adapters.out.mail;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Template;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apicorreo.domain.model.email.EmailMessage;
import mrodriguezdev.me.apicorreo.infraestructure.configuration.Apicorreo;
import mrodriguezdev.me.apicorreo.domain.model.email.EmailTemplateData;
import mrodriguezdev.me.apicorreo.infraestructure.utils.ValidationUtil;
import mrodriguezdev.me.apicorreo.infraestructure.ws.BadRequestException;
import mrodriguezdev.me.apicorreo.infraestructure.ws.InternalServerErrorException;
import mrodriguezdev.me.apicorreo.domain.ports.out.EmailOutputPort;

import java.time.LocalDate;
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
    public void sendMail(EmailMessage emailMessage) {
        try {
            ValidationUtil.validar(emailMessage);
            String content = this.generateHtmlContent(this.generateEmailTemplate(emailMessage));
            Mail mail = this.buildEmail(content);
            this.mailer.send(mail);
        } catch (BadRequestException bre) {
            this.logger.log(Level.WARNING, "Validation failed.", bre);
            throw new BadRequestException(bre.getMessage());
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "Unexpected error while processing the emailMessage sending.", e);
            throw new InternalServerErrorException("An unexpected error occurred while processing the emailMessage.");
        }
    }

    private EmailTemplateData generateEmailTemplate(EmailMessage emailMessage) {
        EmailTemplateData emailTemplateData = new EmailTemplateData();
        emailTemplateData.name = emailMessage.name;
        emailTemplateData.email = emailMessage.email;
        emailTemplateData.subject = emailMessage.subject;
        emailTemplateData.message = emailMessage.message;
        emailTemplateData.domain = this.configs.webApp().domain();
        emailTemplateData.currentyear = LocalDate.now().getYear();
        return emailTemplateData;
    }

    private String generateHtmlContent(EmailTemplateData emailTemplateData) {
        return correo_template.data("email", emailTemplateData).render();
    }


    private Mail buildEmail(String contenidoHtml) {
        Mail mail = Mail.withHtml(this.configs.bussinesEmail(), "Nuevo mensaje del formulario de contacto", contenidoHtml);
        mail.addCc(this.configs.personalEmail());
        return mail;
    }
}
