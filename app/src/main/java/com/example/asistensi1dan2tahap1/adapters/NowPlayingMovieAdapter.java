package com.example.asistensi1dan2tahap1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.models.Movie;

import java.util.ArrayList;

public class NowPlayingMovieAdapter extends BaseAdapter {

    private ArrayList<Movie> listDataNowPlaying;
    private LayoutInflater layoutInflater;

    public NowPlayingMovieAdapter(Context aContext, ArrayList<Movie> listDataNowPlaying) {
        this.listDataNowPlaying = listDataNowPlaying;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listDataNowPlaying.size();
    }

    @Override
    public Object getItem(int i) {
        return listDataNowPlaying.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.item_now_playing_movie, null);
            holder = new ViewHolder();
            holder.thummnail = (ImageView) view.findViewById(R.id.IV_ThumbnailNowPlaying);
            holder.title = (TextView) view.findViewById(R.id.TV_TitleNowPlaying);
            holder.min= (TextView) view.findViewById(R.id.TV_MinNowPlaying);
            holder.genre = (TextView) view.findViewById(R.id.TV_GenreNowPlaying);
            holder.directtur = (TextView) view.findViewById(R.id.TV_DirecturNowPlaying);
            holder.stars = (TextView) view.findViewById(R.id.TV_StarsNowPlaying);
            holder.play = (TextView) view.findViewById(R.id.TV_PlayNowPlaying);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.thummnail.setImageResource(listDataNowPlaying.get(i).getThumbnail());
        holder.title.setText(listDataNowPlaying.get(i).getTitle());
        holder.min.setText(listDataNowPlaying.get(i).getMin());
        holder.genre.setText(listDataNowPlaying.get(i).getGenre());
        holder.directtur.setText(listDataNowPlaying.get(i).getDirector());
        holder.stars.setText(listDataNowPlaying.get(i).getStars());
        holder.play.setText(listDataNowPlaying.get(i).getPlay());
        view.setTag(holder);

        return view;
    }

    static class ViewHolder {
        ImageView thummnail;
        TextView title;
        TextView min;
        TextView genre;
        TextView directtur;
        TextView stars;
        TextView play;

    }
}
