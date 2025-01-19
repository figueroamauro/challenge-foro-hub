package ar.com.old.challenge_foro_hub.validators.numbers;

import ar.com.old.challenge_foro_hub.validators.Validator;


public enum NumberTypeValidator {
    NULL(new NumberNullValidator()),
    NEGATIVE(new NumberNegativeValidator());


    private final Validator<Double> validator;

    NumberTypeValidator(Validator<Double> validator) {
        this.validator = validator;
    }

    public void validate(Double value) {
        this.validator.validate(value);
    }
}
