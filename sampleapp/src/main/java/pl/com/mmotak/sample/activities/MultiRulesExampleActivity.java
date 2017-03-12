package pl.com.mmotak.sample.activities;

import android.support.v7.widget.Toolbar;

import pl.com.mmotak.sample.R;
import pl.com.mmotak.sample.databinding.ActivityMultiRulesExampleBinding;
import pl.com.mmotak.sample.viewModels.MultiRulesExampleViewModel;

public class MultiRulesExampleActivity extends BackActivity<ActivityMultiRulesExampleBinding, MultiRulesExampleViewModel> {

    @Override
    protected int getLayout() {
        return R.layout.activity_multi_rules_example;
    }

    @Override
    protected MultiRulesExampleViewModel createViewModel() {
        return new MultiRulesExampleViewModel();
    }

    @Override
    protected void setViewModel(ActivityMultiRulesExampleBinding binding, MultiRulesExampleViewModel viewModel) {
        binding.setViewModel(viewModel);
    }

    @Override
    protected Toolbar getToolbar() {
        return binding.toolbar;
    }
}