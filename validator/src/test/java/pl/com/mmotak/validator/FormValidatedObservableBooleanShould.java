package pl.com.mmotak.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maciej on 2017-03-19.
 */

public class FormValidatedObservableBooleanShould {

    private FormValidatedObservableBoolean form;
    private Rule<Integer> ageRule = new Rule<Integer>() {
        @Override
        public boolean isValid(Integer integer) {
            return integer > 17;
        }

        @Override
        public String getErrorMessage() {
            return "Not adult";
        }
    };

    @Test
    public void notBeValidIfCreatedWithNoParameters() {
        form = new FormValidatedObservableBoolean();
        assertFalse(form.get());
    }

    @Test
    public void notBeValidIfCreatedWithNullParameter() {
        form = new FormValidatedObservableBoolean(null);
        assertFalse(form.get());
    }

    @Test
    public void notBeValidIfCreatedWithOneInvalidParameter() {
        ValidatedObservableField<Integer> age = new ValidatedObservableField<Integer>(1, ageRule, true);
        form = new FormValidatedObservableBoolean(age);
        assertFalse(form.get());
    }

    @Test
    public void beValidIfCreatedWithOneValidParameter() {
        ValidatedObservableField<Integer> age = new ValidatedObservableField<Integer>(23, ageRule, true);
        form = new FormValidatedObservableBoolean(age);
        assertTrue(form.get());
    }

    @Test
    public void becomeValidIfCreatedWithOneInvalidParameterAndParameterBecomeValid() {
        ValidatedObservableField<Integer> age = new ValidatedObservableField<Integer>(1, ageRule, true);
        form = new FormValidatedObservableBoolean(age);

        age.setValue(new Integer(22));
        assertTrue(form.get());
    }

    @Test
    public void notBeValidIfCreatedWithOtLeastOneInvalidParameter() {
        ValidatedObservableField<Integer> age1 = new ValidatedObservableField<Integer>(1, ageRule, true);
        ValidatedObservableField<Integer> age2 = new ValidatedObservableField<Integer>(23, ageRule, true);
        ValidatedObservableField<Integer> age3 = new ValidatedObservableField<Integer>(45, ageRule, true);
        form = new FormValidatedObservableBoolean(age3, age1, age2);
        assertFalse(form.get());
    }

    @Test
    public void becomeValidWhenAllParametersBecomeValid() {
        ValidatedObservableField<Integer> age1 = new ValidatedObservableField<Integer>(1, ageRule, true);
        ValidatedObservableField<Integer> age2 = new ValidatedObservableField<Integer>(23, ageRule, true);
        ValidatedObservableField<Integer> age3 = new ValidatedObservableField<Integer>(45, ageRule, true);
        form = new FormValidatedObservableBoolean(age3, age1, age2);

        age1.setValue(24);

        assertTrue(form.get());
    }

    @Test
    public void notBecomeValidWhenAtLeastOneParameterIsInvalid() {
        ValidatedObservableField<Integer> age1 = new ValidatedObservableField<Integer>(1, ageRule, true);
        ValidatedObservableField<Integer> age2 = new ValidatedObservableField<Integer>(23, ageRule, true);
        ValidatedObservableField<Integer> age3 = new ValidatedObservableField<Integer>(45, ageRule, true);
        form = new FormValidatedObservableBoolean(age3, age1, age2);

        age1.setValue(24);
        age2.setValue(1);

        assertFalse(form.get());
    }

    @Test
    public void stillBeValidIfTheErrorMessageWasSetManually() {
        ValidatedObservableField<Integer> age = new ValidatedObservableField<Integer>(45, ageRule, true);
        form = new FormValidatedObservableBoolean(age);

        age.setErrorMessage("Something went wrong !");

        assertTrue(form.get());
    }
}
