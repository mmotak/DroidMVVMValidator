package pl.com.mmotak.validator;


import java.util.ArrayList;
import java.util.List;

public class RuleCommand<T> implements Rule<T> {

    private List<Rule<T>> rules = new ArrayList<>();
    private String error;

    private RuleCommand(List<Rule<T>> rules) {
        this.rules.addAll(rules);
    }

    @Override
    public boolean isValid(T t) {
        for (Rule<T> rule: rules) {
            if (!rule.isValid(t)) {
                error = rule.getErrorMessage();
                return false;
            }
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return error;
    }

    public static class Builder<T> {
        private List<Rule<T>> rules = new ArrayList<>();

        public RuleCommand<T> build() {
            return new RuleCommand<T>(rules);
        }

        public Builder<T> withRule(Rule<T> rule) {
            rules.add(rule);
            return this;
        }
    }
}
