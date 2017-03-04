package pl.com.mmotak.validator;


public interface Rule<T> {

    boolean isValid(T t);
    String getErrorMessage();
}
