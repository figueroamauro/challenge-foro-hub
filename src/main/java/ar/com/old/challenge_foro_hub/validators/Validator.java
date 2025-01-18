package ar.com.old.challenge_foro_hub.validators;

import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;

public interface Validator <T>{
    void validate(T t) throws ValidationException;
}
