package com.example.ivansv.vacanciesclient.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ivansv.vacanciesclient.R;
import com.example.ivansv.vacanciesclient.model.ApiResponse;
import com.example.ivansv.vacanciesclient.model.Vacancy;
import com.example.ivansv.vacanciesclient.rest.ResponseService;
import com.example.ivansv.vacanciesclient.rest.ServiceFactory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Vacancy> vacancies;
    @BindView(R.id.rv_vacancies)
    RecyclerView rvVacancies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        getVacanciesList();
    }

    public void getVacanciesList() {
        ResponseService responseService = ServiceFactory.createRetrofitService(ResponseService.class);
        responseService.getResponse().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                vacancies = response.body().getVacancies();
                rvVacancies.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rvVacancies.setAdapter(new VacanciesAdapter(MainActivity.this, vacancies));
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
            }
        });
    }
}
