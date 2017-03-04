package pl.com.mmotak.validator.rules;

public class RegexRule extends AbstractRule<String> {
    private String regex;

    public RegexRule(String regex, String error) {
        super(error);
        this.regex = regex;
    }

    @Override
    public boolean isValid(String s) {
        return s != null && s.matches(regex);
    }
}