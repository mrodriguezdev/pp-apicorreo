package mrodriguezdev.me.apicorreo.infraestructure.exceptions;

import mrodriguezdev.me.apicorreo.domains.models.CustomExceptionResponse;

public class BadRequestException extends CustomException {
    public BadRequestException() {
        super("Bad Request", new CustomExceptionResponse<>("Bad Request", 400));
    }

    public BadRequestException(String message) {
        super(message, new CustomExceptionResponse<>(message, 400));
    }

    public BadRequestException(CustomExceptionResponse<?> response) {
        super(response);
    }
}