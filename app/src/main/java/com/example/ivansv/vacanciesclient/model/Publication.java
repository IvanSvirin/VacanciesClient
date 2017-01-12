package com.example.ivansv.vacanciesclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Publication {
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("type")
    @Expose
    private String type;

    public Publication(String publishedAt, String type) {
        this.publishedAt = publishedAt;
        this.type = type;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
