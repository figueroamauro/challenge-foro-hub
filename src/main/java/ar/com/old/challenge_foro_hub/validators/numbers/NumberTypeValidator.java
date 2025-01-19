package ar.com.old.challenge_foro_hub.validators.numbers;

import ar.com.old.challenge_foro_hub.validators.Validator;

import java.util.Set;

public enum NumberTypeValidator {

    NEGATIVE(new NumberNegativeValidator());


    private final Validator<Double> validator;

    NumberTypeValidator(Validator<Double> validator) {
        this.validator = validator;
    }

    public void validate(Double value) {
        this.validator.validate(value);
    }
}
