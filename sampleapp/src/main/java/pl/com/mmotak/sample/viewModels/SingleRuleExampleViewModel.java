package pl.com.mmotak.sample.viewModels;

import pl.com.mmotak.validator.Rule;
import pl.com.mmotak.validator.ValidatedObservableField;
import pl.com.mmotak.validator.rules.MinimumLengthRule;

/**
 * Created by Maciej on 2017-03-11.
 */

public class SingleRuleExampleViewModel {

    public ValidatedObservableField<Integer> age = new ValidatedObservableField<>(null,
            new Rule<Integer>() {
                @Override
                public boolean isValid(Integer integer) {
                    return integer != null && integer >= 18;
                }

                @Override
                public String getErrorMessage() {
                    return "You have to be adult";
                }
            });

    public ValidatedObservableField<String> name = new ValidatedObservableField<>(null, new MinimumLengthRule(1, "Name cannot be empty"));
}
