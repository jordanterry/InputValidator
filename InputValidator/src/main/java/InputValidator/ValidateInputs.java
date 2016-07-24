package InputValidator;

import android.widget.TextView;

/**
 * A factory to create an {@link InputValidator}
 */
public class ValidateInputs {

    /**
     * Create a validated input passed into the method.
     * @param input The input to be validated
     * @param <T> a generic object that extends TextView
     * @return Validated Input object
     */
    public static <T extends TextView> InputValidator validate(T input) {
        return new DefaultInputValidator<>(input);
    }


}
