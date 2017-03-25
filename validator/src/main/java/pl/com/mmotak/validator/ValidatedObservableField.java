package pl.com.mmotak.validator;

import android.databinding.BaseObservable;

public class ValidatedObservableField<T> extends BaseObservable {
    private Rule<T> rule;
    private T value;
    private boolean isValid;
    private String errorMessage;

    /***
     * Create new ValidatedObservableField, can be validate in constructor
     * @param value - starting value
     * @param rule - rule to validate the <code>value</code>
     * @param validate - if set true the constructor will {@link #validate() validate} the <code>value</code> immediately, by given <code>rule</code>.
     */
    public ValidatedObservableField(T value, Rule<T> rule, boolean validate) {
        this.value = value;
        this.rule = rule;
        if (validate) {
            validate();
        }
    }

    /***
     * Create new ValidatedObservableField, will not be validate in constructor
     * @param value - starting value
     * @param rule - rule to validate the <code>value</code>
     */
    public ValidatedObservableField(T value, Rule<T> rule) {
        this(value, rule, false);
    }

    /***
     * Create new ValidatedObservableField, will not be validate in constructor
     * <br> use {@link #setRule(Rule) setRule} to set the rule later
     * @param value - starting value
     */
    public ValidatedObservableField(T value) {
        this(value, null, false);
    }

    /***
     * Create new ValidatedObservableField, will not be validate in constructor
     * <br> use {@link #setRule(Rule) setRule} to set the rule later
     * <br> use {@link #setValue(Object) setValue} to set the value later
     */
    public ValidatedObservableField() {
    }

    /***
     * Set the new value, if new value is different from previous one, the will be changed and validated immediately.
     * @param value - the new value
     */
    public void setValue(T value) {
        if (value != null && !value.equals(this.value)) {
            this.value = value;
            if (!validate()) {
                notifyChange();
            }
        }
    }

    /***
     * Set new rule, the current one will be replaced
     * @param rule - the new rule
     */
    public void setRule(Rule<T> rule) {
        this.rule = rule;
    }

    /***
     * Get the current value
     * @return - the current value
     */
    public T getValue() {
        return value;
    }

    /***
     * Tells if field is valid.
     * <br> return the saved value
     * <br> have to call {@link #validate() validate} before to get correct value
     * @return - the saved information about is this field valid
     */
    public boolean isValid() {
        return isValid;
    }

    /***
     * Return the error message.
     * <br> call {@link #validate() validate} before to get correct value
     * @return - null if no message or error massage returned by {@link Rule#getErrorMessage()}.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /***
     * Set the new error message.
     * <br> If the new error message is not the same as current one it will be changed.
     * <br> Also call {@link BaseObservable#notifyChange}
     * @param errorMessage - the new error message
     */
    public void setErrorMessage(String errorMessage) {
        if (errorMessage == null) {
            hideErrorMessage();
        } else if (!errorMessage.equals(this.errorMessage)) {
            this.errorMessage = errorMessage;
            notifyChange();
        }
    }

    /***
     * Validate the field it there is a rule {@link Rule} to valid it.
     * <br> Set the error message from {@link Rule#getErrorMessage()}
     * <br> This method is called by: {@link #setValue(Object)} and in constructor {@link #ValidatedObservableField(Object, Rule, boolean)}
     * <br> Also call {@link BaseObservable#notifyChange}
     * @return - true if there is a rule {@link Rule} and {@link BaseObservable#notifyChange} was called
     */
    public boolean validate() {
        if (rule != null) {
            isValid = rule.isValid(getValue());
            errorMessage = isValid ? null : rule.getErrorMessage();
            notifyChange();
            return true;
        }
        return false;
    }

    /***
     * Hide the error message.
     * <br> Also call {@link BaseObservable#notifyChange}
     * <br> the field still can be not valid!
     */
    public void hideErrorMessage() {
        if (errorMessage != null) {
            errorMessage = null;
            notifyChange();
        }
    }
}
