package com.themehedi.findthings.mainActivity.models;

import com.themehedi.findthings.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthings.mainActivity.presenters.MainPresenterInterface;
import com.themehedi.findthings.networks.ApiService;
import com.themehedi.findthings.networks.NetworkCall;
import com.themehedi.findthings.networks.ResponseCallback;

public class MainModel {

    public static void banner(MainPresenterInterface mainPresenterInterface) {
        ApiService apiService = new NetworkCall();
        apiService.Banner(new ResponseCallback<BannerDataModel>() {
            @Override
            public void onSuccess(BannerDataModel data) {
                mainPresenterInterface.onBannerResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                mainPresenterInterface.onBannerError(errorMessage);
            }
        });
    }

    public static void dealsProduct(MainPresenterInterface mainPresenterInterface) {
        ApiService apiService = new NetworkCall();
        apiService.DealsProduct(new ResponseCallback<DealsProductDataModel>() {
            @Override
            public void onSuccess(DealsProductDataModel data) {
                mainPresenterInterface.onDealsProductResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                mainPresenterInterface.onDealsProductError(errorMessage);
            }
        });
    }
}
