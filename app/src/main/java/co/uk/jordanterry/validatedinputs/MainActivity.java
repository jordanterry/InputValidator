package co.uk.jordanterry.validatedinputs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import InputValidator.ValidatorFactory;
import InputValidator.validators.TextEmptyValidator;
import co.uk.jordanterry.validatoredittext.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ValidatorFactory.with((EditText) findViewById(R.id.first_name)).addValidator(new TextEmptyValidator());
        ValidatorFactory.with((EditText) findViewById(R.id.last_name)).addValidator(new TextEmptyValidator());

    }
}
