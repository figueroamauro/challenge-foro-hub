package ar.com.old.challenge_foro_hub.validators.strings;

import ar.com.old.challenge_foro_hub.exceptions.validators.ValidationException;

import java.util.HashSet;
import java.util.Set;

public class StringValidatorBuilder {
    private final Set<StringTypeValidator> validators;

    private StringValidatorBuilder(Set<StringTypeValidator> validators) {
        this.validators = validators;
    }

    public static StringValidatorBuilder create() {
        return new StringValidatorBuilder(new HashSet<>());
    }

    public StringValidatorBuilder add(StringTypeValidator validator) {
        Set<StringTypeValidator> updatedValidators = new HashSet<>(this.validators);
        updatedValidators.add(validator);
        return new StringValidatorBuilder(updatedValidators);
    }

    public StringValidator build() {
        return new StringValidator(this.validators);
    }
}
