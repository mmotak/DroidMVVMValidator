package pl.com.mmotak.sample.viewModels;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pl.com.mmotak.sample.R;
import pl.com.mmotak.sample.activities.ChangePasswordExampleActivity;
import pl.com.mmotak.sample.activities.LambdaRulesExampleActivity;
import pl.com.mmotak.sample.activities.LoginExampleActivity;
import pl.com.mmotak.sample.activities.MultiRulesExampleActivity;
import pl.com.mmotak.sample.activities.SingleRuleExampleActivity;
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

        list.add(new ItemExample("Multi Rules",
                "[MultiRulesExampleActivity] Show multi rules example",
                new Intent(context, MultiRulesExampleActivity.class)));

        list.add(new ItemExample("Single Rules",
                "[SingleRuleExampleActivity] Show single rules example",
                new Intent(context, SingleRuleExampleActivity.class)));

        list.add(new ItemExample("Other fields validate",
                "[ChangePasswordExampleActivity] Show example to validate other fields",
                new Intent(context, ChangePasswordExampleActivity.class)));

        list.add(new ItemExample("OR rules validate",
                "[LoginExampleActivity] Show example with OR rules",
                new Intent(context, LoginExampleActivity.class)));

        list.add(new ItemExample("Show how use lambda",
                "[LambdaRulesExampleActivity] Show creating rules with lambda",
                new Intent(context, LambdaRulesExampleActivity.class)));

        return list;
    }
}
