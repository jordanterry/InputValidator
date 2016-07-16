package co.uk.jordanterry.validatedinputs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import co.uk.jordanterry.validatedinputs.ui.widgets.ValidatedInput;
import co.uk.jordanterry.validatedinputs.validators.TextEmptyValidator;
import co.uk.jordanterry.validatoredittext.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValidatedInput.on((EditText) findViewById(R.id.validated_input)).addValidator(new TextEmptyValidator());
        ValidatedInput.on((EditText) findViewById(R.id.normal_input)).addValidator(new TextEmptyValidator());

    }
}
