package com.example.databind.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMovie {

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("results")
    @Expose
    private List<Movie> movies;

    public PopularMovie() {
    }

    public PopularMovie(int page, List<Movie> movies) {
        this.page = page;
        this.movies = movies;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
