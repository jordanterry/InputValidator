package InputValidator.validators;

/**
 * A {@link Validator} to validate an empty text view
 */
public class TextEmptyValidator implements Validator {

    @Override
    public boolean validate(String input) {
        return !(input == null || input.isEmpty());
    }

    @Override
    public String getValidationMessage() {
        return "The text view is empty.";
    }

}
