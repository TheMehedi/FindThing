package com.themehedi.findthings.mainActivity.presenters;

import android.content.Context;

import com.themehedi.findthings.mainActivity.models.MainModel;
import com.themehedi.findthings.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthings.utils.SpinDialog;

public class MainPresenter implements MainPresenterInterface {


    Context context;
    SpinDialog spinDialog;
    private MainPresenterInterface mainPresenterInterface;

    public MainPresenter(Context context, MainPresenterInterface mainPresenterInterface) {

        this.mainPresenterInterface = mainPresenterInterface;
        this.context = context;
    }


    public void Banner() {

        spinDialog = new SpinDialog(context, false);
        spinDialog.show();

        MainModel.banner(this);
    }

    public void DealsProduct(){

        MainModel.dealsProduct(this);
    }

    @Override
    public void onBannerResponse(BannerDataModel bannerDataModel) {

        mainPresenterInterface.onBannerResponse(bannerDataModel);
    }

    @Override
    public void onBannerError(String errMessage) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        mainPresenterInterface.onBannerError(errMessage);
    }

    @Override
    public void onDealsProductResponse(DealsProductDataModel dealsProductDataModel) {

        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        mainPresenterInterface.onDealsProductResponse(dealsProductDataModel);
    }

    @Override
    public void onDealsProductError(String errMessage) {

        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        mainPresenterInterface.onDealsProductError(errMessage);
    }
}
