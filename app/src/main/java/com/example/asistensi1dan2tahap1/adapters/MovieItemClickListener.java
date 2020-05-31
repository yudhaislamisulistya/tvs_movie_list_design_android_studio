package com.example.asistensi1dan2tahap1.adapters;

import android.widget.ImageView;

import com.example.asistensi1dan2tahap1.models.Movie;
import com.example.asistensi1dan2tahap1.models.Star;


public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageview to make the shared animation between the two activity

    void onStarClick(Star star, ImageView starImageView);

}
