package co.uk.jordanterry.validatedinputs.validators;

import android.support.annotation.StringRes;

import co.uk.jordanterry.validatedinputs.ui.widgets.ValidatedEditText;

/**
 * The Validator interface defines an object that is used to validate input to a {@link ValidatedEditText}
 */
public interface Validator {

    boolean validate();

    @StringRes
    int getMessage();

}
