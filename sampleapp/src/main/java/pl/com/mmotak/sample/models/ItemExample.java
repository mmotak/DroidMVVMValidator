package pl.com.mmotak.sample.models;

import android.content.Intent;

/**
 * Created by Maciej on 2017-03-11.
 */

public class ItemExample {
    public final String message;
    public final Intent intent;
    public final String title;

    public ItemExample(String title, String message, Intent intent) {
        this.title = title;
        this.message = message;
        this.intent = intent;
    }
}
