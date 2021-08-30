package com.themehedi.findthing.loginActivity.models;


import com.themehedi.findthing.networks.ApiService;
import com.themehedi.findthing.networks.NetworkCall;
import com.themehedi.findthing.networks.ResponseCallback;
import com.themehedi.findthing.loginActivity.presenters.LoginPresenterInterface;

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
