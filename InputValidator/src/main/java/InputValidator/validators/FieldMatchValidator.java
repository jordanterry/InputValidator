package InputValidator.validators;

import android.widget.TextView;

/**
 * Can be used to match the value of an input against the value currently being checked.
 */

public class FieldMatchValidator<T extends TextView> implements Validator {

    private T inputField;

    public FieldMatchValidator(T inputField) {
        this.inputField = inputField;
    }

    @Override
    public boolean validate(String input) {
        return inputField.getText().toString().equals(input);
    }

    @Override
    public String getValidationMessage() {
        return "The inputs do not match.";
    }
}
