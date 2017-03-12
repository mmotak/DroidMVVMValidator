package pl.com.mmotak.validator;

import android.databinding.Observable;
import android.databinding.ObservableBoolean;

/**
 * Created by Maciej on 2017-03-12.
 */

public class FormValidatedObservableBoolean extends ObservableBoolean {

    private final ValidatedObservableField<?>[] fields;

    public FormValidatedObservableBoolean(final ValidatedObservableField<?>... fields) {
        this.fields = fields;
        for (final ValidatedObservableField field : fields) {
            field.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable observable, int i) {
                    set(areAllFieldsValid());
                }
            });
        }
    }

    private boolean areAllFieldsValid() {
        boolean isValid = true;
        for (ValidatedObservableField field : fields) {
            isValid &= field.isValid();
            if (!isValid) {
                break;
            }
        }
        return isValid;
    }
}
