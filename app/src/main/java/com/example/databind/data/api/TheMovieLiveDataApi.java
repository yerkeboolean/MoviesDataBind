package com.example.databind.data.api;

import androidx.lifecycle.LiveData;

import com.example.databind.data.api.NetworkUtils.ApiResponse;
import com.example.databind.data.model.PopularMovie;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieLiveDataApi {

    @GET("movie/popular")
    LiveData<ApiResponse<PopularMovie>> getPopularMovies(@Query("api_key") String api_key);
}
