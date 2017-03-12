package pl.com.mmotak.sample.adapters;

import android.support.annotation.LayoutRes;

import pl.com.mmotak.sample.databinding.ItemExampleBinding;
import pl.com.mmotak.sample.models.ItemExample;
import pl.com.mmotak.sample.viewModels.ItemExampleViewModel;

/**
 * Created by Maciej on 2017-03-11.
 */

public class ExampleRecycleViewAdapter extends ListRecyclerViewAdapter<ItemExample, ItemExampleBinding> {

    public ExampleRecycleViewAdapter(@LayoutRes int layoutId) {
        super(layoutId);
    }

    @Override
    public void onBindViewHolder(ViewHolder<ItemExampleBinding> holder, int position) {
        holder.binding.setViewModel(new ItemExampleViewModel(get(position)));
    }

}
