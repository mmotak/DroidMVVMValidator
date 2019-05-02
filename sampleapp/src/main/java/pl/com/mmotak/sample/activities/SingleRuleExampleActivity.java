package pl.com.mmotak.sample.activities;


import androidx.appcompat.widget.Toolbar;

import pl.com.mmotak.sample.R;
import pl.com.mmotak.sample.databinding.ActivitySingleRuleExampleBinding;
import pl.com.mmotak.sample.viewModels.SingleRuleExampleViewModel;

/**
 * Created by Maciej on 2017-03-11.
 */

public class SingleRuleExampleActivity extends BackActivity<ActivitySingleRuleExampleBinding, SingleRuleExampleViewModel> {

    @Override
    protected int getLayout() {
        return R.layout.activity_single_rule_example;
    }

    @Override
    protected SingleRuleExampleViewModel createViewModel() {
        return new SingleRuleExampleViewModel();
    }

    @Override
    protected void setViewModel(ActivitySingleRuleExampleBinding binding, SingleRuleExampleViewModel viewModel) {
        binding.setViewModel(viewModel);
    }

    @Override
    protected Toolbar getToolbar() {
        return binding.toolbar;
    }
}