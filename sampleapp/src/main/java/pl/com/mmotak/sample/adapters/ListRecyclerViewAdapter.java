package pl.com.mmotak.sample.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmotak on 03.01.2017.
 */

public abstract class ListRecyclerViewAdapter<ITEM,BINDING extends ViewDataBinding>
        extends RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder<BINDING>>{

    private List<ITEM> list = new ArrayList<ITEM>();
    private int layoutId;

    public ListRecyclerViewAdapter(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public ListRecyclerViewAdapter.ViewHolder<BINDING> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListRecyclerViewAdapter.ViewHolder<BINDING>(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<ITEM> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(ITEM item) {
        if (item != null) {
            list.add(item);
            notifyDataSetChanged();
        }
    }

    protected ITEM get(int position) {
        return list.get(position);
    }

    static class ViewHolder<BINDING extends ViewDataBinding> extends RecyclerView.ViewHolder {
        final BINDING binding;

        ViewHolder(BINDING binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

