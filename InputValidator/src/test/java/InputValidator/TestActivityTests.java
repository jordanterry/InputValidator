package InputValidator;

import android.support.design.widget.TextInputLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import InputValidator.activities.TestActivity;
import co.uk.jordanterry.inputvalidator.BuildConfig;
import co.uk.jordanterry.inputvalidator.R;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jordanterry on 24/07/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class TestActivityTests {


    private TestActivity activity;
    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private TextView errorText;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(TestActivity.class)
                .create().resume().get();
        firstName = (TextView) activity.findViewById(R.id.first_name);
        lastName = (TextView) activity.findViewById(R.id.last_name);
        email = (TextView) activity.findViewById(R.id.email);
        errorText = (TextView) activity.findViewById(R.id.error_text);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }


    @Test
    public void testFirstNameInvalid() {
        firstName.requestFocus();
        assertTrue(firstName.isFocused());
        firstName.clearFocus();
        lastName.requestFocus();
        assertFalse(firstName.isFocused());
        TextInputLayout firstNameParent = (TextInputLayout) firstName.getParent();
        assertNotNull(firstNameParent.getError());
    }

    @Test
    public void testFirstNameValid() {
        firstName.requestFocus();
        assertTrue(firstName.isFocused());
        firstName.setText("Test text");
        firstName.clearFocus();
        lastName.requestFocus();
        assertFalse(firstName.isFocused());
        TextInputLayout firstNameParent = (TextInputLayout) firstName.getParent();
        assertNull(firstNameParent.getError());
    }


    @Test
    public void testLastNameInvalid() {
        lastName.requestFocus();
        assertTrue(lastName.isFocused());
        lastName.clearFocus();
        firstName.requestFocus();
        assertFalse(lastName.isFocused());
        assertNotNull(lastName.getError());
    }


    @Test
    public void testLastNameValid() {
        lastName.requestFocus();
        assertTrue(lastName.isFocused());
        lastName.setText("Valid text");
        lastName.clearFocus();
        firstName.requestFocus();
        assertFalse(lastName.isFocused());
        assertNull(lastName.getError());
    }

    @Test
    public void testErrorListenerValidText() {
        email.requestFocus();
        assertTrue(email.isFocused());
        email.setText("Valid text");
        email.clearFocus();
        firstName.requestFocus();
        assertFalse(email.isFocused());
        assertTrue(errorText.getText().toString().isEmpty());
    }

    @Test
    public void testErrorListenerInvalidText() {

        email.requestFocus();
        assertTrue(email.isFocused());
        email.clearFocus();
        firstName.requestFocus();
        assertFalse(email.isFocused());
        assertFalse(errorText.getText().toString().isEmpty());
    }
}
