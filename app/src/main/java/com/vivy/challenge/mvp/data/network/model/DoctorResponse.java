package com.vivy.challenge.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DoctorResponse {

    @SerializedName("doctors")
    @Expose
    private List<Doctor> doctors = null;
    @SerializedName("lastKey")
    @Expose
    private String lastKey;

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public String getLastKey() {
        return lastKey;
    }

    public void setLastKey(String lastKey) {
        this.lastKey = lastKey;
    }


    public class Doctor {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("photoId")
        @Expose
        private String photoId;
        @SerializedName("rating")
        @Expose
        private Double rating;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("lat")
        @Expose
        private Double lat;
        @SerializedName("lng")
        @Expose
        private Double lng;
        @SerializedName("highlighted")
        @Expose
        private Boolean highlighted;
        @SerializedName("reviewCount")
        @Expose
        private Integer reviewCount;
        @SerializedName("specialityIds")
        @Expose
        private List<Integer> specialityIds = null;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("phoneNumber")
        @Expose
        private String phoneNumber;
        @SerializedName("email")
        @Expose
        private Object email;
        @SerializedName("website")
        @Expose
        private String website;
        @SerializedName("openingHours")
        @Expose
        private List<String> openingHours = null;
        @SerializedName("integration")
        @Expose
        private Object integration;
        @SerializedName("translation")
        @Expose
        private Object translation;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhotoId() {
            return photoId;
        }

        public void setPhotoId(String photoId) {
            this.photoId = photoId;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }

        public Boolean getHighlighted() {
            return highlighted;
        }

        public void setHighlighted(Boolean highlighted) {
            this.highlighted = highlighted;
        }

        public Integer getReviewCount() {
            return reviewCount;
        }

        public void setReviewCount(Integer reviewCount) {
            this.reviewCount = reviewCount;
        }

        public List<Integer> getSpecialityIds() {
            return specialityIds;
        }

        public void setSpecialityIds(List<Integer> specialityIds) {
            this.specialityIds = specialityIds;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public List<String> getOpeningHours() {
            return openingHours;
        }

        public void setOpeningHours(List<String> openingHours) {
            this.openingHours = openingHours;
        }

        public Object getIntegration() {
            return integration;
        }

        public void setIntegration(Object integration) {
            this.integration = integration;
        }

        public Object getTranslation() {
            return translation;
        }

        public void setTranslation(Object translation) {
            this.translation = translation;
        }

    }

}
