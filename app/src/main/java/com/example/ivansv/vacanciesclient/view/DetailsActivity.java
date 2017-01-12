package com.example.ivansv.vacanciesclient.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivansv.vacanciesclient.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity{
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);
        picasso = Picasso.with(this);
        setValues();
    }

    private void setValues() {
        title.setText(getIntent().getStringExtra("title"));
        companyTitle.setText(getIntent().getStringExtra("company_title"));
        publishedAt.setText(getIntent().getStringExtra("published_at"));
        address.setText(getIntent().getStringExtra("address"));
        salary.setText(getIntent().getStringExtra("salary"));
        if (getIntent().getStringExtra("working_type") != null) {
            workingType.setText(getIntent().getStringExtra("working_type"));
        }
        if (getIntent().getStringExtra("schedule") != null) {
            schedule.setText(getIntent().getStringExtra("schedule"));
        }
        description.setText(Html.fromHtml(getIntent().getStringExtra("description")));
        educationExperience.setText(getIntent().getStringExtra("education_experience"));
        contactName.setText(getIntent().getStringExtra("contact_name"));
        contactUrl.setText(getIntent().getStringExtra("contact_url"));
        if (!getIntent().getStringExtra("logo_url").equals("empty")) {
            picasso.load(getIntent().getStringExtra("logo_url")).into(logo);
        }
    }
}
