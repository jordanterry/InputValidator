package InputValidator.validators;

/**
 * A {@link Validator} to validate an empty text view
 */
public class TextEmptyValidator implements Validator {

    @Override
    public boolean validate(CharSequence input) {
        return !(input == null || input.length() == 0);
    }

    @Override
    public String getValidationMessage() {
        return "The text view is empty.";
    }

}
