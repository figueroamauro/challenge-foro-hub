package ar.com.old.challenge_foro_hub.validators.numbers;

import ar.com.old.challenge_foro_hub.exceptions.validators.NumberValidationException;
import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;
import ar.com.old.challenge_foro_hub.validators.Validator;

public class NumberNullValidator implements Validator<Double> {

    @Override
    public void validate(Double value) throws ValidationException {
        if (value == null) {
            throw new NumberValidationException("El campo no puede ser nulo");
        }
    }
}
