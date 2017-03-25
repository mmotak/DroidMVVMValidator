package pl.com.mmotak.validator;

import android.databinding.Observable;
import android.databinding.ObservableBoolean;

/**
 * Created by Maciej on 2017-03-12.
 */

public class FormValidatedObservableBoolean extends ObservableBoolean {

    private final ValidatedObservableField<?>[] fields;

    public FormValidatedObservableBoolean(final ValidatedObservableField<?>... fields) {
        if (fields == null) {
            this.fields = new ValidatedObservableField[]{};
        } else {
            this.fields = fields;
        }
        init();
    }

    private void init() {
        for (final ValidatedObservableField field : this.fields) {
            field.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable observable, int i) {
                    set(areAllFieldsValid());
                }
            });
        }

        set(areAllFieldsValid());
    }

    private boolean areAllFieldsValid() {
        boolean isValid = fields.length > 0;
        for (ValidatedObservableField field : fields) {
            isValid &= field.isValid();
            if (!isValid) {
                break;
            }
        }
        return isValid;
    }
}
