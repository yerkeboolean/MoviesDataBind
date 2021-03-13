package com.example.databind.data.api;

import androidx.lifecycle.LiveData;

import com.example.databind.data.model.Movie;
import com.example.databind.data.model.PopularMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheMovieApi {

    @GET("movie/popular")
    Call <PopularMovie> getPopularMovies(@Query("api_key") String api_key);

    @GET("discover/movie")
    Call<Movie> getMovies(@Query("api_key") String api_key);

    @GET("movie/{movie_id}")
    Call<Movie> getMovieById(@Path("movie_id") int movieID, @Query("api_key") String api_key);

}
