# Input Validator

The input validator makes it easy to validate an input with a set of validators.

The Input Validator validates the content of an input when it's focus is lost. If there is an error and a user clicks on the input again the error will dissapear when the user starts typing again.


## Examples

### Input Validator

Add a validator to an EditText to throw an error if the input is empty.

```Java
InputValidator.with((EditText) findViewById(R.id.first_name)).addValidator(new TextEmptyValidator());
```

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

`compile 'uk.co.jordanterry:InputValidator:0.1.1'`

## Who to contact

* [Jordan Terry] (jterryweb@gmail.com)
