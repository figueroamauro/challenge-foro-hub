package ar.com.old.challenge_foro_hub.validators;

import ar.com.old.challenge_foro_hub.validators.numbers.NumberTypeValidator;
import ar.com.old.challenge_foro_hub.validators.numbers.NumberValidator;
import ar.com.old.challenge_foro_hub.validators.numbers.NumberValidatorBuilder;
import ar.com.old.challenge_foro_hub.validators.strings.StringTypeValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringValidatorBuilder;

public class TopicValidator {

    public static void validateTitle(String title) {
        StringValidator validator = StringValidatorBuilder.create()
                                            .add(StringTypeValidator.TOO_LONG_50)
                                            .add(StringTypeValidator.NULL)
                                            .add(StringTypeValidator.EMPTY)
                                            .build();
        validator.validate(title);
    }

    public static void validateMessage(String message) {
        StringValidator validator = StringValidatorBuilder.create()
                                            .add(StringTypeValidator.TOO_LONG_100)
                                            .add(StringTypeValidator.NULL)
                                            .add(StringTypeValidator.EMPTY)
                                            .build();
        validator.validate(message);
    }

    public static void validateId(Long id) {
        if (id == null) {
            return;
        }
        NumberValidator validator = NumberValidatorBuilder.create()
                                            .add(NumberTypeValidator.NEGATIVE)
                                            .build();
        validator.validate(Math.toIntExact(id));
    }


}
