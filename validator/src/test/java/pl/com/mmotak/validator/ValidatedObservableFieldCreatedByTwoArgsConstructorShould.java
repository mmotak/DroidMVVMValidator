package pl.com.mmotak.validator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maciej on 2017-03-12.
 */

public class ValidatedObservableFieldCreatedByTwoArgsConstructorShould {

    private ValidatedObservableField<Integer> field;
    private Integer startObject = new Integer(2);

    private Rule<Integer> ruleDivByTwo = new Rule<Integer>() {
        @Override
        public boolean isValid(Integer o) {
            return o != null && o % 2 == 0;
        }

        @Override
        public String getErrorMessage() {
            return "Value have to be div by 2";
        }
    };

    private Rule<Integer> ruleDivBySeven = new Rule<Integer>() {
        @Override
        public boolean isValid(Integer o) {
            return o != null && o % 7 == 0;
        }

        @Override
        public String getErrorMessage() {
            return "Value have to be div by 7";
        }
    };

    @Before
    public void setUp() {
        field = new ValidatedObservableField<>(startObject, ruleDivByTwo);
    }

    @Test
    public void beValidAfterManualValidation() {
        field.validate();
        assertTrue(field.isValid());
    }

    @Test
    public void returnStartObjectValue() {
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
    public void beValidAfterSetNewValidValue() {
        field.setValue(new Integer(6));

        assertTrue(field.isValid());
    }

    @Test
    public void notBeValidAfterSetTheSameValue() {
        field.setValue(startObject);

        assertFalse(field.isValid());
    }

    @Test
    public void returnNullForErrorMessageAfterSetNewValidValue() {
        field.setValue(new Integer(10));

        assertNull(field.getErrorMessage());
    }

    @Test
    public void returnErrorMessageAfterSetInvalidValue() {
        field.setValue(new Integer(3));

        assertNotNull(field.getErrorMessage());
    }

    @Test
    public void returnNullErrorMessageAfterSetInvalidValueAndHideErrorMessage() {
        field.setValue(new Integer(3));
        field.hideErrorMessage();

        assertNull(field.getErrorMessage());
    }

    @Test
    public void returnErrorMessageAfterSetInvalidValueAndHideErrorMessageAndSetNextInvalidValue() {
        field.setValue(new Integer(3));
        field.hideErrorMessage();
        field.setValue(new Integer(5));

        assertNotNull(field.getErrorMessage());
    }

    @Test
    public void notBeValidAfterSetNewDifferentRule() {
        field.setRule(ruleDivBySeven);
        assertFalse(field.isValid());
    }

    @Test
    public void beValidAfterSetValidValueAndThenSetNewDifferentRule() {
        field.setValue(new Integer(4));
        field.setRule(ruleDivBySeven);
        assertTrue(field.isValid());
    }

    @Test
    public void notBeValidAfterSetInvalidValueAndThenSetNewDifferentRule() {
        field.setValue(new Integer(77));
        field.setRule(ruleDivBySeven);
        assertFalse(field.isValid());
    }

    @Test
    public void setNewErrorMessageAfterValid() {
        field.setValue(new Integer(9));
        field.hideErrorMessage();
        field.validate();
        assertNotNull(field.getErrorMessage());
    }

}
