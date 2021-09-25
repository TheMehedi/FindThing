package com.themehedi.findthings.registrationActivity.presenters;

import android.content.Context;

import com.themehedi.findthings.registrationActivity.models.RegisterModel;
import com.themehedi.findthings.registrationActivity.models.RegisterDataModel;
import com.themehedi.findthings.utils.SpinDialog;


public class RegisterPresenter implements RegisterPresenterInterface {

    private RegisterPresenterInterface registerPresenterInterface;
    Context context;
    SpinDialog spinDialog;

    public RegisterPresenter(Context context, RegisterPresenterInterface registerPresenterInterface) {
        this.registerPresenterInterface = registerPresenterInterface;
        this.context = context;
    }

    public void onViewDetached() {
        registerPresenterInterface = null;
    }


    /*****************
     *   Network Call
     ******************/

    public void Register(String name, String email, String phone, String division_id, String district_id, String area_id, String password, String image) {

        spinDialog = new SpinDialog(context, false);
        spinDialog.show();
        RegisterModel.Register(name, email, phone, division_id, district_id, area_id, password, image, this);
    }

    /***********************
     *   Network Response
     * *********************/

    @Override
    public void onRegisterResponse(RegisterDataModel data) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        registerPresenterInterface.onRegisterResponse(data);
    }

    @Override
    public void onRegisterError(String errMessage) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        registerPresenterInterface.onRegisterError(errMessage);
    }


}
