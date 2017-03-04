package pl.com.mmotak.sample;

import android.view.View;
import android.widget.Toast;

import pl.com.mmotak.validator.rules.MaximumLengthRule;
import pl.com.mmotak.validator.rules.MinimumLenghtRule;
import pl.com.mmotak.validator.rules.RegexRule;
import pl.com.mmotak.validator.RuleCommand;
import pl.com.mmotak.validator.ValidatedObservableField;

public class MainViewModel {

    public ValidatedObservableField<String> userName = new ValidatedObservableField<>("",
            new RuleCommand.Builder<String>()
                    .withRule(new RegexRule("[a-z]+", "Only small letters")) // THE ORDER IS IMPORTANT!
                    .withRule(new MinimumLenghtRule(3, "Three or more characters"))
                    .withRule(new MaximumLengthRule(12, "No more then twelve characters"))
                    .build());

    public ValidatedObservableField<String> password = new ValidatedObservableField<>("",
            new RuleCommand.Builder<String>()
                    .withRule(new RegexRule(".*[A-Z]+.*", "Must contain capital letters")) // THE ORDER IS IMPORTANT!
                    .withRule(new RegexRule(".*[0-9]+.*", "Must contain digits"))
                    .withRule(new RegexRule(".*[a-z]+.*", "Must contain small letters"))
                    .withRule(new MinimumLenghtRule(8, "Eight or more characters"))
                    .withRule(new MaximumLengthRule(16, "No more then sixteen characters"))
                    .build());

    public void onViewClick(View view) {
        if (userName.isValid() && password.isValid()) {
            Toast.makeText(view.getContext(), "ALL OK !", Toast.LENGTH_LONG).show();
        }
    }
}
