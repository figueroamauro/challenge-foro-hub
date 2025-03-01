package ar.com.old.challenge_foro_hub.validators;

import ar.com.old.challenge_foro_hub.enumerations.NumberTypeValidator;
import ar.com.old.challenge_foro_hub.validators.numbers.NumberValidator;
import ar.com.old.challenge_foro_hub.validators.numbers.NumberValidatorBuilder;
import ar.com.old.challenge_foro_hub.enumerations.StringTypeValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidatorBuilder;

public class CommentValidator {

    public static void validateMessage(String message) {
        StringValidator validator = StringValidatorBuilder.create()
                                            .add(StringTypeValidator.TOO_LONG_100)
                                            .add(StringTypeValidator.NULL)
                                            .add(StringTypeValidator.EMPTY)
                                            .build();
        validator.validate(message);
    }

    public static void validateId(Long id) {
        NumberValidator validator = NumberValidatorBuilder.create()
                                            .add(NumberTypeValidator.NEGATIVE)
                                            .build();
        validator.validate(Math.toIntExact(id));
    }
}
