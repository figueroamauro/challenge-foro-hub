package ar.com.old.challenge_foro_hub.validators.strings;

import ar.com.old.challenge_foro_hub.enumerations.StringTypeValidator;
import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;

import java.util.Set;

public class StringValidator {

    private final Set<StringTypeValidator> validators;

    public StringValidator(Set<StringTypeValidator> validators) {
        this.validators = validators;
    }

    public void validate(String value) throws ValidationException {
        for (StringTypeValidator validator : validators) {
            validator.validate(value);
        }
    }


}
