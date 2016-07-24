package InputValidator.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.TextView;

import InputValidator.InputValidator;
import InputValidator.ValidatorFactory;
import InputValidator.validators.TextEmptyValidator;
import co.uk.jordanterry.inputvalidator.R;


/**
 * Created by jordanterry on 24/07/16.
 */
public class TestActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Design_Light);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ValidatorFactory.with((TextView) findViewById(R.id.first_name)).addValidator(new TextEmptyValidator());
        ValidatorFactory.with((TextView) findViewById(R.id.last_name)).addValidator(new TextEmptyValidator());
        ValidatorFactory.with((TextView) findViewById(R.id.email)).addValidator(new TextEmptyValidator()).setValidationErrorListener(new InputValidator.OnValidationErrorListener() {
            @Override
            public void onError(TextView input, TextInputLayout inputParent, String validationMessage) {
                ((TextView) findViewById(R.id.error_text)).setText(validationMessage);
            }
        });

    }
}
