package com.vivy.challenge.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DoctorRequest {

    private DoctorRequest() {
    }

    public static class ServerDoctorRequest {

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("lat")
        private double lat;

        @Expose
        @SerializedName("lng")
        private double lng;

        @Expose
        @SerializedName("lastKey")
        private String lastKey;

        @Expose
        @SerializedName("sort")
        private String sort;


        public ServerDoctorRequest(String name, double lat, double lng, String lastKey, String sort) {
            this.name = name;
            this.lat = lat;
            this.lng = lng;
            this.lastKey = lastKey;
            this.sort = sort;
        }


        public String getName() {
            return name;
        }


        public double getLat() {
            return lat;
        }


        public double getLng() {
            return lng;
        }


        public String getLastKey() {
            return lastKey;
        }


        public String getSort() {
            return sort;
        }

        public String constructParams() {
            return getName() + "&lat=" + getLat() + "&lng=" + getLng() + "&lastKey=" + getLastKey() + "&sort=" + getSort();
        }


        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            DoctorRequest.ServerDoctorRequest that = (DoctorRequest.ServerDoctorRequest) object;

            if (lastKey != null ? !lastKey.equals(that.lastKey) : that.lastKey != null)
                return false;
            return lastKey != null ? lastKey.equals(that.lastKey) : that.lastKey == null;

        }

        @Override
        public int hashCode() {
            int result = lastKey != null ? lastKey.hashCode() : 0;
            result = 31 * result + (lastKey != null ? lastKey.hashCode() : 0);
            return result;
        }

    }


}
