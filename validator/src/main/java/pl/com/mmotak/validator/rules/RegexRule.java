package pl.com.mmotak.validator.rules;

public class RegexRule extends AbstractRule<String> {
    private String regex;

    /***
     * Rule that validate if entered String is matches by given regex.
     * @param regex - the given regex @see <a href="http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html">regex</a>
     * @param error - the error message if not matches
     */
    public RegexRule(String regex, String error) {
        super(error);
        this.regex = regex;
    }

    @Override
    public boolean isValid(String s) {
        return s != null && s.matches(regex);
    }
}