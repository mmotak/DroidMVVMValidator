package pl.com.mmotak.validator.rules;

import pl.com.mmotak.validator.Rule;

public abstract class AbstractRule<T> implements Rule<T> {

    private final String error;

    protected AbstractRule(String error) {
        this.error = error;
    }

    @Override
    public String getErrorMessage() {
        return error;
    }
}
