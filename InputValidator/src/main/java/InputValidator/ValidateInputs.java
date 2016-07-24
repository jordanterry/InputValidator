package InputValidator;

import android.support.annotation.NonNull;
import android.widget.TextView;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * A factory to create an {@link InputValidator}
 */
public class ValidateInputs {

    /**
     * Create a validated input passed into the method.
     * @param input the input to be validated
     * @param <T> a generic object that extends TextView
     * @return A validated input object
     */
    public static <T extends TextView> InputValidator validate(@NonNull T input) {
        return new DefaultInputValidator<>(input);
    }


    /**
     * Create a List of validated inputs by passing 1..n inputs
     * @param inputs 1..n inputs
     * @param <T> a generic object that extends TextView
     * @return a List of validated input objects.
     */
    public static <T extends TextView> List<InputValidator> validate(@NonNull  T... inputs) {
        if (inputs.length == 0) {
            throw new InvalidParameterException();
        }
        List<InputValidator> validators = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            validators.add(new DefaultInputValidator(inputs[i]));
        }
        return validators;
    }



}
