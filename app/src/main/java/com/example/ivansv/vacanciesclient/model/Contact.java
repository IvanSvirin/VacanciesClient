package com.example.ivansv.vacanciesclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Contact implements Serializable {
    @SerializedName("skype")
    @Expose
    private String skype;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("building")
    @Expose
    private String building;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("subway")
    @Expose
    private Subway subway;
    @SerializedName("district")
    @Expose
    private District district;
    @SerializedName("coordinate")
    @Expose
    private Coordinate coordinate;

    public Contact(String skype, String email, String url, String street, String building, String name, City city, String address,
                   Subway subway, District district, Coordinate coordinate) {
        this.skype = skype;
        this.email = email;
        this.url = url;
        this.street = street;
        this.building = building;
        this.name = name;
        this.city = city;
        this.address = address;
        this.subway = subway;
        this.district = district;
        this.coordinate = coordinate;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Subway getSubway() {
        return subway;
    }

    public void setSubway(Subway subway) {
        this.subway = subway;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
