package pl.com.mmotak.sample.viewModels;

import android.databinding.ObservableBoolean;
import android.view.View;
import android.widget.Toast;

import pl.com.mmotak.validator.RuleCommand;
import pl.com.mmotak.validator.ValidatedObservableField;
import pl.com.mmotak.validator.rules.ValidatorRule;

/**
 * Created by Maciej on 2017-03-13.
 */

public class LambdaRulesExampleViewModel {

    public final ObservableBoolean passwordVisible = new ObservableBoolean(false);

    public final ValidatedObservableField<String> userName = new ValidatedObservableField<>("",
            new RuleCommand.Builder<String>()
                    .withRule(s -> s != null && s.matches("[\\S]+"), "Whitespace characters not allowed") // THE ORDER IS IMPORTANT!
                    .withRule(s -> s != null && s.length() >= 3, "Three or more characters")
                    .withRule(s -> s != null && s.length() <= 12, "No more then twelve characters")
                    .build());

    public final ValidatedObservableField<String> password = new ValidatedObservableField<>("",
            new RuleCommand.Builder<String>()
                    .withRule(new ValidatorRule<>(s -> s != null && s.matches("[\\S]+"), "Whitespace characters not allowed")) // THE ORDER IS IMPORTANT!
                    .withRule(new ValidatorRule<>(s -> s != null && s.matches(".*[A-Z]+.*"), "Must contain capital letters"))
                    .withRule(new ValidatorRule<>(s -> s != null && s.matches(".*[0-9]+.*"), "Must contain digits"))
                    .withRule(new ValidatorRule<>(s -> s != null && s.matches(".*[a-z]+.*"), "Must contain small letters"))
                    .withRule(s -> s != null && s.length() >= 3, "Three or more characters")
                    .withRule(s -> s != null && s.length() <= 12, "No more then twelve characters")
                    .build());

    public void onViewClick(View view) {
        if (userName.isValid() && password.isValid()) {
            Toast.makeText(view.getContext(), "ALL OK !", Toast.LENGTH_LONG).show();
        }
    }
}
