package com.example.databind.data.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.databind.common.AppConstants;
import com.example.databind.data.api.NetworkUtils.NetworkOnlyRepository;
import com.example.databind.data.api.NetworkUtils.ResourceKt;
import com.example.databind.data.api.NetworkUtils.ApiResponse;
import com.example.databind.data.model.Movie;
import com.example.databind.data.model.PopularMovie;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheMovieRepository {

    NetworkService networkService;

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveDataMovies = new MutableLiveData<>();

    public TheMovieRepository() {
        this.networkService = NetworkService.getInstance();
    }

    public MutableLiveData<List<Movie>> getPopularMovies() {
        networkService.getMovieApi()
                .getPopularMovies(AppConstants.API_KEY)
                .enqueue(new Callback<PopularMovie>() {
                    @Override
                    public void onResponse(Call<PopularMovie> call, Response<PopularMovie> response) {
                        PopularMovie popularMovie = response.body();
                        if (popularMovie.getMovies() != null) {
                            movies = (ArrayList<Movie>) popularMovie.getMovies();
                            mutableLiveDataMovies.setValue(movies);
                        }
                    }

                    @Override
                    public void onFailure(Call<PopularMovie> call, Throwable t) {

                    }
                });

        return mutableLiveDataMovies;
    }

    public LiveData<ResourceKt<PopularMovie>> getPopularMovie(){
        return new NetworkOnlyRepository<PopularMovie, PopularMovie>() {
            @Override
            protected void saveLoadedData(PopularMovie item) {

            }

            @Override
            protected void onFetchFailed(@Nullable Throwable error) {

            }

            @NotNull
            @Override
            protected LiveData<ApiResponse<PopularMovie>> fetchService() {
                return networkService.getMovieLiveDataApi().getPopularMovies(AppConstants.API_KEY);
            }
        }.asLiveData();
    }


}
