package co.uk.jordanterry.validatedinputs.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A {@link Validator} to check if an e-mail is valid.
 */
public class EmailValidator implements Validator {

    @Override
    public boolean validate(String input) {
        Pattern p = Pattern.compile("(\\.|@)");
        Matcher m = p.matcher(input);
        return m.find();
    }

    @Override
    public String getValidationMessage() {
        return "E-mail is invalid";
    }

}
