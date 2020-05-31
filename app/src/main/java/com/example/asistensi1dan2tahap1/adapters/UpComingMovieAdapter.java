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

public class UpComingMovieAdapter extends BaseAdapter {

    private ArrayList<Movie> listDataUpComing;
    private LayoutInflater layoutInflater;

    public UpComingMovieAdapter(Context aContext, ArrayList<Movie> listDataUpComing) {
        this.listDataUpComing = listDataUpComing;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listDataUpComing.size();
    }

    @Override
    public Object getItem(int i) {
        return listDataUpComing.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.item_upcoming_movie, null);
            holder = new ViewHolder();
            holder.thummnail = (ImageView) view.findViewById(R.id.IV_ThumbnailUpComing);
            holder.title = (TextView) view.findViewById(R.id.TV_TitleUpComing);
            holder.min= (TextView) view.findViewById(R.id.TV_MinUpComing);
            holder.genre = (TextView) view.findViewById(R.id.TV_GenreUpComing);
            holder.directtur = (TextView) view.findViewById(R.id.TV_DirecturUpComing);
            holder.stars = (TextView) view.findViewById(R.id.TV_StarsUpComing);
            holder.play = (TextView) view.findViewById(R.id.TV_PlayUpComing);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.thummnail.setImageResource(listDataUpComing.get(i).getThumbnail());
        holder.title.setText(listDataUpComing.get(i).getTitle());
        holder.min.setText(listDataUpComing.get(i).getMin());
        holder.genre.setText(listDataUpComing.get(i).getGenre());
        holder.directtur.setText(listDataUpComing.get(i).getDirector());
        holder.stars.setText(listDataUpComing.get(i).getStars());
        holder.play.setText(listDataUpComing.get(i).getPlay());
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
