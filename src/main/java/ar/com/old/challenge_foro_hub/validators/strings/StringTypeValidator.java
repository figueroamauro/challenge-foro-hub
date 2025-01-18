package ar.com.old.challenge_foro_hub.validators.strings;


import ar.com.old.challenge_foro_hub.validators.strings.StringTooLongValidator;
import ar.com.old.challenge_foro_hub.validators.Validator;

public enum StringTypeValidator {

    TOO_LONG_30(new StringTooLongValidator(30)),
    IS_EMPTY(new StringEmptyValidator());

    private final Validator<String> validator;

    StringTypeValidator(Validator<String> validator) {
        this.validator = validator;
    }

    public void validate(String value) {
        this.validator.validate(value);
    }
}
