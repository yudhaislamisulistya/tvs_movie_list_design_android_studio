package com.example.asistensi1dan2tahap1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.models.Star;

import java.util.ArrayList;
import java.util.List;


public class StarAdapter extends RecyclerView.Adapter<StarAdapter.MyViewHolder> {

    Context context ;
    ArrayList<Star> mData;
    MovieItemClickListener movieItemClickListener;


    public StarAdapter(Context context, ArrayList<Star> mData) {
        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_star,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.TvFullname.setText(mData.get(i).getFullname());
        myViewHolder.ImgStar.setImageResource(mData.get(i).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView TvFullname;
        private ImageView ImgStar;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            TvFullname = itemView.findViewById(R.id.item_star_fullaname);
            ImgStar = itemView.findViewById(R.id.item_star_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClickListener.onStarClick(mData.get(getAdapterPosition()),ImgStar);
                }
            });

        }
    }
}
