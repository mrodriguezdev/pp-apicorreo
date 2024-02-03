package mrodriguezdev.me.apicorreo.infraestructure.ws;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ResponseWS<T> {
    public T content;
    public String description;
    public String error;
    public int status;

    public ResponseWS() {
    }

    public ResponseWS(String description, String error, int status) {
        this.description = description;
        this.error = error;
        this.status = status;
    }

    public ResponseWS(T content, int status) {
        this.content = content;
        this.status = status;
    }

    public ResponseWS(T content, String description, String error, int status) {
        this.content = content;
        this.description = description;
        this.error = error;
        this.status = status;
    }
}