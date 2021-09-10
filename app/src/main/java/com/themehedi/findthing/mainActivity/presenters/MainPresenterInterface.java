package com.themehedi.findthing.mainActivity.presenters;

import com.themehedi.findthing.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthing.mainActivity.models.datamodels.DealsProductDataModel;

public interface MainPresenterInterface {

    void onBannerResponse(BannerDataModel bannerDataModel);
    void onBannerError(String errMessage);

    void onDealsProductResponse(DealsProductDataModel dealsProductDataModel);
    void onDealsProductError(String errMessage);
}
