package com.themehedi.findthing.loginActivity.presenters;


import com.themehedi.findthing.loginActivity.models.LoginDataModel;

public interface LoginPresenterInterface {
    void onLoginResponse(LoginDataModel data);
    void onLoginError(String errMessage);
}
