package InputValidator;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Instrumentation tests for the for the validator factory.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ValidatorFactoryTests {

    @Test
    public void testValidatorFactory() {
        InputValidator<EditText> validator = ValidatorFactory.with(new EditText(InstrumentationRegistry.getContext()));
        assertEquals(validator instanceof DefaultInputValidator, true);
    }

}
