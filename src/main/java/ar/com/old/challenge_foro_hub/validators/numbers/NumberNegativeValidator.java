package ar.com.old.challenge_foro_hub.validators.numbers;

import ar.com.old.challenge_foro_hub.exceptions.validators.NumberValidationException;
import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;
import ar.com.old.challenge_foro_hub.validators.Validator;

public class NumberNegativeValidator implements Validator<Double> {

    @Override
    public void validate(Double number) throws ValidationException {
        if (number < 0) {
            throw new NumberValidationException("El campo no puede ser negativo");
        }
    }
}
