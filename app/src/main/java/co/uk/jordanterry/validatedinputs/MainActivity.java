package co.uk.jordanterry.validatedinputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.uk.jordanterry.validatedinputs.ui.widgets.ValidatedEditText;
import co.uk.jordanterry.validatedinputs.validators.Validator;
import co.uk.jordanterry.validatoredittext.R;

public class MainActivity extends AppCompatActivity {

    ValidatedEditText validatedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        validatedEditText = (ValidatedEditText) findViewById(R.id.test_input);
        validatedEditText.addValidator(new Validator() {
            @Override
            public boolean validate(String input) {
                return false;
            }

            @Override
            public String getValidationMessage() {
                return getString(R.string.test_error);
            }
        });
    }
}
