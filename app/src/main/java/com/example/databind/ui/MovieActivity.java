package com.example.databind.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databind.R;
import com.example.databind.data.model.Movie;
import com.example.databind.databinding.ActivityMovieBinding;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieBinding activityMovieBinding=DataBindingUtil.setContentView(this,R.layout.activity_movie);

        Intent intent=getIntent();
        Movie movie= (Movie) intent.getExtras().getSerializable("MovieData");

        activityMovieBinding.setMovie(movie);
    }

}
