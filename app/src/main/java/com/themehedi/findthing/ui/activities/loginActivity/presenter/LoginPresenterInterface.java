package com.themehedi.findthing.ui.activities.loginActivity.presenter;


import com.themehedi.findthing.ui.activities.loginActivity.model.LoginDataModel;

public interface LoginPresenterInterface {
    void onLoginResponse(LoginDataModel data);
    void onLoginError(String errMessage);
}
