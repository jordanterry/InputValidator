package InputValidator.validators;

import InputValidator.InputValidator;

/**
 * The Validator interface defines an object that is used to validate input
 */
public interface Validator {

    /**
     * Validate the input of the input
     * @param input the value from the input
     * @return Return false if an error should be displayed. True if there input if valid.
     */
    boolean validate(String input);


    /**
     * A string to be displayed if the validation has failed
     * @return a String
     */
    String getValidationMessage();

}
