package ar.com.old.challenge_foro_hub.validators.numbers;

import ar.com.old.challenge_foro_hub.enumerations.NumberTypeValidator;
import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;

import java.util.Set;

public class NumberValidator {
    private final Set<NumberTypeValidator> validators;

    public NumberValidator(Set<NumberTypeValidator> validators) {
        this.validators = validators;
    }

    public void validate(Integer value) throws ValidationException {
        for (NumberTypeValidator validator : validators) {
            validator.validate(value);
        }
    }
}
