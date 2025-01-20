package ar.com.old.challenge_foro_hub.validators;

import ar.com.old.challenge_foro_hub.exceptions.StringValidationException;
import ar.com.old.challenge_foro_hub.validators.strings.StringBlankValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringEmptyValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringNullValidator;
import ar.com.old.challenge_foro_hub.validators.strings.StringTooLongValidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
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

    @ParameterizedTest
    @NullSource
    void shouldNotThrowException_withNull(String value) {
        Validator validator = new StringNullValidator();

        Exception exception =  assertThrows(StringValidationException.class, () -> {
            validator.validate(value);
        });
        assertEquals("El campo no puede ser nulo", exception.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    void shouldNotThrowException_withEmpty(String value) {
        Validator validator = new StringEmptyValidator();

        Exception exception =  assertThrows(StringValidationException.class, () -> {
            validator.validate(value);
        });
        assertEquals("El campo no puede estar vacio", exception.getMessage());
    }


}
