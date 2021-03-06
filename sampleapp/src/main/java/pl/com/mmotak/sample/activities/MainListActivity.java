package pl.com.mmotak.sample.activities;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import pl.com.mmotak.sample.R;
import pl.com.mmotak.sample.databinding.ActivityMainListBinding;
import pl.com.mmotak.sample.viewModels.MainListViewModel;

public class MainListActivity extends AppCompatActivity {

    private ActivityMainListBinding binding;
    private MainListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_list);
        viewModel = new MainListViewModel(this);
        binding.setViewModel(viewModel);

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
    }
}
