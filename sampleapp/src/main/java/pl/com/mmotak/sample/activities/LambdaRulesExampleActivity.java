package pl.com.mmotak.sample.activities;


import androidx.appcompat.widget.Toolbar;

import pl.com.mmotak.sample.R;
import pl.com.mmotak.sample.databinding.ActivityLambdaExampleBinding;
import pl.com.mmotak.sample.viewModels.LambdaRulesExampleViewModel;

/**
 * Created by Maciej on 2017-03-13.
 */

public class LambdaRulesExampleActivity extends BackActivity<ActivityLambdaExampleBinding, LambdaRulesExampleViewModel> {
    @Override
    protected int getLayout() {
        return R.layout.activity_lambda_example;
    }

    @Override
    protected LambdaRulesExampleViewModel createViewModel() {
        return new LambdaRulesExampleViewModel();
    }

    @Override
    protected void setViewModel(ActivityLambdaExampleBinding binding, LambdaRulesExampleViewModel viewModel) {
        binding.setViewModel(viewModel);
    }

    @Override
    protected Toolbar getToolbar() {
        return binding.toolbar;
    }
}
