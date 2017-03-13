package pl.com.mmotak.validator;

/**
 * Created by Maciej on 2017-03-13.
 */

public interface Valid<T> {
    /***
     * check if given value <code>t</code> is valid
     * @param t - the value to valid
     * @return - true if valid
     */
    boolean isValid(T t);
}
