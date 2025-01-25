package ar.com.old.challenge_foro_hub.exceptions.validators;

import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;

public class StringValidationException extends ValidationException {
    public StringValidationException(String message) {
        super(message);
    }
}
