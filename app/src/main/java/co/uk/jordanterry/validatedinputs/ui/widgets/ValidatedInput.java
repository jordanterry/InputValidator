package co.uk.jordanterry.validatedinputs.ui.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.uk.jordanterry.validatedinputs.validators.Validator;
import co.uk.jordanterry.validatoredittext.R;

/**
 * An abstract class that contains base logic for a Validated Input
 */
public abstract class ValidatedInput<T extends TextView> extends LinearLayout
        implements View.OnFocusChangeListener {

    protected TextInputLayout validatedContainer;

    protected TextInputEditText validatedEditText;

    private String hint;

    private List<Validator> validators;

    public ValidatedInput(Context context) {
        super(context);
        initView(context);
    }

    public ValidatedInput(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        initView(context);
    }

    public ValidatedInput(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initView(context);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ValidatedInput(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttrs(context, attrs);
        initView(context);
    }


    /**
     * Initialise any views
     * @param context the context
     */
    protected abstract void initView(Context context);

    /**
     * Initialise any attributes for the view
     */
    protected void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray;
        typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.ValidatedEditText);
        hint = typedArray
                .getString(R.styleable.ValidatedEditText_hint);
        typedArray.recycle();
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        validators = new ArrayList<>();
        validatedContainer = (TextInputLayout) findViewById(R.id.validated_container);
        validatedEditText = (TextInputEditText) findViewById(R.id.validated_input);
        validatedEditText.setOnFocusChangeListener(this);
        if (hint != null) {
            validatedContainer.setHint(hint);
        }
    }

    @Override
    public void onFocusChange(View view, boolean isFocused) {
        if (isFocused) {
            validatedContainer.setErrorEnabled(false);
            validatedContainer.setError(null);
        } else {
            validate(((T) view).getText().toString());
        }
    }


    /**
     * Validate the input of the text view with all validators
     */
    private void validate(String input) {
        for (int i = 0; i < validators.size(); i++) {
            if (!validators.get(i).validate(input)) {
                validatedContainer.setError(validators.get(i).getValidationMessage());
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

}
