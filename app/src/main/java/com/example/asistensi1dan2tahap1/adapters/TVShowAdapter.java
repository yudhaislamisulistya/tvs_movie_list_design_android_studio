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
import com.example.asistensi1dan2tahap1.models.TVShow;

import java.util.ArrayList;

public class TVShowAdapter extends BaseAdapter {

    private ArrayList<TVShow> listDataTVShow;
    private LayoutInflater layoutInflater;

    public TVShowAdapter(Context aContext, ArrayList<TVShow> listDataTVShow) {
        this.listDataTVShow = listDataTVShow;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listDataTVShow.size();
    }

    @Override
    public Object getItem(int i) {
        return listDataTVShow.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.item_tv_show, null);
            holder = new ViewHolder();
            holder.thumbnail = (ImageView) view.findViewById(R.id.IV_ThumbnailTVShow);
            holder.title = (TextView) view.findViewById(R.id.TV_TitleTVShow);
            holder.min= (TextView) view.findViewById(R.id.TV_MinTVShow);
            holder.genre = (TextView) view.findViewById(R.id.TV_GenreTVShow);
            holder.creator = (TextView) view.findViewById(R.id.TV_CreatorTVShow);
            holder.stars = (TextView) view.findViewById(R.id.TV_StarsTVShow);
            holder.play = (TextView) view.findViewById(R.id.TV_PlayTVShow);
            holder.season = (TextView) view.findViewById(R.id.TV_SeasonTVShow);
            holder.episode = (TextView) view.findViewById(R.id.TV_EpisodeTVShow);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.thumbnail.setImageResource(listDataTVShow.get(i).getThumbnail());
        holder.title.setText(listDataTVShow.get(i).getTitle());
        holder.min.setText(listDataTVShow.get(i).getMin());
        holder.genre.setText(listDataTVShow.get(i).getGenre());
        holder.creator.setText(listDataTVShow.get(i).getCreator());
        holder.stars.setText(listDataTVShow.get(i).getStars());
        holder.play.setText(listDataTVShow.get(i).getPlay());
        holder.season.setText(String.valueOf(listDataTVShow.get(i).getSeason()));
        holder.episode.setText(String.valueOf(listDataTVShow.get(i).getEpisode()));
        view.setTag(holder);

        return view;
    }

    static class ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView min;
        TextView genre;
        TextView creator;
        TextView stars;
        TextView play;
        TextView season;
        TextView episode;
    }
}
