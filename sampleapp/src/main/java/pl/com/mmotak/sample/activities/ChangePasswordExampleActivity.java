package pl.com.mmotak.sample.activities;

import androidx.appcompat.widget.Toolbar;

import pl.com.mmotak.sample.R;
import pl.com.mmotak.sample.databinding.ActivityChangePasswordBinding;
import pl.com.mmotak.sample.viewModels.ChangePasswordViewModel;

/**
 * Created by Maciej on 2017-03-12.
 */

public class ChangePasswordExampleActivity extends BackActivity<ActivityChangePasswordBinding, ChangePasswordViewModel> {
    @Override
    protected int getLayout() {
        return R.layout.activity_change_password;
    }

    @Override
    protected ChangePasswordViewModel createViewModel() {
        return new ChangePasswordViewModel();
    }

    @Override
    protected void setViewModel(ActivityChangePasswordBinding binding, ChangePasswordViewModel viewModel) {
        binding.setViewModel(viewModel);
    }

    @Override
    protected Toolbar getToolbar() {
        return binding.toolbar;
    }
}
