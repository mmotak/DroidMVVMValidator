package pl.com.mmotak.sample.activities;

import android.support.v7.widget.Toolbar;

import pl.com.mmotak.sample.R;
import pl.com.mmotak.sample.databinding.ActivityLoginExampleBinding;
import pl.com.mmotak.sample.viewModels.LoginExampleViewModel;

/**
 * Created by Maciej on 2017-03-13.
 */

public class LoginExampleActivity extends BackActivity<ActivityLoginExampleBinding, LoginExampleViewModel> {
    @Override
    protected int getLayout() {
        return R.layout.activity_login_example;
    }

    @Override
    protected LoginExampleViewModel createViewModel() {
        return new LoginExampleViewModel();
    }

    @Override
    protected void setViewModel(ActivityLoginExampleBinding binding, LoginExampleViewModel viewModel) {
        binding.setViewModel(viewModel);
    }

    @Override
    protected Toolbar getToolbar() {
        return binding.toolbar;
    }
}
