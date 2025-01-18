package ar.com.old.challenge_foro_hub.validators;

import ar.com.old.challenge_foro_hub.validators.strings.StringTypeValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidatorBuilder;

public class UserValidator {

    public static void validateName(String name) {
        StringValidator validator = StringValidatorBuilder.create()
                .add(StringTypeValidator.TOO_LONG_30)
                .add(StringTypeValidator.IS_EMPTY)
                .build();
        validator.validate(name);
    }
}
