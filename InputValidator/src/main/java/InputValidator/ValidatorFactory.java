package InputValidator;

import android.widget.TextView;

/**
 * A factory to create an {@link InputValidator}
 */
public class ValidatorFactory {

    /**
     * Create a validated input passed into the method.
     * @param input The input to be validated
     * @param <T> a generic object that extends TextView
     * @return Validated Input object
     */
    public static <T extends TextView> InputValidator with(T input) {
        return new DefaultInputValidator<>(input);
    }


}
