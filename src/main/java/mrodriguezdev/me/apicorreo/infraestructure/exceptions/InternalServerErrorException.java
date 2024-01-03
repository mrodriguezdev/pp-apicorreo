package mrodriguezdev.me.apicorreo.infraestructure.exceptions;

import mrodriguezdev.me.apicorreo.domains.models.CustomExceptionResponse;

public class InternalServerErrorException extends CustomException {
    public InternalServerErrorException() {
        super("Internal Server error", new CustomExceptionResponse<>("Internal Server error",500));
    }

    public InternalServerErrorException(String message) {
        super(message, new CustomExceptionResponse<>(message, 500));
    }

    public InternalServerErrorException(CustomExceptionResponse<?> response) {
        super(response);
    }
}
