package pl.com.mmotak.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Created by Maciej on 2017-03-12.
 */

public class ValidatedObservableFieldCreatedByOneArgumentConstructorShould {

    private ValidatedObservableField<Object> field;
    private Object startObject = new Object();

    @Before
    public void setUp() {
        field = new ValidatedObservableField<>(startObject);
    }

    @Test
    public void returnGivenInConstructorValue() {
        assertEquals(startObject, field.getValue());
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
        field.setValue(null);

        assertFalse(field.isValid());
    }

    @Test
    public void returnNullForErrorMessageAfterSetNewValue() {
        field.setValue(new Object());

        assertNull(field.getErrorMessage());
    }
}
