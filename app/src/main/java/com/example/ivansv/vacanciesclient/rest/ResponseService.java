package com.example.ivansv.vacanciesclient.rest;

import com.example.ivansv.vacanciesclient.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResponseService {
    @GET("vacancies")
    Call<ApiResponse> getResponse();
}
