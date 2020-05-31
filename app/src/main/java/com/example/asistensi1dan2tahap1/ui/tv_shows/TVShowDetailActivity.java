package com.example.asistensi1dan2tahap1.ui.tv_shows;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.adapters.StarAdapter;
import com.example.asistensi1dan2tahap1.models.Star;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TVShowDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImg;
    private TextView tv_title,tv_description, tv_creator, tv_season, tv_episode, tv_genres, tv_duration, tv_release, tv_rate, tv_studio;
    private FloatingActionButton play_fab;
    private RecyclerView RV_DetailTVShowCast;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);
        getSupportActionBar().hide();
        iniViews();
    }
    
    private void iniViews(){

        play_fab = findViewById(R.id.play_fab);
        MovieThumbnailImg = findViewById(R.id.detail_tvshow_img);
        MovieCoverImg = findViewById(R.id.detail_tvshow_cover);
        tv_title = findViewById(R.id.detail_tvshow_title);
        tv_creator = findViewById(R.id.detail_tvshow_creator);
        tv_season = findViewById(R.id.detail_tvshow_season);
        tv_episode = findViewById(R.id.detail_tvshow_episode);
        tv_genres = findViewById(R.id.detail_tvshow_genre);
        tv_duration = findViewById(R.id.detail_tvshow_duration);
        tv_release = findViewById(R.id.detail_tvshow_release);
        tv_rate = findViewById(R.id.detail_rate);
        tv_studio = findViewById(R.id.detail_studio);
        tv_description = findViewById(R.id.detail_tvshow_desc);
        RV_DetailTVShowCast = findViewById(R.id.RV_DetailTVShowCast);

        String tvshowTitle = getIntent().getExtras().getString("title");
        String tvshowCreator = getIntent().getExtras().getString("creator");
        int tvshowSeason = getIntent().getExtras().getInt("season");
        int tvshowEpisode = getIntent().getExtras().getInt("episode");
        String tvshowGenres = getIntent().getExtras().getString("genres");
        String tvshowDuration = getIntent().getExtras().getString("duration");
        String tvshowRelease = getIntent().getExtras().getString("release");
        String tvshowRating = getIntent().getExtras().getString("rating");
        String tvshowStudio = getIntent().getExtras().getString("studio");
        final String tvshowStreamingLink = getIntent().getExtras().getString("streaminglink");
        int tvshowDescription = getIntent().getExtras().getInt("description");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");

        Bundle args = getIntent().getBundleExtra("BUNDLE");
        ArrayList<Star> dataStar= (ArrayList<Star>) args.getSerializable("ARRAYLIST");

        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        getSupportActionBar().setTitle(tvshowTitle);


        tv_title.setText(tvshowTitle);
        tv_creator.setText("Kreator: " + tvshowCreator);
        tv_season.setText("Season: " + String.valueOf(tvshowSeason));
        tv_episode.setText("Episode: " + String.valueOf(tvshowEpisode));
        tv_genres.setText("Jenis: " + tvshowGenres);
        tv_duration.setText("Durasi: " + tvshowDuration);
        tv_release.setText("Tayang: " + tvshowRelease);
        tv_rate.setText(tvshowRating);
        tv_studio.setText(tvshowStudio);
        tv_description.setText(tvshowDescription);

        ArrayList<Star> data = new ArrayList<>();

        for (int i = 0; i < dataStar.size(); i++) {
            data.add(new Star(dataStar.get(i).getThumbnail(),dataStar.get(i).getFullname(),dataStar.get(i).getAlias()));
        }
        StarAdapter StarAdapter = new StarAdapter(this,data);
        RV_DetailTVShowCast.setAdapter(StarAdapter);
        RV_DetailTVShowCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        MovieThumbnailImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));

        play_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streaminLinkYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse(tvshowStreamingLink));
                startActivity(streaminLinkYoutube);
            }
        });
        
    }
}
