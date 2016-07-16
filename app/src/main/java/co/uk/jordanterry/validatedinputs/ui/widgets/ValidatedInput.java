package co.uk.jordanterry.validatedinputs.ui.widgets;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.uk.jordanterry.validatedinputs.validators.Validator;

/**
 * An abstract class that contains base logic for a Validated Input
 */
public class ValidatedInput<T extends TextView> implements View.OnFocusChangeListener, TextWatcher {

    protected TextInputLayout inputParent;

    protected T input;

    private List<Validator> validators;


    public static <T extends TextView> ValidatedInput on(T input) {
        return new ValidatedInput(input);
    }

    public ValidatedInput(T input) {
        validators = new ArrayList<>();
        this.input = input;
        if (input.getParent() instanceof TextInputLayout) {
            inputParent = (TextInputLayout) input.getParent();
        }
        input.addTextChangedListener(this);
        input.setOnFocusChangeListener(this);
    }


    @Override
    public void onFocusChange(View view, boolean isFocused) {
        if (!isFocused) {
            validate(((T) view).getText().toString());
        }
    }


    /**
     * Validate the input of the text view with all validators
     */
    private void validate(String value) {
        for (int i = 0; i < validators.size(); i++) {
            if (!validators.get(i).validate(value)) {
                if (inputParent != null) {
                    inputParent.setError(validators.get(i).getValidationMessage());
                } else {
                    input.setError(validators.get(i).getValidationMessage());
                }
            }
        }
    }

    /**
     * Add a new validator to the validated input to be checked against
     * @param validator The validator
     */
    public void addValidator(Validator validator) {
        validators.add(validator);
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
