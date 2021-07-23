package com.themehedi.findthing.ui.activities.loginActivity.presenter;

import android.content.Context;

import com.themehedi.findthing.ui.activities.loginActivity.model.LogInModel;
import com.themehedi.findthing.ui.activities.loginActivity.model.LoginDataModel;


public class LoginPresenter implements LoginPresenterInterface {

    private LoginPresenterInterface loginPresenterInterface;
    Context context;

    public LoginPresenter(Context context, LoginPresenterInterface loginPresenterInterface) {
        this.loginPresenterInterface = loginPresenterInterface;
        this.context = context;
    }

    public void onViewDetached() {
        loginPresenterInterface = null;
    }


    /*****************
     *   Network Call
     ******************/

    public void Login(String phone, String password) {

        LogInModel.Login(phone, password, this);
    }

    /***********************
     *   Network Response
     * *********************/

    @Override
    public void onLoginResponse(LoginDataModel data) {

        loginPresenterInterface.onLoginResponse(data);
    }

    @Override
    public void onLoginError(String errMessage) {

        loginPresenterInterface.onLoginError(errMessage);
    }


}
