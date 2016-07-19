# Input Validator [In Development]

The input validator makes it easy to validate an input with a set of validators.

The Input Validator validates the content of an input when it's focus is lost. If there is an error and a user clicks on the input again the error will dissapear when the user starts typing again.


## Examples

### Input Validator

Add a validator to an EditText to throw an error if the input is empty.

```Java
InputValidator inputValidator = ValidatorFactory.with((EditText) findViewById(R.id.first_name));
inputValidator.addValidator(new TextEmptyValidator());
```

When an InputValidator is created it will look at the parent of the input being validated. If the parent is a `TextInputLayout` it will display any error messages there, if it isn't the error message will be shown within the input.

### Validator

```Java
public class TextEmptyValidator implements Validator {

    @Override
    public boolean validate(String input) {
        return !(input == null || input.isEmpty());
    }

    @Override
    public String getValidationMessage() {
        return "The text view is empty.";
    }
    
}

```

## How to use

Add this to your gradle dependencies.

```Gradle
compile 'uk.co.jordanterry:InputValidator:0.1.1'
```

## Who to contact

* [Jordan Terry] (jterryweb@gmail.com)
