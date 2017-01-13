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
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        if (!getIntent().getStringExtra("published_at").equals("empty")) {
            publishedAt.setText(getIntent().getStringExtra("published_at"));
        }
        address.setText(getIntent().getStringExtra("address"));
        salary.setText(getIntent().getStringExtra("salary"));
        if (!getIntent().getStringExtra("working_type").equals("empty")) {
            workingType.setText(getIntent().getStringExtra("working_type"));
        }
        if (!getIntent().getStringExtra("schedule").equals("empty")) {
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

    @OnClick(R.id.btn_show_map)
    public void showMap() {
        if (!getIntent().getStringExtra("lat").equals("empty")) {
            String geo = getString(R.string.geo).concat(getIntent().getStringExtra("lat")).concat(getString(R.string.comma))
                    .concat(getIntent().getStringExtra("lon"))
                    .concat("?q=").concat(getIntent().getStringExtra("address"));
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geo));
            this.startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), R.string.no_data, Toast.LENGTH_SHORT).show();
        }
    }
}
