package co.uk.jordanterry.validatedinputs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.uk.jordanterry.validatedinputs.ui.widgets.ValidatedEditText;
import co.uk.jordanterry.validatedinputs.validators.TextEmptyValidator;
import co.uk.jordanterry.validatoredittext.R;

public class MainActivity extends AppCompatActivity {

    ValidatedEditText validatedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        validatedEditText = (ValidatedEditText) findViewById(R.id.test_input);
        validatedEditText.addValidator(new TextEmptyValidator());
    }
}
