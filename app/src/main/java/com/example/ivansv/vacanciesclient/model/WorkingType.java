package com.example.ivansv.vacanciesclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkingType {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("title")
    @Expose
    private String title;

    public WorkingType(long id, String title) {
        this.id = id;
        this.title = title;
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
}
