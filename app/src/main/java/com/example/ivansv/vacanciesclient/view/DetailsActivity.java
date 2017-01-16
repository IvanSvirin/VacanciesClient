package com.example.ivansv.vacanciesclient.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ivansv.vacanciesclient.R;
import com.example.ivansv.vacanciesclient.model.Vacancy;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.tv_title)
    public TextView title;
    @BindView(R.id.tv_company_title)
    public TextView companyTitle;
    @BindView(R.id.tv_published_at)
    public TextView publishedAt;
    @BindView(R.id.tv_address)
    public TextView address;
    @BindView(R.id.tv_salary)
    public TextView salary;
    @BindView(R.id.tv_working_type)
    public TextView workingType;
    @BindView(R.id.tv_schedule)
    public TextView schedule;
    @BindView(R.id.tv_description)
    public TextView description;
    @BindView(R.id.tv_education_experience)
    public TextView educationExperience;
    @BindView(R.id.tv_contactName)
    public TextView contactName;
    @BindView(R.id.tv_contactUrl)
    public TextView contactUrl;
    @BindView(R.id.iv_logo)
    public ImageView logo;
    private Picasso picasso;
    private Vacancy vacancy;
    private String date;
    private String salaryValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);
        picasso = Picasso.with(this);
        vacancy = (Vacancy) getIntent().getSerializableExtra("vacancy");
        date = getIntent().getStringExtra("showed_date");
        salaryValue = getIntent().getStringExtra("showed_salary");
        setValues();
    }

    private void setValues() {
        title.setText(vacancy.getHeader());
        companyTitle.setText(vacancy.getCompany().getTitle());
        publishedAt.setText(date);
        address.setText(vacancy.getContact().getAddress());
        salary.setText(salaryValue);
        if (vacancy.getWorkingType() != null) {
            workingType.setText(vacancy.getWorkingType().getTitle());
        }
        if (vacancy.getSchedule() != null) {
            schedule.setText(vacancy.getSchedule().getTitle());
        }
        description.setText(Html.fromHtml(vacancy.getDescription()));
        if (vacancy.getEducation() == null && vacancy.getExperience() == null) {
            educationExperience.setText(getString(R.string.education)
                    .concat(getString(R.string.no_important)).concat(getString(R.string.experience)).concat(getString(R.string.no_value)));
        } else if (vacancy.getEducation() == null) {
            educationExperience.setText(getString(R.string.education)
                    .concat(getString(R.string.no_important)).concat(getString(R.string.experience))
                    .concat(vacancy.getExperience().getTitle()));
        } else if (vacancy.getExperience() == null) {
            educationExperience.setText(getString(R.string.education).concat(vacancy.getEducation().getTitle())
                    .concat(getString(R.string.experience)).concat(getString(R.string.no_value)));
        } else {
            educationExperience.setText(getString(R.string.education).concat(vacancy.getEducation().getTitle())
                    .concat(getString(R.string.experience)).concat(vacancy.getExperience().getTitle()));
        }
        contactName.setText(vacancy.getContact().getName());
        contactUrl.setText(vacancy.getContact().getUrl());
        if (vacancy.getCompany().getLogo() != null) {
            picasso.load(getIntent().getStringExtra("logo_url")).into(logo);
        }
    }

    @OnClick(R.id.btn_show_map)
    public void showMap() {
        if (vacancy.getContact().getCoordinate() != null) {
            String geo = getString(R.string.geo).concat(String.valueOf(vacancy.getContact().getCoordinate().getLat())).concat(getString(R.string.comma))
                    .concat(String.valueOf(vacancy.getContact().getCoordinate().getLon()))
                    .concat("?q=").concat(vacancy.getContact().getAddress());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geo));
            this.startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), R.string.no_data, Toast.LENGTH_SHORT).show();
        }
    }
}
