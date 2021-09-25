package com.themehedi.findthings.mainActivity.presenters;

import com.themehedi.findthings.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.DealsProductDataModel;

public interface MainPresenterInterface {

    void onBannerResponse(BannerDataModel bannerDataModel);
    void onBannerError(String errMessage);

    void onDealsProductResponse(DealsProductDataModel dealsProductDataModel);
    void onDealsProductError(String errMessage);
}
