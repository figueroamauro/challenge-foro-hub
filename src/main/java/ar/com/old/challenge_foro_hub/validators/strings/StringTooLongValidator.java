package ar.com.old.challenge_foro_hub.validators.strings;

import ar.com.old.challenge_foro_hub.exceptions.validators.StringValidationException;
import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;
import ar.com.old.challenge_foro_hub.validators.Validator;

public class StringTooLongValidator implements Validator<String> {
    private final int maxLength;

    public StringTooLongValidator(int maxLength) {
        this.maxLength = maxLength;

    }

    @Override
    public void validate(String value) throws ValidationException {
        if (value.length() >= maxLength) {
            throw new StringValidationException("El campo debe tener menos de " + maxLength + " caracteres");
        }
    }
}
