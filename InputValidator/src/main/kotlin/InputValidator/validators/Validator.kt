package InputValidator.validators

import android.widget.EditText

/**
 * The Validator interface defines an object that is used to validate input
 *
 * @author Jordan Terry
 */
interface Validator {

    /**
     * Validate the input of the input
     * @param input the value from the input
     * @return Return false if an error should be displayed. True if there input if valid.
     */
    fun validate(input: CharSequence) : Boolean

    /**
     * A string to be displayed if the validation has failed
     * @return a String
     */
    fun message() : String
}

/**
 * {@link Validator} for checking if the contents is empty
 *
 * @author Jordan Terry
 */
class IsEmptyValidator() : Validator {
    override fun validate(input: CharSequence) = input.isEmpty()
    override fun message() = "The text view is empty."
}

/**
 * {@link Validator} for checking if a string contains numeric values
 *
 * @author Jordan Terry
 */
class IsNumericValidator() : Validator {
    override fun validate(input: CharSequence) = input.filter { c -> c.isDigit() }.isNotEmpty()
    override fun message() = "The text isn't numeric."
}

/**
 * Extension property for containing an {@link ArrayList} of {@link Validator}
 */
val EditText.validators: ArrayList<Validator>
    get() = ArrayList<Validator>()

/**
 * Extension function for adding a validator to an {@link EditText}
 *
 * @param validator {@link Validator} to be added to the EditText
 */
fun EditText.addValidator(validator: Validator) {
    validators.add(validator)
}

/**
 * Extension function for adding a validator to an {@link EditText}
 *
 * @param validator {@link Validator} to be removed to the EditText
 */
fun EditText.removeValidator(validator: Validator) {
    validators.remove(validator)
}