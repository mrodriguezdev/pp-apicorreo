package mrodriguezdev.me.apicorreo.domain.model.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class EmailMessage {
    @NotNull(message = "cannot be null")
    public String name;
    @NotNull(message = "cannot be null")
    @Email(message = "Invalid email format")
    public String email;
    @NotNull(message = "cannot be null")
    public String subject;
    @NotNull(message = "cannot be null")
    public String message;
}
