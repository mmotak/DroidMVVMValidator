package pl.com.mmotak.sample.activities;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Maciej on 2017-03-12.
 */

public abstract class BackActivity<DATABINDING extends ViewDataBinding, VIEWMODEL> extends AppCompatActivity {


    protected DATABINDING binding;
    protected VIEWMODEL viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayout());
        viewModel = createViewModel();
        setViewModel(binding, viewModel);

        Toolbar toolbar = getToolbar();
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    protected abstract int getLayout();

    protected abstract VIEWMODEL createViewModel();

    protected abstract void setViewModel(DATABINDING binding, VIEWMODEL viewModel);

    protected abstract  Toolbar getToolbar();
}
