package pl.com.mmotak.validator;

import android.databinding.BaseObservable;

public class ValidatedObservableField<T> extends BaseObservable {
    private Rule<T> rule;
    private T value;
    private boolean isValid;
    private String errorMessage;

    public ValidatedObservableField(T value, Rule<T> rule) {
        this.value = value;
        this.rule = rule;
    }

    public ValidatedObservableField(T value) {
        this(value, null);
    }

    public ValidatedObservableField() {
    }

    public void setValue(T value) {
        if (value != this.value) {
            this.value = value;
            validate();
            notifyChange();
        }
    }

    public void setRule(Rule<T> rule) {
        this.rule = rule;
    }

    public T getValue() {
        return value;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    private void validate() {
        if (rule != null) {
            isValid = rule.isValid(getValue());
            errorMessage = isValid ? null : rule.getErrorMessage();
        }
    }
}
