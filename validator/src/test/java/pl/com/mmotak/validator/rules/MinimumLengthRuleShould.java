package pl.com.mmotak.validator.rules;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maciej on 2017-03-25.
 */

public class MinimumLengthRuleShould {

    private static final String ERROR_MESSAGE = "error message";
    private static final String EMPTY = "";

    @Test
    public void beNotValidForNullString() {
        MinimumLengthRule rule = new MinimumLengthRule(0, ERROR_MESSAGE);

        assertFalse(rule.isValid(null));
    }

    @Test
    public void beValidForEmptyStringIfMinimumLengthIsZero() {
        MinimumLengthRule rule = new MinimumLengthRule(0, ERROR_MESSAGE);

        assertTrue(rule.isValid(EMPTY));
    }

    @Test
    public void beNotValidForEmptyStringIfMinimumLengthIsGreaterThenZero() {
        MinimumLengthRule rule = new MinimumLengthRule(1, ERROR_MESSAGE);

        assertFalse(rule.isValid(EMPTY));
    }

    @Test
    public void beNotValidForStringWithLengthLowerThenEnteredMinimumLengthValue() {
        String messageToValid = "12345678";
        int minimum = 9;

        MinimumLengthRule rule = new MinimumLengthRule(minimum, ERROR_MESSAGE);

        assertEquals(minimum, messageToValid.length() + 1);
        assertFalse(rule.isValid(messageToValid));
    }

    @Test
    public void beValidForStringWithLengthTheSameAsMinimumLengthValue() {
        String messageToValid = "123456789";
        int minimum = 9;

        MinimumLengthRule rule = new MinimumLengthRule(minimum, ERROR_MESSAGE);

        assertEquals(minimum, messageToValid.length());
        assertTrue(rule.isValid(messageToValid));
    }

    @Test
    public void beValidForStringWithLengthGreaterThenAsMinimumLengthValue() {
        String messageToValid = "1234567890";
        int minimum = 9;

        MinimumLengthRule rule = new MinimumLengthRule(minimum, ERROR_MESSAGE);

        assertEquals(minimum + 1, messageToValid.length());
        assertTrue(rule.isValid(messageToValid));
    }

    @Test
    public void returnErrorMessageGivenInConstructor() {
        MinimumLengthRule rule = new MinimumLengthRule(0, ERROR_MESSAGE);

        assertEquals(ERROR_MESSAGE, rule.getErrorMessage());
    }
}
