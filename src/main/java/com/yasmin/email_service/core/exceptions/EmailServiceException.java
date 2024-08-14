package com.yasmin.email_service.core.exceptions;

public class EmailServiceException extends RuntimeException {

    public EmailServiceException(final String message) {
        super(message);
    }

    public EmailServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
