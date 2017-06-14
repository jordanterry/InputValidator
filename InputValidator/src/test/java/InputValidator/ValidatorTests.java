package InputValidator;

import org.junit.Before;
import org.junit.Test;

import InputValidator.validators.IsEmptyValidator;
import InputValidator.validators.Validator;

import static junit.framework.Assert.assertEquals;

/**
 * Tests for testing the Validator object
 */
public class ValidatorTests {


    private Validator testValidator;

    @Before
    public void setUp() {
        testValidator = new IsEmptyValidator();
    }


    @Test
    public void testValidatorInputNull() {

        assertEquals(testValidator.validate(null), false);

    }

    @Test
    public void testValidatorValidInput() {
        assertEquals(testValidator.validate("Valid input"), true);
    }

    @Test
    public void testValidatorMessage() {
        assertEquals(testValidator.getValidationMessage(), "The text view is empty.");
    }

}
