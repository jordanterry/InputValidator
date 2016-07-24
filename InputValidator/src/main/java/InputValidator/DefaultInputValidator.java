package InputValidator;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import InputValidator.validators.Validator;

/**
 * A default implementation of an InputValidator.
 */
class DefaultInputValidator<T extends TextView> implements InputValidator,
        View.OnFocusChangeListener, TextWatcher {

    /**
     * The inputs parent if it exists
     */
    protected TextInputLayout inputParent;

    /**
     * The input being validated
     */
    protected T input;

    /**
     * A list of validators that the input's value will be tested against
     */
    private List<Validator> validators;

    /**
     * A validation error listener. If the listener is set the library will return the validation
     * error, the input and the input parent to the listener.
     */
    private InputValidator.OnValidationErrorListener<T> onValidationErrorListener;


    /**
     * Constructor for the ValidatedInput
     * @param input An input to be validated that extends from a TextView
     */
    public DefaultInputValidator(T input) {
        validators = new ArrayList<>();
        this.input = input;
        if (input.getParent() instanceof TextInputLayout) {
            inputParent = (TextInputLayout) input.getParent();
        }
        input.addTextChangedListener(this);
        input.setOnFocusChangeListener(this);
    }




    /**
     * Validate the input of the text view validate all validators
     */
    private void validate(String value) {
        for (int i = 0; i < validators.size(); i++) {
            if (!validators.get(i).validate(value)) {
                if (onValidationErrorListener == null) {
                    if (inputParent != null) {
                        inputParent.setError(validators.get(i).getValidationMessage());
                    } else {
                        input.setError(validators.get(i).getValidationMessage());
                    }
                } else {
                    onValidationErrorListener.onError(input, inputParent,
                            validators.get(i).getValidationMessage());
                }
            }
        }
    }

    @Override
    public DefaultInputValidator<T> addValidator(Validator validator) {
        validators.add(validator);
        return this;
    }


    @Override
    public boolean isValid() {

        String value = input.getText().toString();
        for (int i = 0; i < validators.size(); i++) {
            if (!validators.get(i).validate(value)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public T getInput() {
        return input;
    }

    @Override
    public boolean removeValidationErrorListener() {
        if (onValidationErrorListener == null) {
            return false;
        }
        onValidationErrorListener = null;
        return true;
    }

    @Override
    public void setValidationErrorListener(InputValidator.OnValidationErrorListener onValidationErrorListener) {
        this.onValidationErrorListener = onValidationErrorListener;
    }


    @Override
    public void onFocusChange(View view, boolean isFocused) {
        if (!isFocused) {
            validate(((T) view).getText().toString());
        }
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        // Empty
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (inputParent != null) {
            inputParent.setErrorEnabled(false);
            inputParent.setError(null);
        } else {
            input.setError(null);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        // Empty
    }
}
