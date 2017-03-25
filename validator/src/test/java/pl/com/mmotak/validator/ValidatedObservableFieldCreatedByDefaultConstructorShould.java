package pl.com.mmotak.validator;

import android.databinding.Observable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maciej on 2017-03-12.
 */

public class ValidatedObservableFieldCreatedByDefaultConstructorShould {

    private ValidatedObservableField<Object> field;

    @Before
    public void setUp() {
        field = new ValidatedObservableField<>();
    }

    @Test
    public void returnNullValue() {
        assertEquals(null, field.getValue());
    }

    @Test
    public void notBeValid() {
        assertFalse(field.isValid());
    }

    @Test
    public void returnNullForErrorMessage() {
        assertNull(field.getErrorMessage());
    }

    @Test
    public void notBeValidAfterSetNewValue() {
        field.setValue(new Object());

        assertFalse(field.isValid());
    }

    @Test
    public void returnNullForErrorMessageAfterSetNewValue() {
        field.setValue(new Object());

        assertNull(field.getErrorMessage());
    }

    @Test
    public void returnNewErrorMessageAfterSetNewErrorMessage() {
        String newErrorMessage = "newErrorMessage";

        field.setErrorMessage(newErrorMessage);
        assertEquals(newErrorMessage, field.getErrorMessage());
    }

    @Test
    public void notCallNotifyChangeForSetErrorMessageWithNullValue() {
        field.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                fail("Should not get here");
            }
        });

        field.setErrorMessage(null);
    }

    @Test
    public void callNotifyChangeForSetErrorMessageWithNullValueIfPreviousErrorMessageWasNotNull() {
        final String newErrorMessage = "newErrorMessage";
        field.setErrorMessage(newErrorMessage);

        field.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                assertNull(field.getErrorMessage());
            }
        });

        field.setErrorMessage(null);
        assertNull(field.getErrorMessage());
    }

    @Test
    public void notCallNotifyChangeForSetErrorMessageWithTheSameAsCurrentOne() {
        final String newErrorMessage = "newErrorMessage";
        field.setErrorMessage(newErrorMessage);

        field.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                fail("Should not get here");
            }
        });

        field.setErrorMessage(newErrorMessage);
    }
}
