package com.themehedi.findthings.loginActivity.presenters;


import com.themehedi.findthings.loginActivity.models.LoginDataModel;

public interface LoginPresenterInterface {
    void onLoginResponse(LoginDataModel data);
    void onLoginError(String errMessage);
}
