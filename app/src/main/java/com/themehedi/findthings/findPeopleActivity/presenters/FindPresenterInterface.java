package com.themehedi.findthings.findPeopleActivity.presenters;

import com.themehedi.findthings.datamodels.AreaDataModel;
import com.themehedi.findthings.datamodels.DistrictDataModel;
import com.themehedi.findthings.datamodels.DivisionDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.DealsProductDataModel;

public interface FindPresenterInterface {

    void onDivisionResponse(DivisionDataModel divisionDataModel);
    void onDivisionError(String errMessage);

    void onDistrictResponse(DistrictDataModel districtDataModel);
    void onDistrictError(String errMessage);

    void onAreaResponse(AreaDataModel areaDataModel);
    void onAreaError(String errMessage);

}
