package pl.com.mmotak.validator;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maciej on 2017-03-12.
 */

public class ValidatedObservableFieldCreatedByFullConstructorShould {

    private ValidatedObservableField<Integer> field;
    private Integer validStartObject = new Integer(2);
    private Integer invalidStartObject = new Integer(121);
    private final String errorMessage = "Value have to be div by 2";

    private Rule<Integer> ruleDivByTwo = new Rule<Integer>() {
        @Override
        public boolean isValid(Integer o) {
            return o != null && o % 2 == 0;
        }

        @Override
        public String getErrorMessage() {
            return errorMessage;
        }
    };

    @Test
    public void beValidatedIfCreatedWithValidStartValue() {
        field = new ValidatedObservableField<>(validStartObject, ruleDivByTwo, true);
        assertTrue(field.isValid());
    }

    @Test
    public void returnNullErrorMessageIfCreatedWithValidStartValue() {
        field = new ValidatedObservableField<>(validStartObject, ruleDivByTwo, true);
        assertNull(field.getErrorMessage());
    }


    @Test
    public void notBeValidatedIfCreatedWithInvalidStartValue() {
        field = new ValidatedObservableField<>(invalidStartObject, ruleDivByTwo, true);
        assertFalse(field.isValid());
    }

    @Test
    public void returnNotNullErrorMessageIfCreatedWithInvalidStartValue() {
        field = new ValidatedObservableField<>(invalidStartObject, ruleDivByTwo, true);
        assertNotNull(field.getErrorMessage());
    }

    @Test
    public void returnCorrectErrorMessageIfCreatedWithInvalidStartValue() {
        field = new ValidatedObservableField<>(invalidStartObject, ruleDivByTwo, true);
        assertEquals(errorMessage, field.getErrorMessage());
    }
}
