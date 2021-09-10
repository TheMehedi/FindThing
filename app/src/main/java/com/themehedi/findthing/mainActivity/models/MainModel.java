package com.themehedi.findthing.mainActivity.models;

import com.themehedi.findthing.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthing.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthing.mainActivity.presenters.MainPresenterInterface;
import com.themehedi.findthing.networks.ApiService;
import com.themehedi.findthing.networks.NetworkCall;
import com.themehedi.findthing.networks.ResponseCallback;

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
