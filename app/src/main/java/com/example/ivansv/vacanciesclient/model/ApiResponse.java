package com.example.ivansv.vacanciesclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiResponse {
    @SerializedName("vacancies")
    @Expose
    private ArrayList<Vacancy> vacancies;

    public ApiResponse(ArrayList<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public ArrayList<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(ArrayList<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
