package ar.com.old.challenge_foro_hub.validators.strings;

import ar.com.old.challenge_foro_hub.exceptions.StringValidationException;
import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;
import ar.com.old.challenge_foro_hub.validators.Validator;

public class StringBlankValidator implements Validator<String> {
    @Override
    public void validate(String s) throws ValidationException {
        if (s.isBlank()) {
            throw new StringValidationException("El campo no puede estar vacio ni ser nulo");
        }
    }
}
