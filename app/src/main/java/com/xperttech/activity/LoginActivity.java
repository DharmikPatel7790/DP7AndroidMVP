package com.xperttech.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import com.xperttech.R;
import com.xperttech.baseclasses.MVPActivity;
import com.xperttech.constants.ApiParamEnum;
import com.xperttech.constants.AppConstants;
import com.xperttech.models.LoginResponse;
import com.xperttech.presenters.LoginPresenter;
import com.xperttech.utils.AppUtils;
import com.xperttech.utils.MyPrefs;
import com.xperttech.validator.ValidationErrorModel;
import com.xperttech.views.ValidationErrorView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by
 */
public class LoginActivity extends MVPActivity<LoginPresenter, ValidationErrorView<LoginResponse>> implements ValidationErrorView<LoginResponse> {

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        init();
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @NonNull
    @Override
    public ValidationErrorView<LoginResponse> attachView() {
        return this;
    }

    private void init() {
        initToolbar();
    }

    private void initToolbar() {
        ivToolbarLeft.setVisibility(View.VISIBLE);
        setToolbarTitle(R.string.action_login);
    }

    @OnClick({R.id.tvLogin, R.id.ivToolbarLeft})
    public void onClick(View view) {
        AppUtils.hideKeyboard(this);
        switch (view.getId()) {
            case R.id.tvLogin:
                callLoginApi();
                break;
            case R.id.ivToolbarLeft:
                finish();
                break;
        }
    }

    private void callLoginApi() {
        HashMap<String, String> params = new HashMap<>();
        params.put(ApiParamEnum.EMAIL.getValue(), AppUtils.getText(etEmail));
        params.put(ApiParamEnum.PASSWORD.getValue(), AppUtils.getText(etPassword));
        params.put(ApiParamEnum.DEVICE_TYPE.getValue(), String.valueOf(AppConstants.DEVICE_TYPE));
        getPresenter().isValidData(params);
    }

    @Override
    public void onValidationError(ValidationErrorModel validationErrorModel) {
        AppUtils.showToast(getActivity(), validationErrorModel.getMsg());
        switch (validationErrorModel.getError()) {
            case EMAIL:
                AppUtils.requestEdittextFocus(LoginActivity.this, etEmail);
                break;
            case PASSWORD:
                AppUtils.requestEdittextFocus(LoginActivity.this, etPassword);
                break;
        }
    }

    @Override
    public void onFailure(String message) {
        AppUtils.showToast(getActivity(), message);
    }

    @Override
    public void onAuthenticationFailure(String message) {

    }

    @Override
    public void onSuccess(LoginResponse response) {
        AppUtils.showToast(getActivity(), response.getMessage());
        setDataInPrefs(response);
    }

    private void setDataInPrefs(LoginResponse response) {
        MyPrefs.getInstance(this).setUserDataModel(response.getUserDataModel());
        MyPrefs.getInstance(this).setAccessToken(response.getAccess_token());
        MyPrefs.getInstance(this).setUserLogin(true);
    }
}
