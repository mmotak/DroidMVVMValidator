package pl.com.mmotak.validator.rules;

public class MaximumLengthRule extends AbstractRule<String> {
    private int max;

    public MaximumLengthRule(int max, String error) {
        super(error);
        this.max = max;
    }

    @Override
    public boolean isValid(String s) {
        return s != null && s.length() <= max;
    }
}
