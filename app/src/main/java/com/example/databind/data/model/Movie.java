package com.example.databind.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("overview")
    @Expose
    private String description;
    @SerializedName("vote_average")
    @Expose
    private double vote_over;
    @SerializedName("poster_path")
    @Expose
    private String imgUrl;

    public Movie() {
    }

    public Movie(int id, String title, String description, double vote_over, String imgUrl) {
        this.title = title;
        this.description = description;
        this.vote_over = vote_over;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getVote_over() {
        return vote_over;
    }

    public void setVote_over(double vote_over) {
        this.vote_over = vote_over;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", vote_over=" + vote_over +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public String wrapUrl(){
        String url_base="http://image.tmdb.org/t/p/w185/";
        System.out.println("//////////////"+url_base+imgUrl);
        return url_base+imgUrl;
    }
}
