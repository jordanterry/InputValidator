package InputValidator;

import android.support.design.widget.TextInputLayout;
import android.widget.TextView;

import InputValidator.validators.Validator;

/**
 * Definition of an InputValidator
 */
public interface InputValidator<T extends TextView> {

    /**
     * Add a new validate to the validated input to be checked against
     * @param validator The validate
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

    /**
     * Set an OnValidationErrorListener
     * @param onValidationErrorListener A OnValidationErrorListener interface
     */
    void setValidationErrorListener(OnValidationErrorListener<T> onValidationErrorListener);

    /**
     * Remove the error listener
     * @return Returns a boolean, true if the listener existed and is removed. False if it doesn't exist and cannot be remvoed
     */
    boolean removeValidationErrorListener();


    interface OnValidationErrorListener<T extends TextView> {

        /**
         * This method will be called if there is a validation error
         * @param input The input being validated
         * @param inputParent A TextInputLayout parent, will be null if it doesn't exit
         * @param validationMessage The error returned from the validate object
         */
        void onError(T input, TextInputLayout inputParent, String validationMessage);

    }


}
