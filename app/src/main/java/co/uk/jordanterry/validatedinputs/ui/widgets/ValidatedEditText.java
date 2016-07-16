package co.uk.jordanterry.validatedinputs.ui.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import co.uk.jordanterry.validatedinputs.validators.Validator;
import co.uk.jordanterry.validatoredittext.R;

/**
 * A Validated Edit Text contains content will be checked against a set of {@link Validator}s
 */
public class ValidatedEditText extends LinearLayout {

    private TextInputLayout validatedContainer;

    private TextInputEditText validatedEditText;

    public ValidatedEditText(Context context) {
        super(context);
        init(context);
    }

    public ValidatedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ValidatedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ValidatedEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.validated_edit_text, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        validatedContainer = (TextInputLayout) findViewById(R.id.validated_container);
        validatedEditText = (TextInputEditText) findViewById(R.id.validated_input);
    }


}
