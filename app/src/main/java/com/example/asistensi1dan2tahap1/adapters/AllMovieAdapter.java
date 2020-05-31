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

public class AllMovieAdapter extends BaseAdapter {

    private ArrayList<Movie> listDataAllMovie;
    private LayoutInflater layoutInflater;

    public AllMovieAdapter(Context aContext, ArrayList<Movie> listDataAllMovie) {
        this.listDataAllMovie = listDataAllMovie;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listDataAllMovie.size();
    }

    @Override
    public Object getItem(int i) {
        return listDataAllMovie.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.item_all_movie, null);
            holder = new ViewHolder();
            holder.thummnail = (ImageView) view.findViewById(R.id.IV_ThumbnailAllMovie);
            holder.title = (TextView) view.findViewById(R.id.TV_TitleAllMovie);
            holder.min= (TextView) view.findViewById(R.id.TV_MinAllMovie);
            holder.genre = (TextView) view.findViewById(R.id.TV_GenreAllMovie);
            holder.directtur = (TextView) view.findViewById(R.id.TV_DirecturAllMovie);
            holder.stars = (TextView) view.findViewById(R.id.TV_StarsAllMovie);
            holder.play = (TextView) view.findViewById(R.id.TV_PlayAllMovie);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.thummnail.setImageResource(listDataAllMovie.get(i).getThumbnail());
        holder.title.setText(listDataAllMovie.get(i).getTitle());
        holder.min.setText(listDataAllMovie.get(i).getMin());
        holder.genre.setText(listDataAllMovie.get(i).getGenre());
        holder.directtur.setText(listDataAllMovie.get(i).getDirector());
        holder.stars.setText(listDataAllMovie.get(i).getStars());
        holder.play.setText(listDataAllMovie.get(i).getPlay());
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
