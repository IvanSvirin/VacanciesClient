package com.example.ivansv.vacanciesclient.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivansv.vacanciesclient.R;
import com.example.ivansv.vacanciesclient.model.Vacancy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VacanciesAdapter extends RecyclerView.Adapter<VacanciesAdapter.VacanciesViewHolder> {
    private Context context;
    private ArrayList<Vacancy> vacancies;
    private Picasso picasso;
    private String showedSalary;
    private String showedDate;

    public VacanciesAdapter(Context context, ArrayList<Vacancy> vacancies) {
        this.context = context;
        this.vacancies = vacancies;
        picasso = Picasso.with(context);
    }

    @Override
    public VacanciesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vacancy, parent, false);
        return new VacanciesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VacanciesViewHolder holder, int position) {
        holder.title.setText(vacancies.get(position).getHeader());
        holder.companyTitle.setText(vacancies.get(position).getCompany().getTitle());
        if (vacancies.get(position).getPublication() != null) {
            String date = vacancies.get(position).getPublication().getPublishedAt();
            showedDate = date.substring(8, 10)
                    .concat(context.getResources().getStringArray(R.array.months)[Integer.parseInt(date.substring(5, 7)) - 1])
                    .concat(context.getString(R.string.in)).concat(date.substring(11, 16));
            holder.publishedAt.setText(showedDate);
        } else {
            showedDate = "empty";
        }
        holder.address.setText(vacancies.get(position).getContact().getAddress());
        if (vacancies.get(position).getSalaryMin() == 0 && vacancies.get(position).getSalaryMax() == 0) {
            showedSalary = context.getString(R.string.no_salary);
        } else if (vacancies.get(position).getSalaryMax() == 0) {
            showedSalary = (context.getString(R.string.from).concat(String.valueOf(vacancies.get(position).getSalaryMin()))
                    .concat(" ").concat(vacancies.get(position).getCurrency().getTitle()));
        } else {
            showedSalary = (String.valueOf(vacancies.get(position).getSalaryMin()).concat(" - ")
                    .concat(String.valueOf(vacancies.get(position).getSalaryMax())).concat(" ")
                    .concat(vacancies.get(position).getCurrency().getTitle()));
        }
        holder.salary.setText(showedSalary);
        if (vacancies.get(position).getWorkingType() != null) {
            holder.workingType.setText(vacancies.get(position).getWorkingType().getTitle());
        }
        if (vacancies.get(position).getSchedule() != null) {
            holder.schedule.setText(vacancies.get(position).getSchedule().getTitle());
        }
        if (vacancies.get(position).getCompany().getLogo() != null) {
            picasso.load(vacancies.get(position).getCompany().getLogo().getUrl()).into(holder.logo);
        }
    }

    @Override
    public int getItemCount() {
        return vacancies.size();
    }

    public class VacanciesViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.iv_logo)
        public ImageView logo;

        @OnClick(R.id.btn_details)
        public void details() {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("title", vacancies.get(getAdapterPosition()).getHeader());
            intent.putExtra("company_title", vacancies.get(getAdapterPosition()).getCompany().getTitle());
            intent.putExtra("published_at", showedDate);
            intent.putExtra("address", vacancies.get(getAdapterPosition()).getContact().getAddress());
            intent.putExtra("salary", showedSalary);
            if (vacancies.get(getAdapterPosition()).getWorkingType() != null) {
                intent.putExtra("working_type", vacancies.get(getAdapterPosition()).getWorkingType().getTitle());
            } else {
                intent.putExtra("working_type", "empty");
            }
            if (vacancies.get(getAdapterPosition()).getSchedule() != null) {
                intent.putExtra("schedule", vacancies.get(getAdapterPosition()).getSchedule().getTitle());
            } else {
                intent.putExtra("schedule", "empty");
            }
            if (vacancies.get(getAdapterPosition()).getCompany().getLogo() != null) {
                intent.putExtra("logo_url", vacancies.get(getAdapterPosition()).getCompany().getLogo().getUrl());
            } else {
                intent.putExtra("logo_url", "empty");
            }
            intent.putExtra("description", vacancies.get(getAdapterPosition()).getDescription());
            if (vacancies.get(getAdapterPosition()).getEducation() == null
                    && vacancies.get(getAdapterPosition()).getExperience() == null) {
                intent.putExtra("education_experience", (context.getString(R.string.education)
                        .concat(context.getString(R.string.no_important)).concat(context.getString(R.string.experience))
                        .concat(context.getString(R.string.no_value))));
            } else if (vacancies.get(getAdapterPosition()).getEducation() == null) {
                intent.putExtra("education_experience", (context.getString(R.string.education)
                        .concat(context.getString(R.string.no_important)).concat(context.getString(R.string.experience))
                        .concat(vacancies.get(getAdapterPosition()).getExperience().getTitle())));
            } else if (vacancies.get(getAdapterPosition()).getExperience() == null) {
                intent.putExtra("education_experience", (context.getString(R.string.education)
                        .concat(vacancies.get(getAdapterPosition()).getEducation().getTitle())
                        .concat(context.getString(R.string.experience))
                        .concat(context.getString(R.string.no_value))));
            } else {
                intent.putExtra("education_experience", (context.getString(R.string.education)
                        .concat(vacancies.get(getAdapterPosition()).getEducation().getTitle())
                        .concat(context.getString(R.string.experience))
                        .concat(vacancies.get(getAdapterPosition()).getExperience().getTitle())));
            }
            intent.putExtra("contact_url", vacancies.get(getAdapterPosition()).getContact().getUrl());
            intent.putExtra("contact_name", vacancies.get(getAdapterPosition()).getContact().getName());
            if(vacancies.get(getAdapterPosition()).getContact().getCoordinate() != null) {
                intent.putExtra("lat", String.valueOf(vacancies.get(getAdapterPosition()).getContact().getCoordinate().getLat()));
                intent.putExtra("lon", String.valueOf(vacancies.get(getAdapterPosition()).getContact().getCoordinate().getLon()));
            } else {
                intent.putExtra("lat", "empty");
            }
            context.startActivity(intent);
        }

        public VacanciesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
