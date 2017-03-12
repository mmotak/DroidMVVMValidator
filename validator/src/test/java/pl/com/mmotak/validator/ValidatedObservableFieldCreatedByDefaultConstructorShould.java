package pl.com.mmotak.validator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Maciej on 2017-03-12.
 */

public class ValidatedObservableFieldCreatedByDefaultConstructorShould {

    private ValidatedObservableField<Object> field;

    @Before
    public void setUp() {
        field = new ValidatedObservableField<>();
    }

    @Test
    public void returnNullValue() {
        assertEquals(null, field.getValue());
    }

    @Test
    public void notBeValid() {
        assertFalse(field.isValid());
    }

    @Test
    public void returnNullForErrorMessage() {
        assertNull(field.getErrorMessage());
    }

    @Test
    public void notBeValidAfterSetNewValue() {
        field.setValue(new Object());

        assertFalse(field.isValid());
    }

    @Test
    public void returnNullForErrorMessageAfterSetNewValue() {
        field.setValue(new Object());

        assertNull(field.getErrorMessage());
    }
}
