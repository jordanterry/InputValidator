package InputValidator;

import android.widget.TextView;

/**
 * Definition of an InputValidator
 */
public interface InputValidator<T extends TextView> {

    /**
     * Add a new validator to the validated input to be checked against
     * @param validator The validator
     */
    InputValidator<T> addValidator(Validator validator);


    /**
     * A method to determine the validity of the input content without displaying an error.
     * @return boolean indicating if the input is valid
     */
    boolean isValid();


    /**
     * Get the input currently wrapped around.
     * @return T the input
     */
    T getInput();
}
