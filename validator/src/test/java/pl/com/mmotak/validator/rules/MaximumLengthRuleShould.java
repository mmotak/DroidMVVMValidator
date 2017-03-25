package pl.com.mmotak.validator.rules;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maciej on 2017-03-25.
 */

public class MaximumLengthRuleShould {
    private static final String ERROR_MESSAGE = "error message";
    private static final String EMPTY = "";

    @Test
    public void beNotValidForNullString() {
        MaximumLengthRule rule = new MaximumLengthRule(0, ERROR_MESSAGE);

        assertFalse(rule.isValid(null));
    }

    @Test
    public void beValidForEmptyStringIfMaximumLengthIsZero() {
        MaximumLengthRule rule = new MaximumLengthRule(0, ERROR_MESSAGE);

        assertTrue(rule.isValid(EMPTY));
    }

    @Test
    public void beValidForEmptyStringIfMaximumLengthIsGreaterThenZero() {
        MaximumLengthRule rule = new MaximumLengthRule(1, ERROR_MESSAGE);

        assertTrue(rule.isValid(EMPTY));
    }

    @Test
    public void beValidForStringWithLengthLowerThenMaximumLength() {
        String messageToValid = "12345678";
        int minimum = 9;

        MaximumLengthRule rule = new MaximumLengthRule(minimum, ERROR_MESSAGE);

        assertEquals(minimum, messageToValid.length() + 1);
        assertTrue(rule.isValid(messageToValid));
    }

    @Test
    public void beValidForStringWithLengthTheSameAsMaximumLength() {
        String messageToValid = "123456789";
        int minimum = 9;

        MaximumLengthRule rule = new MaximumLengthRule(minimum, ERROR_MESSAGE);

        assertEquals(minimum, messageToValid.length());
        assertTrue(rule.isValid(messageToValid));
    }

    @Test
    public void beValidForStringWithLengthGreaterThenMaximumLength() {
        String messageToValid = "1234567890";
        int minimum = 9;

        MaximumLengthRule rule = new MaximumLengthRule(minimum, ERROR_MESSAGE);

        assertEquals(minimum + 1, messageToValid.length());
        assertFalse(rule.isValid(messageToValid));
    }

    @Test
    public void returnErrorMessageGivenInConstructor() {
        MaximumLengthRule rule = new MaximumLengthRule(0, ERROR_MESSAGE);

        assertEquals(ERROR_MESSAGE, rule.getErrorMessage());
    }
}
