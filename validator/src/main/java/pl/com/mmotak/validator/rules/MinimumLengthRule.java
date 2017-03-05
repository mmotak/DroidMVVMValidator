package pl.com.mmotak.validator.rules;

public class MinimumLengthRule extends AbstractRule<String> {
    private int min;

    public MinimumLengthRule(int min, String error) {
        super(error);
        this.min = min;
    }

    @Override
    public boolean isValid(String s) {
        return s != null && s.length() >= min;
    }
}
