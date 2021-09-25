package com.themehedi.findthings.loginActivity.presenters;

import android.content.Context;

import com.themehedi.findthings.loginActivity.models.LogInModel;
import com.themehedi.findthings.loginActivity.models.LoginDataModel;
import com.themehedi.findthings.utils.SpinDialog;


public class LoginPresenter implements LoginPresenterInterface {

    private LoginPresenterInterface loginPresenterInterface;
    Context context;
    SpinDialog spinDialog;

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

        spinDialog = new SpinDialog(context, false);
        spinDialog.show();
        LogInModel.Login(phone, password, this);
    }

    /***********************
     *   Network Response
     * *********************/

    @Override
    public void onLoginResponse(LoginDataModel data) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        loginPresenterInterface.onLoginResponse(data);
    }

    @Override
    public void onLoginError(String errMessage) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        loginPresenterInterface.onLoginError(errMessage);
    }


}
