package com.themehedi.findthings.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DivisionDataModel {

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
        @SerializedName("division_title")
        @Expose
        private String divisionTitle;
        @SerializedName("division_status")
        @Expose
        private String divisionStatus;
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

        public String getDivisionTitle() {
            return divisionTitle;
        }

        public void setDivisionTitle(String divisionTitle) {
            this.divisionTitle = divisionTitle;
        }

        public String getDivisionStatus() {
            return divisionStatus;
        }

        public void setDivisionStatus(String divisionStatus) {
            this.divisionStatus = divisionStatus;
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