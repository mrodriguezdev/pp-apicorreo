package mrodriguezdev.me.apicorreo.domains.models;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class EmailResponse {
    private String nombre;
    private String correo;
    private String asunto;
    private String mensaje;
    private String domain;
    private int currentyear;

    public EmailResponse() {
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getCurrentyear() {
        return currentyear;
    }

    public void setCurrentyear(int currentyear) {
        this.currentyear = currentyear;
    }
}
