package com.themehedi.findthings.findPeopleActivity.presenters;

import android.content.Context;

import com.themehedi.findthings.datamodels.AreaDataModel;
import com.themehedi.findthings.datamodels.DistrictDataModel;
import com.themehedi.findthings.datamodels.DivisionDataModel;
import com.themehedi.findthings.findPeopleActivity.models.FindPeopleModel;
import com.themehedi.findthings.mainActivity.models.MainModel;
import com.themehedi.findthings.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthings.utils.SpinDialog;

public class FindPresenter implements FindPresenterInterface {


    Context context;
    SpinDialog spinDialog;
    private FindPresenterInterface findPresenterInterface;

    public FindPresenter(Context context, FindPresenterInterface findPresenterInterface) {

        this.findPresenterInterface = findPresenterInterface;
        this.context = context;
    }


    public void Division() {

        spinDialog = new SpinDialog(context, false);
        spinDialog.show();

        FindPeopleModel.division(this);
    }


    public void District() {

        spinDialog = new SpinDialog(context, false);
        spinDialog.show();

        FindPeopleModel.district(this);
    }


    public void Area() {

        spinDialog = new SpinDialog(context, false);
        spinDialog.show();

        FindPeopleModel.area(this);
    }

    @Override
    public void onDivisionResponse(DivisionDataModel divisionDataModel) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        findPresenterInterface.onDivisionResponse(divisionDataModel);
    }

    @Override
    public void onDivisionError(String errMessage) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        findPresenterInterface.onDivisionError(errMessage);
    }

    @Override
    public void onDistrictResponse(DistrictDataModel districtDataModel) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        findPresenterInterface.onDistrictResponse(districtDataModel);
    }

    @Override
    public void onDistrictError(String errMessage) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        findPresenterInterface.onDistrictError(errMessage);
    }

    @Override
    public void onAreaResponse(AreaDataModel areaDataModel) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        findPresenterInterface.onAreaResponse(areaDataModel);
    }

    @Override
    public void onAreaError(String errMessage) {
        if (spinDialog != null) {
            spinDialog.dismiss();
        }
        findPresenterInterface.onAreaError(errMessage);

    }

}
