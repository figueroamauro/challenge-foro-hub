package ar.com.old.challenge_foro_hub.validators.strings;

import ar.com.old.challenge_foro_hub.exceptions.StringValidationException;
import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;
import ar.com.old.challenge_foro_hub.validators.Validator;

public class StringNotNullValidator implements Validator<String> {
    @Override
    public void validate(String s) throws ValidationException {
        if (s == null) {
            throw new StringValidationException("El campo no puede estar vacio");
        }
    }
}
