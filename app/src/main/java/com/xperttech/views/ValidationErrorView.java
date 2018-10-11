package com.xperttech.views;


import com.xperttech.baseclasses.BaseView;
import com.xperttech.validator.ValidationErrorModel;

/**
 * Created by
 */
public interface ValidationErrorView<T> extends BaseView<T> {
    void onValidationError(ValidationErrorModel validationErrorModel);
}
