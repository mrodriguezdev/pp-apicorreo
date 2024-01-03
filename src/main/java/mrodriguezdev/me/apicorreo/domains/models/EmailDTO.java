package mrodriguezdev.me.apicorreo.domains.models;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class EmailDTO {
    private String nombre;
    private String correo;
    private String asunto;
    private String mensaje;

    public EmailDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
