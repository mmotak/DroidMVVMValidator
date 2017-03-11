package pl.com.mmotak.sample.viewModels;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pl.com.mmotak.sample.MainActivity;
import pl.com.mmotak.sample.R;
import pl.com.mmotak.sample.adapters.ExampleRecycleViewAdapter;
import pl.com.mmotak.sample.models.ItemExample;

/**
 * Created by Maciej on 2017-03-11.
 */

public class MainListViewModel {

    private final Context context;
    private final ExampleRecycleViewAdapter adapter = new ExampleRecycleViewAdapter(R.layout.item_example);

    public MainListViewModel(Context context) {
        this.context = context;
        adapter.setList(getList());
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    private List<ItemExample> getList() {
        List<ItemExample> list = new ArrayList<>();

        list.add(new ItemExample("Main", "Main", new Intent(context, MainActivity.class)));
        list.add(new ItemExample("x", "543543321321", null));
        list.add(new ItemExample("xz", "54354332153534 5 345", null));
        list.add(new ItemExample("xcz", "543543", null));

        return list;
    }
}
