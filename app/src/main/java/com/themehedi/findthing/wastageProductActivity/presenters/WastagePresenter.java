package com.themehedi.findthing.wastageProductActivity.presenters;

import android.content.Context;

import com.themehedi.findthing.utils.SpinDialog;
import com.themehedi.findthing.wastageProductActivity.models.WastageProductModel;
import com.themehedi.findthing.wastageProductActivity.models.datamodels.WastageProductDataModel;

public class WastagePresenter implements WastagePresenterInterface{

    Context context;
    SpinDialog spinDialog;
    WastagePresenterInterface wastagePresenterInterface;


    public WastagePresenter(Context context, WastagePresenterInterface wastagePresenterInterface){

        this.context = context;
        this.wastagePresenterInterface = wastagePresenterInterface;
    }


    public void wastage(){

        spinDialog = new SpinDialog(context, false);
        spinDialog.show();

        WastageProductModel.wastage(this);
    }

    @Override
    public void onWastageResponse(WastageProductDataModel wastageProductDataModel) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }

        wastagePresenterInterface.onWastageResponse(wastageProductDataModel);
    }

    @Override
    public void onWastageError(String errMessage) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        wastagePresenterInterface.onWastageError(errMessage);
    }
}
