package com.themehedi.findthings.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DistrictDataModel {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("division_id")
        @Expose
        private String divisionId;
        @SerializedName("district_title")
        @Expose
        private String districtTitle;
        @SerializedName("district_status")
        @Expose
        private String districtStatus;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDivisionId() {
            return divisionId;
        }

        public void setDivisionId(String divisionId) {
            this.divisionId = divisionId;
        }

        public String getDistrictTitle() {
            return districtTitle;
        }

        public void setDistrictTitle(String districtTitle) {
            this.districtTitle = districtTitle;
        }

        public String getDistrictStatus() {
            return districtStatus;
        }

        public void setDistrictStatus(String districtStatus) {
            this.districtStatus = districtStatus;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }
    
}
