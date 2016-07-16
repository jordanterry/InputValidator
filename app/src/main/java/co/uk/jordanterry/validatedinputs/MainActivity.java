package co.uk.jordanterry.validatedinputs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import co.uk.jordanterry.validatedinputs.validators.EmailValidator;
import co.uk.jordanterry.validatedinputs.validators.TextEmptyValidator;
import co.uk.jordanterry.validatoredittext.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValidatedInput.with((EditText) findViewById(R.id.first_name)).addValidator(new TextEmptyValidator());
        ValidatedInput.with((EditText) findViewById(R.id.last_name)).addValidator(new TextEmptyValidator());
        ValidatedInput.with((EditText) findViewById(R.id.email)).addValidator(new EmailValidator());

    }
}
