package com.example.asistensi1dan2tahap1.ui.movies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.adapters.MovieAdapter;
import com.example.asistensi1dan2tahap1.adapters.StarAdapter;
import com.example.asistensi1dan2tahap1.models.Movie;
import com.example.asistensi1dan2tahap1.models.Star;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImg;
    private TextView tv_title,tv_description, tv_producers, tv_directors, tv_writers, tv_genres, tv_duration, tv_release, tv_rate, tv_studio;
    private FloatingActionButton play_fab;
    private RecyclerView RV_DetailMovieCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        getSupportActionBar().hide();
        iniViews();
    }

    void iniViews() {
        play_fab = findViewById(R.id.play_fab);
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_producers = findViewById(R.id.detail_movie_producer);
        tv_directors = findViewById(R.id.detail_movie_directors);
        tv_writers = findViewById(R.id.detail_movie_writers);
        tv_genres = findViewById(R.id.detail_movie_genre);
        tv_duration = findViewById(R.id.detail_movie_duration);
        tv_release = findViewById(R.id.detail_movie_release);
        tv_rate = findViewById(R.id.detail_rate);
        tv_studio = findViewById(R.id.detail_studio);
        tv_description = findViewById(R.id.detail_movie_desc);
        RV_DetailMovieCast = findViewById(R.id.RV_DetailMovieCast);

        String movieTitle = getIntent().getExtras().getString("title");
        String movieProducers = getIntent().getExtras().getString("producers");
        String movieDirectors = getIntent().getExtras().getString("directors");
        String mobieWriters = getIntent().getExtras().getString("writers");
        String movieGenres = getIntent().getExtras().getString("genres");
        String movieDuration = getIntent().getExtras().getString("duration");
        String movieRelease = getIntent().getExtras().getString("release");
        String movieRating = getIntent().getExtras().getString("rating");
        String movieStudio = getIntent().getExtras().getString("studio");
        final String movieStreamingLink = getIntent().getExtras().getString("streaminglink");
        int movieDescription = getIntent().getExtras().getInt("description");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");

        Bundle args = getIntent().getBundleExtra("BUNDLE");
        ArrayList<Star> dataStar= (ArrayList<Star>) args.getSerializable("ARRAYLIST");

        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        getSupportActionBar().setTitle(movieTitle);


        tv_title.setText(movieTitle);
        tv_producers.setText("Produser: " + movieProducers);
        tv_directors.setText("Sutradara: " + movieDirectors);
        tv_writers.setText("Penulis: " + mobieWriters);
        tv_genres.setText("Jenis: " + movieGenres);
        tv_duration.setText("Durasi: " + movieDuration);
        tv_release.setText("Tayang: " + movieRelease);
        tv_rate.setText(movieRating);
        tv_studio.setText(movieStudio);
        tv_description.setText(movieDescription);

        ArrayList<Star> data = new ArrayList<>();

        for (int i = 0; i < dataStar.size(); i++) {
            data.add(new Star(dataStar.get(i).getThumbnail(),dataStar.get(i).getFullname(),dataStar.get(i).getAlias()));
        }
        StarAdapter StarAdapter = new StarAdapter(this,data);
        RV_DetailMovieCast.setAdapter(StarAdapter);
        RV_DetailMovieCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        MovieThumbnailImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));

        play_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streaminLinkYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse(movieStreamingLink));
                startActivity(streaminLinkYoutube);
            }
        });

    }


}
