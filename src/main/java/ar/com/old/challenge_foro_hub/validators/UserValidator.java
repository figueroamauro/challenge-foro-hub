package ar.com.old.challenge_foro_hub.validators;

import ar.com.old.challenge_foro_hub.validators.numbers.NumberTypeValidator;
import ar.com.old.challenge_foro_hub.validators.numbers.NumberValidator;
import ar.com.old.challenge_foro_hub.validators.numbers.NumberValidatorBuilder;
import ar.com.old.challenge_foro_hub.validators.strings.StringTypeValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidatorBuilder;

public class UserValidator {

    public static void validateUserName(String name) {
        StringValidator validator = StringValidatorBuilder.create()
                                            .add(StringTypeValidator.TOO_LONG_30)
                                            .add(StringTypeValidator.BLANK)
                                            .build();
        validator.validate(name);
    }

    public static void validatePassword(String password) {
        StringValidator validator = StringValidatorBuilder.create()
                                            .add(StringTypeValidator.TOO_LONG_30)
                                            .add(StringTypeValidator.BLANK)
                                            .build();
        validator.validate(password);
    }

    public static void validateEmail(String email) {
        StringValidator validator = StringValidatorBuilder.create()
                                            .add(StringTypeValidator.TOO_LONG_50)
                                            .add(StringTypeValidator.BLANK)
                                            .build();
        validator.validate(email);
    }

    public static void validateId(Long id) {
        NumberValidator validator = NumberValidatorBuilder.create()
                                            .add(NumberTypeValidator.NEGATIVE)
                                            .build();
        validator.validate(Double.valueOf(id));
    }
}
