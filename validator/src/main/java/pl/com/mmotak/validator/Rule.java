package pl.com.mmotak.validator;


public interface Rule<T> {

    /***
     * check if given value <code>t</code> is valid
     * @param t - the value to valid
     * @return - true if valid
     */
    boolean isValid(T t);

    /***
     * Return the error message if rule is not valid
     * @return - null (if valid) or error message (if not valid)
     */
    String getErrorMessage();
}
