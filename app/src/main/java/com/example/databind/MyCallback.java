package com.example.databind;

import com.example.databind.data.model.Movie;

public interface MyCallback {

    void onSuccess(Movie movie);

    void onError(String message);
}
