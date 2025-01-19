package ar.com.old.challenge_foro_hub.validators;

import ar.com.old.challenge_foro_hub.validators.numbers.NumberTypeValidator;
import ar.com.old.challenge_foro_hub.validators.numbers.NumberValidator;
import ar.com.old.challenge_foro_hub.validators.numbers.NumberValidatorBuilder;
import ar.com.old.challenge_foro_hub.validators.strings.StringTypeValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidatorBuilder;

public class CommentValidator {

    public static void validateMessage(String message) {
        StringValidator validator = StringValidatorBuilder.create()
                                            .add(StringTypeValidator.TOO_LONG_100)
                                            .add(StringTypeValidator.BLANK)
                                            .build();
        validator.validate(message);
    }

    public static void validateId(Long id) {
        NumberValidator validator = NumberValidatorBuilder.create()
                                            .add(NumberTypeValidator.NEGATIVE)
                                            .build();
        validator.validate(Double.valueOf(id));
    }
}
