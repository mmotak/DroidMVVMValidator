package pl.com.mmotak.sample.viewModels;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.ObservableBoolean;

import pl.com.mmotak.validator.FormValidatedObservableBoolean;
import pl.com.mmotak.validator.Rule;
import pl.com.mmotak.validator.RuleCommand;
import pl.com.mmotak.validator.ValidatedObservableField;
import pl.com.mmotak.validator.rules.MaximumLengthRule;
import pl.com.mmotak.validator.rules.MinimumLengthRule;
import pl.com.mmotak.validator.rules.RegexRule;

/**
 * Created by Maciej on 2017-03-12.
 */

public class ChangePasswordViewModel {

    private RuleCommand.Builder<String> passwordRule = new RuleCommand.Builder<String>()
            .withRule(new RegexRule("[\\S]+", "Whitespace characters not allowed")) // THE ORDER IS IMPORTANT!
            .withRule(new RegexRule(".*[A-Z]+.*", "Must contain capital letters"))
            .withRule(new RegexRule(".*[0-9]+.*", "Must contain digits"))
            .withRule(new RegexRule(".*[a-z]+.*", "Must contain small letters"))
            .withRule(new MinimumLengthRule(8, "Eight or more characters"))
            .withRule(new MaximumLengthRule(16, "No more then sixteen characters"));
    //.build();

    public final ObservableBoolean passwordVisible = new ObservableBoolean(false);

    public final ValidatedObservableField<String> oldPassword = new ValidatedObservableField<>(
            "ThiIsMyOldPass09",
            passwordRule.build(),
            true);

    public final ValidatedObservableField<String> newPassword = new ValidatedObservableField<>("",
            passwordRule
                    .withRule(new Rule<String>() {
                        @Override
                        public boolean isValid(String s) {
                            return s != null && !s.equals(oldPassword.getValue());
                        }

                        @Override
                        public String getErrorMessage() {
                            return "Cannot be the same as old password";
                        }
                    })
                    .build());

    public final ValidatedObservableField<String> newPasswordRepeated = new ValidatedObservableField<>("",
            passwordRule
                    .withRule(new Rule<String>() {
                        @Override
                        public boolean isValid(String s) {
                            return s != null && s.equals(newPassword.getValue());
                        }

                        @Override
                        public String getErrorMessage() {
                            return "Have to be the same as new password";
                        }
                    })
                    .build());

    public final FormValidatedObservableBoolean validForm = new FormValidatedObservableBoolean(oldPassword, newPassword, newPasswordRepeated);

    public void onViewClick(View view) {

        oldPassword.setValue(newPassword.getValue());
        newPassword.setValue("");
        newPasswordRepeated.setValue("");

        newPassword.hideErrorMessage();
        newPasswordRepeated.hideErrorMessage();

        Toast.makeText(view.getContext(), "Password changed!", Toast.LENGTH_LONG).show();
    }
}
