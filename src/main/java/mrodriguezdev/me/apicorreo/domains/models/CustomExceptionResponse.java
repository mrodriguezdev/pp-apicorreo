package mrodriguezdev.me.apicorreo.domains.models;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CustomExceptionResponse<T> {
    public T content;
    public String description;
    public String error;
    public int status;

    public CustomExceptionResponse() {
    }

    public CustomExceptionResponse(String description, String error, int status) {
        this.description = description;
        this.error = error;
        this.status = status;
    }

    public CustomExceptionResponse(T content, int status) {
        this.content = content;
        this.status = status;
    }

    public CustomExceptionResponse(T content, String description, String error, int status) {
        this.content = content;
        this.description = description;
        this.error = error;
        this.status = status;
    }
}