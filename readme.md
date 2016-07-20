# Input Validator [In Development]

The input validator makes it easy to validate an input with a set of validators.

The Input Validator validates the content of an input when it's focus is lost. If there is an error and a user clicks on the input again the error will dissapear when the user starts typing again.


## Examples

### Input Validator

An `InputValidator` object can be created with the `ValidatorFactory` class. To create on call the `with` method and pass in any object that extends from a `TextView`.

Below is an example of a `TextInputEditText` object that is wrapped in a `TextInputLayout`.

```XML
<android.support.design.widget.TextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <android.support.design.widget.TextInputEditText
        android:id="@+id/first_name"
        android:hint="@string/hint_first_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</android.support.design.widget.TextInputLayout>
```


The `ValidatorFactory` is used to wrap the `TextInputEditText` with a `InputValidator`.

```Java
InputValidator inputValidator = ValidatorFactory.with((TextInputEditText) findViewById(R.id.first_name));
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
compile 'uk.co.jordanterry:InputValidator:0.2.1'
```

## Who to contact

* [Jordan Terry] (jterryweb@gmail.com)
