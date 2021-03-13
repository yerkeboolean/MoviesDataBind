package com.example.databind.utils.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databind.R;
import com.example.databind.data.model.Movie;
import com.example.databind.databinding.MovieListItemBinding;
import com.example.databind.ui.MovieActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieRecylerAdapter extends RecyclerView.Adapter<MovieRecylerAdapter.MovieViewHolder> {

    List<Movie> movies;

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MovieListItemBinding movieListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_list_item, parent, false);

        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        Movie movie=movies.get(position);
        holder.movieListItemBinding.setMovie(movie);

        holder.movieListItemBinding.linlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MovieActivity.class);
                intent.putExtra("MovieData",holder.movieListItemBinding.getMovie());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (movies != null)
            return movies.size();
        else
            return 0;
    }

    public void setMovieList(ArrayList<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }


    class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieListItemBinding movieListItemBinding;

        public MovieViewHolder(@NonNull MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());

            this.movieListItemBinding = movieListItemBinding;
        }
    }
}
