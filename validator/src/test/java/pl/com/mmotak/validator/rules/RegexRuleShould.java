package pl.com.mmotak.validator.rules;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maciej on 2017-03-25.
 */

public class RegexRuleShould {

    private static final String ERROR_MESSAGE = "error message";
    private static final String EMPTY = "";

    private static final String ALL_CHARACTERS_REGEX = ".*";

    RegexRule noWhiteSpaces = new RegexRule("[\\S]+", "Whitespace characters not allowed");
    RegexRule mustContainCapitalLetters = new RegexRule(".*[A-Z]+.*", "Must contain capital letters");
    RegexRule mustContainDigits = new RegexRule(".*[0-9]+.*", "Must contain digits");
    RegexRule mustContainSmallLetters = new RegexRule(".*[a-z]+.*", "Must contain small letters");

    @Test
    public void notBeValidForNullValue() {
        RegexRule rule = new RegexRule(ALL_CHARACTERS_REGEX, ERROR_MESSAGE);
        assertFalse(rule.isValid(null));
    }

    @Test
    public void notValidateAfterEnter() {
        assertFalse(mustContainDigits.isValid("\n213"));
        assertFalse(noWhiteSpaces.isValid(" \n sdOnsd0 -=  "));
        assertFalse(mustContainCapitalLetters.isValid("\nASDAF"));
        assertFalse(mustContainSmallLetters.isValid("\ndsafdsgds"));
    }

    @Test
    public void beValidForWholeMessage() {
        assertFalse(noWhiteSpaces.isValid(" "));
        assertFalse(noWhiteSpaces.isValid("Ala ma"));
        assertTrue(mustContainDigits.isValid("Ala\t23121"));
    }

    @Test
    public void returnErrorMessageGivenInConstructor() {
        RegexRule rule = new RegexRule(ALL_CHARACTERS_REGEX, ERROR_MESSAGE);

        assertEquals(ERROR_MESSAGE, rule.getErrorMessage());
    }
}
