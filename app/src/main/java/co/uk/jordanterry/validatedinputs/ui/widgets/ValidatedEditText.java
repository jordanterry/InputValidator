package co.uk.jordanterry.validatedinputs.ui.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;

import co.uk.jordanterry.validatedinputs.validators.Validator;
import co.uk.jordanterry.validatoredittext.R;

/**
 * A Validated Edit Text contains content will be checked against a set of {@link Validator}s
 */
public class ValidatedEditText extends ValidatedInput<EditText> implements TextWatcher {

    public ValidatedEditText(Context context) {
        super(context);
    }

    public ValidatedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ValidatedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ValidatedEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.validated_edit_text, this);
    }



    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
