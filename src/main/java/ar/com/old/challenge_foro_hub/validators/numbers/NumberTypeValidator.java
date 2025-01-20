package ar.com.old.challenge_foro_hub.validators.numbers;

import ar.com.old.challenge_foro_hub.validators.Validator;


public enum NumberTypeValidator {
    NULL(new NumberNullValidator()),
    NEGATIVE(new NumberNegativeValidator());


    private final Validator<Integer> validator;

    NumberTypeValidator(Validator<Integer> validator) {
        this.validator = validator;
    }

    public void validate(Integer value) {
        this.validator.validate(value);
    }
}
