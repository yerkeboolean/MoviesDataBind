package com.example.databind.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.databind.R;
import com.example.databind.data.api.NetworkUtils.ResourceKt;
import com.example.databind.data.model.Movie;
import com.example.databind.data.model.PopularMovie;
import com.example.databind.databinding.ActivityMainBinding;
import com.example.databind.utils.Adapters.MovieRecylerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    private MovieRecylerAdapter movieRecylerAdapter;
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = activityMainBinding.rvMovie;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        movieRecylerAdapter = new MovieRecylerAdapter();
        recyclerView.setAdapter(movieRecylerAdapter);

        getMovies();
    }

    public void getMovies() {
        mainActivityViewModel.getPupular().observe(this, new Observer<ResourceKt<PopularMovie>>() {
            @Override
            public void onChanged(ResourceKt<PopularMovie> listResourceKt) {
                switch (listResourceKt.getStatus()) {
                    case SUCCESS:
                        activityMainBinding.pgpg.setVisibility(View.GONE);
                        activityMainBinding.rvMovie.setVisibility(View.VISIBLE);
                        movieRecylerAdapter.setMovieList((ArrayList<Movie>) listResourceKt.getData().getMovies());
                        break;
                    case LOADING:
                        activityMainBinding.pgpg.setVisibility(View.VISIBLE);
                        break;
                    case ERROR:
                        activityMainBinding.pgpg.setVisibility(View.GONE);
                        activityMainBinding.tvtv.setVisibility(View.VISIBLE);
                        activityMainBinding.tvtv.setText(listResourceKt.getMessage());
                        break;
                }
            }
        });
    }

}
