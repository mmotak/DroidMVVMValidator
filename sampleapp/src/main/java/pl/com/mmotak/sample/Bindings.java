package pl.com.mmotak.sample;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.support.design.widget.TextInputEditText;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.TextView;

/**
 * Created by Maciej on 2017-03-11.
 */

public class Bindings {

    @BindingAdapter("android:text")
    public static void setIntegerText(TextView view, Integer value) {
        CharSequence old = view.getText();
        if (old != null && old.length() > 0 && value != null) {
            if (Integer.valueOf(old.toString()).intValue() != value.intValue()) {
                view.setText(String.valueOf(value));
            }
        } else  if (value != null) {
            view.setText(String.valueOf(value));
        }
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static Integer getIntegerText(TextView view) {
        CharSequence text = view.getText();
        if (text != null && text.length() > 0) {
            return Integer.valueOf(text.toString());
        }
        return null;
    }

    @BindingAdapter(value = {"app:passwordChangeVisibility"})
    public static void passwordChangeVisibility(TextInputEditText inputEditText, boolean isVisible) {
        inputEditText.setTransformationMethod(isVisible ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
        inputEditText.setSelection(inputEditText.getText().length());
    }
}
