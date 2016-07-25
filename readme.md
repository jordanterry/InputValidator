# Input Validator

Input validation and error displaying for any Android view that extends from a TextView. This library is born from frustration towards complex if statements and a desire to make form validation much, much easier.

What does the library do? 

* Wrap around any `View` extending from `TextView`
* Allow multiple `Validator` objects to be attached.
* When the `View` loses focus the input will be validated against the `Validator`s
* Display an error message if the input isn't successfully validated
	* If the input is wrapped in a `TextInputLayout` it will be used to display the message
	* If the input is not wrapped in a `TextInputLayout` the error will be shown in the inpput
	* The above can be overriden using an `OnValidationErrorListener` which allows you to do whatever you want with the error received 


```Java
InputValidator inputValidator = ValidateInputs.validate((TextInputEditText) findViewById(R.id.first_name));
inputValidator.addValidator(new TextEmptyValidator());
```

By implementing the `Validator` object you can create your own validation methods.

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
compile 'uk.co.jordanterry:InputValidator:0.3.0'
```

## Want to contribute? 

Great! If you notice anything that I could be doing better please create an issue and let me know. 

I would also LOVE to know if anyone has any `Validator` ideas, the more the merrier.

## Who to contact

* [Jordan Terry] (jterryweb@gmail.com)
