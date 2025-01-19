package ar.com.old.challenge_foro_hub.validators.numbers;

import java.util.HashSet;
import java.util.Set;

public class NumberValidatorBuilder {

    private final Set<NumberTypeValidator> validators;

    private NumberValidatorBuilder(Set<NumberTypeValidator> validators) {
        this.validators = validators;
    }

    public static NumberValidatorBuilder create() {
        return new NumberValidatorBuilder(new HashSet<>());
    }

    public NumberValidatorBuilder add(NumberTypeValidator validator) {
        Set<NumberTypeValidator> updatedValidators = new HashSet<>(this.validators);
        updatedValidators.add(validator);
        return new NumberValidatorBuilder(updatedValidators);
    }

    public NumberValidator build() {
        return new NumberValidator(this.validators);
    }
}
