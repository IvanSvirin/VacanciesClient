package com.example.ivansv.vacanciesclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Company implements Serializable {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("logo")
    @Expose
    private CompanyLogo logo;
    @SerializedName("employees")
    @Expose
    private Employees employees;

    public Company(long id, String title, CompanyLogo logo, Employees employees) {
        this.id = id;
        this.title = title;
        this.logo = logo;
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CompanyLogo getLogo() {
        return logo;
    }

    public void setLogo(CompanyLogo logo) {
        this.logo = logo;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
