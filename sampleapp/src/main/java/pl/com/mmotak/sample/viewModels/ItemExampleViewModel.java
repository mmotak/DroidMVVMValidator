package pl.com.mmotak.sample.viewModels;

import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import pl.com.mmotak.sample.models.ItemExample;

/**
 * Created by Maciej on 2017-03-11.
 */

public class ItemExampleViewModel {

    public final ObservableField<String> message = new ObservableField<>("some message");
    public final ObservableField<String> title = new ObservableField<>("title");
    private final Intent intent;

    public ItemExampleViewModel(ItemExample itemExample) {
        message.set(itemExample.message);
        title.set(itemExample.title);
        intent = itemExample.intent;
    }

    public void onClick(View view) {
        if (intent != null) {
            view.getContext().startActivity(intent);
        }
    }
}
