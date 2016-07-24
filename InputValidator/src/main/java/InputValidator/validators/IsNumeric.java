package InputValidator.validators;

/**
 * A {@link Validator} to validate an empty text view
 */
public class IsNumeric implements Validator {

    @Override
    public boolean validate(CharSequence input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getValidationMessage() {
        return "The text isn't numeric.";
    }

}
