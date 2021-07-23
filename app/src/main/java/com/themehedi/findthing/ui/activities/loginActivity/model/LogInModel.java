package com.themehedi.findthing.ui.activities.loginActivity.model;


import com.themehedi.findthing.extension.net.ApiService;
import com.themehedi.findthing.extension.net.NetworkCall;
import com.themehedi.findthing.extension.net.ResponseCallback;
import com.themehedi.findthing.ui.activities.loginActivity.presenter.LoginPresenterInterface;

public class LogInModel {

    public static void Login(String phone, String password, LoginPresenterInterface loginPresenterInterface) {
        ApiService apiService = new NetworkCall();
        apiService.Login(new ResponseCallback<LoginDataModel>() {
            @Override
            public void onSuccess(LoginDataModel data) {
                loginPresenterInterface.onLoginResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                loginPresenterInterface.onLoginError(errorMessage);
            }
        }, phone, password);
    }

}
