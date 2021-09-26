package com.themehedi.findthings.utils;

import com.themehedi.findthings.datamodels.AreaDataModel;
import com.themehedi.findthings.datamodels.DistrictDataModel;
import com.themehedi.findthings.datamodels.DivisionDataModel;

import java.util.ArrayList;
import java.util.List;

public class StaticMethod {

    public static final String USER_ID = "id";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String IMAGE = "image";
    public static final String DIVISION_NAME = "division_name";
    public static final String DIVISION_ID = "division_id";
    public static final String DISTRICT_NAME = "district_name";
    public static final String DISTRICT_ID = "district_id";
    public static final String AREA_NAME = "area_name";
    public static final String AREA_ID = "area_id";
    public static final String IS_LOGIN = "is_login";


    public static List<DivisionDataModel.Datum> divisionDataList = new ArrayList<>();
    public static List<DistrictDataModel.Datum> districtDataList = new ArrayList<>();
    public static List<AreaDataModel.Datum> areaDataList = new ArrayList<>();
}
