package com.example.ivansv.vacanciesclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vacancy {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("salary_min")
    @Expose
    private int salaryMin;
    @SerializedName("salary_max")
    @Expose
    private int salaryMax;
    @SerializedName("currency")
    @Expose
    private SalaryCurrency currency;
    @SerializedName("education")
    @Expose
    private Education education;
    @SerializedName("experience_length")
    @Expose
    private Experience experience;
    @SerializedName("working_type")
    @Expose
    private WorkingType workingType;
    @SerializedName("schedule")
    @Expose
    private WorkSchedule schedule;
    @SerializedName("publication")
    @Expose
    private Publication publication;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("company")
    @Expose
    private Company company;
    @SerializedName("owner")
    @Expose
    private CompanyOwner owner;

    public Vacancy(long id, String header, int salaryMin, int salaryMax, SalaryCurrency currency, Education education,
                   Experience experience, WorkingType workingType, WorkSchedule schedule, Publication publication,
                   String userType, String description, Contact contact, Company company, CompanyOwner owner) {
        this.id = id;
        this.header = header;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.currency = currency;
        this.education = education;
        this.experience = experience;
        this.workingType = workingType;
        this.schedule = schedule;
        this.publication = publication;
        this.userType = userType;
        this.description = description;
        this.contact = contact;
        this.company = company;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(int salaryMin) {
        this.salaryMin = salaryMin;
    }

    public int getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(int salaryMax) {
        this.salaryMax = salaryMax;
    }

    public SalaryCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(SalaryCurrency currency) {
        this.currency = currency;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public void setWorkingType(WorkingType workingType) {
        this.workingType = workingType;
    }

    public WorkSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(WorkSchedule schedule) {
        this.schedule = schedule;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyOwner getOwner() {
        return owner;
    }

    public void setOwner(CompanyOwner owner) {
        this.owner = owner;
    }
}
