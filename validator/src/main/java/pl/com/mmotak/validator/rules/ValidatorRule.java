package pl.com.mmotak.validator.rules;

import pl.com.mmotak.validator.Valid;

/**
 * Created by Maciej on 2017-03-13.
 */

public class ValidatorRule<T> extends AbstractRule<T> {

    private final Valid<T> validator;

    public ValidatorRule(Valid<T> validator, String error) {
        super(error);
        this.validator = validator;
    }

    @Override
    public boolean isValid(T t) {
        return validator.isValid(t);
    }
}
