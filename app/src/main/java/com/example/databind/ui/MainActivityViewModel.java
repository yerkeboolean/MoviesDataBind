package com.example.databind.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.databind.MyCallback;
import com.example.databind.data.api.NetworkUtils.ResourceKt;
import com.example.databind.data.api.TheMovieRepository;
import com.example.databind.data.model.Movie;
import com.example.databind.data.model.PopularMovie;

import java.util.List;


public class MainActivityViewModel extends ViewModel {
    private TheMovieRepository repository;

    public MainActivityViewModel() {
        repository = new TheMovieRepository();
    }

    public LiveData<List<Movie>> getMovies(){
        return repository.getPopularMovies();
    }

    public LiveData<ResourceKt<PopularMovie>> getPupular(){
        return repository.getPopularMovie();
    }
}
