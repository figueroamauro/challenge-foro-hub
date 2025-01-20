package ar.com.old.challenge_foro_hub.validators;

import ar.com.old.challenge_foro_hub.exceptions.StringValidationException;
import ar.com.old.challenge_foro_hub.validators.strings.StringTooLongValidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"test", "test test", "test test test"})
    void shouldThrowException_withTooLong(String value) {
        Validator validator = new StringTooLongValidator(value.length() -1);

       Exception exception =  assertThrows(StringValidationException.class, () -> {
            validator.validate(value);
        });
       assertEquals("El campo debe tener menos de " + (value.length()-1) + " caracteres", exception.getMessage());
    }

}
