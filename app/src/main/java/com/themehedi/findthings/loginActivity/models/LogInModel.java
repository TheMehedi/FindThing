package com.themehedi.findthings.loginActivity.models;


import com.themehedi.findthings.networks.ApiService;
import com.themehedi.findthings.networks.NetworkCall;
import com.themehedi.findthings.networks.ResponseCallback;
import com.themehedi.findthings.loginActivity.presenters.LoginPresenterInterface;

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
