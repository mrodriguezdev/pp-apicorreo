package mrodriguezdev.me.apicorreo.infraestructure.adapters;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Template;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apicorreo.domains.configuration.Apicorreo;
import mrodriguezdev.me.apicorreo.domains.models.EmailResponse;
import mrodriguezdev.me.apicorreo.domains.ports.out.EmailOutputPort;

@ApplicationScoped
public class EmailAdapter implements EmailOutputPort {

    @Inject
    Template correo_template;

    @Inject
    Apicorreo apicorreo;

    @Inject
    Mailer mailer;

    @Override
    public void sendMail(EmailResponse emailResponse) {
        String content = this.generateHtmlContent(emailResponse);
        Mail mail = this.buildEmail(emailResponse, content);
        this.mailer.send(mail);
    }

    private String generateHtmlContent(EmailResponse emailResponse) {
        return correo_template.data("email", emailResponse).render();
    }

    private Mail buildEmail(EmailResponse emailResponse, String contenidoHtml) {
        Mail mail = Mail.withHtml(this.apicorreo.bussinesEmail(), "Nuevo mensaje del formulario de contacto", contenidoHtml);
        mail.addCc(this.apicorreo.personalEmail());
        return mail;
    }
}
