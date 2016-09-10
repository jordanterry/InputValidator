package InputValidator.validators;

/**
 * Class used to check that the input is a valid url.
 */

public class UrlValidator implements Validator {

    @Override
    public boolean validate(String input) {
        return false;
    }

    @Override
    public String getValidationMessage() {
        return "The input is not a valid URL.";
    }

}
