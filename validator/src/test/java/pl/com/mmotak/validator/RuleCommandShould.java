package pl.com.mmotak.validator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maciej on 2017-03-19.
 */

public class RuleCommandShould {

    private Rule<Object> notNullRule = new Rule<Object>() {
        @Override
        public boolean isValid(Object o) {
            return o != null;
        }

        @Override
        public String getErrorMessage() {
            return "cannot be null";
        }
    };

    private Rule<Object> rule = new Rule<Object>() {
        @Override
        public boolean isValid(Object o) {
            return true;
        }

        @Override
        public String getErrorMessage() {
            return "some error";
        }
    };

    private Rule<Integer> cannotBeNegativeRule = new Rule<Integer>() {
        @Override
        public boolean isValid(Integer integer) {
            return integer >= 0;
        }

        @Override
        public String getErrorMessage() {
            return "cannot be negative";
        }
    };

    private Rule<Integer> haveToBeDivByTwo = new Rule<Integer>() {
        @Override
        public boolean isValid(Integer integer) {
            return integer % 2 == 0;
        }

        @Override
        public String getErrorMessage() {
            return "have to by div by 2";
        }
    };

    private Rule<Integer> greaterThenSeven = new Rule<Integer>() {
        @Override
        public boolean isValid(Integer integer) {
            return integer > 7;
        }

        @Override
        public String getErrorMessage() {
            return "greater then seven";
        }
    };

    @Test
    public void beCreatedWithNoRules() {
        RuleCommand<?> ruleCommand = new RuleCommand.Builder<>().build();
        assertNotNull(ruleCommand);
    }

    @Test
    public void beCreatedWithOneRule() {
        RuleCommand<?> ruleCommand = new RuleCommand.Builder<>()
                .withRule(notNullRule)
                .build();

        assertNotNull(ruleCommand);
    }

    @Test
    public void beCreatedWithManyRules() {
        RuleCommand<?> ruleCommand = new RuleCommand.Builder<>()
                .withRule(notNullRule)
                .withRule(rule)
                .build();

        assertNotNull(ruleCommand);
    }

    @Test
    public void returnErrorMessageFromFirstRuleIfFirstRuleIsInvalid() {
        Integer testedValue = new Integer(-23);

        RuleCommand<Integer> ruleCommand = new RuleCommand.Builder<Integer>()
                .withRule(cannotBeNegativeRule)
                .withRule(haveToBeDivByTwo)
                .build();

        ruleCommand.isValid(testedValue);
        assertNotNull(ruleCommand.getErrorMessage());
        assertEquals(cannotBeNegativeRule.getErrorMessage() ,ruleCommand.getErrorMessage());
    }


    @Test
    public void notBeValidWhenFirstRuleIsInvalid() {
        Integer testedValue = new Integer(-23);

        RuleCommand<Integer> ruleCommand = new RuleCommand.Builder<Integer>()
                .withRule(cannotBeNegativeRule)
                .withRule(haveToBeDivByTwo)
                .build();

        assertFalse(cannotBeNegativeRule.isValid(testedValue));
        assertFalse(ruleCommand.isValid(testedValue));
    }

    @Test
    public void returnErrorMessageForInvalidRuleIfLastRuleIsInvalid() {
        Integer testedValue = new Integer(9);
        RuleCommand<Integer> ruleCommand = new RuleCommand.Builder<Integer>()
                .withRule(cannotBeNegativeRule)
                .withRule(greaterThenSeven)
                .withRule(haveToBeDivByTwo)
                .build();

        // test for each single rule
        assertTrue(cannotBeNegativeRule.isValid(testedValue));
        assertTrue(greaterThenSeven.isValid(testedValue));
        assertFalse(haveToBeDivByTwo.isValid(testedValue));

        ruleCommand.isValid(testedValue);
        assertNotNull(ruleCommand.getErrorMessage());
        assertEquals(haveToBeDivByTwo.getErrorMessage() ,ruleCommand.getErrorMessage());
    }

    @Test
    public void notBeValidIfLastRuleIsInvalid() {
        Integer testedValue = new Integer(9);
        RuleCommand<Integer> ruleCommand = new RuleCommand.Builder<Integer>()
                .withRule(cannotBeNegativeRule)
                .withRule(greaterThenSeven)
                .withRule(haveToBeDivByTwo)
                .build();

        // test for each single rule
        assertTrue(cannotBeNegativeRule.isValid(testedValue));
        assertTrue(greaterThenSeven.isValid(testedValue));
        assertFalse(haveToBeDivByTwo.isValid(testedValue));

        assertFalse(ruleCommand.isValid(testedValue));
    }

    @Test
    public void BeValidAndReturnNullErrorMessageIfAllRulesAreValid() {
        Integer testedValue = new Integer(12);
        RuleCommand<Integer> ruleCommand = new RuleCommand.Builder<Integer>()
                .withRule(cannotBeNegativeRule)
                .withRule(greaterThenSeven)
                .withRule(haveToBeDivByTwo)
                .build();

        // test for each single rule
        assertTrue(cannotBeNegativeRule.isValid(testedValue));
        assertTrue(greaterThenSeven.isValid(testedValue));
        assertTrue(haveToBeDivByTwo.isValid(testedValue));

        assertTrue(ruleCommand.isValid(testedValue));
        assertNull(ruleCommand.getErrorMessage());
    }

    @Test
    public void beAbleToAddRulesWithLabdas() {
        Integer testedValue = new Integer(12);
        RuleCommand<Integer> ruleCommand = new RuleCommand.Builder<Integer>()
                .withRule(new Valid<Integer>() {
                    @Override
                    public boolean isValid(Integer integer) {
                        return integer >= 0;
                    }
                }, "cannot be lower then 0")
                .withRule(greaterThenSeven)
                .withRule(haveToBeDivByTwo)
                .build();

        // test for each single rule
        assertTrue(cannotBeNegativeRule.isValid(testedValue));
        assertTrue(greaterThenSeven.isValid(testedValue));
        assertTrue(haveToBeDivByTwo.isValid(testedValue));

        assertTrue(ruleCommand.isValid(testedValue));
        assertNull(ruleCommand.getErrorMessage());
    }

}
