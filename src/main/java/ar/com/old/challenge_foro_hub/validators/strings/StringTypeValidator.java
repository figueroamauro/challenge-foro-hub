package ar.com.old.challenge_foro_hub.validators.strings;


import ar.com.old.challenge_foro_hub.validators.Validator;

public enum StringTypeValidator {

    TOO_LONG_10(new StringTooLongValidator(10)),
    TOO_LONG_30(new StringTooLongValidator(30)),
    TOO_LONG_50(new StringTooLongValidator(50)),
    TOO_LONG_100(new StringTooLongValidator(100)),
    NULL(new StringNullValidator()),
    BLANK(new StringBlankValidator()),
    EMPTY(new StringEmptyValidator());

    private final Validator<String> validator;

    StringTypeValidator(Validator<String> validator) {
        this.validator = validator;
    }

    public void validate(String value) {
        this.validator.validate(value);
    }
}
