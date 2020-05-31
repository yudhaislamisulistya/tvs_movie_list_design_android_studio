package com.example.asistensi1dan2tahap1.ui.up_coming_movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.adapters.UpComingMovieAdapter;
import com.example.asistensi1dan2tahap1.models.Movie;
import com.example.asistensi1dan2tahap1.models.Star;
import com.example.asistensi1dan2tahap1.ui.movies.MovieDetailActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class UpComingMovieFragment extends Fragment {

    private UpComingMovieViewModel mViewModel;
    private ListView LSUpComing;
    public static UpComingMovieFragment newInstance() {
        return new UpComingMovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#303960")));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>ProfileFragment</font>"));
        View root =  inflater.inflate(R.layout.fragment_up_coming_movie, container, false);
        LSUpComing = (ListView) root.findViewById(R.id.LS_UpComing);

        ArrayList upComingList = getDataUpComing();

        UpComingMovieAdapter upComingMovieAdapter = new UpComingMovieAdapter(getContext(), upComingList);
        LSUpComing.setAdapter(upComingMovieAdapter);
        LSUpComing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Movie movie = (Movie) LSUpComing.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) movie.getStar());
                intent.putExtra("title",movie.getTitle());
                intent.putExtra("producers",movie.getProducer());
                intent.putExtra("directors",movie.getDirector());
                intent.putExtra("writers",movie.getWriter());
                intent.putExtra("genres",movie.getGenre());
                intent.putExtra("duration",movie.getMin());
                intent.putExtra("release",movie.getPlay());
                intent.putExtra("rating",movie.getRating());
                intent.putExtra("studio",movie.getStudio());
                intent.putExtra("BUNDLE",args);
                intent.putExtra("streaminglink",movie.getStreamingLink());
                intent.putExtra("description",movie.getDescription());

                intent.putExtra("imgURL",movie.getThumbnail());
                intent.putExtra("imgCover",movie.getThumbnail());

                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UpComingMovieViewModel.class);
        // TODO: Use the ViewModel
    }

    private ArrayList getDataUpComing(){
        ArrayList<Movie> result = new ArrayList<>();
        ArrayList<Star> stars = new ArrayList<>();

        stars.add(new Star(R.drawable.anna_kendrick, "Anna Kendrick", "Poppy"));
        stars.add(new Star(R.drawable.justin_timberlake, "Justin Timberlake", "Branch"));
        stars.add(new Star(R.drawable.rachel_bloom, "Rachel Bloom", "Bloom"));
        stars.add(new Star(R.drawable.kelly_clarkson, "Kelly Clarkson", "Kelly"));
        stars.add(new Star(R.drawable.james_corden, "James Corden", "James"));

        result.add(new Movie("Kajillionaire", R.drawable.kajillionaire,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "106 Menit", "Crime, Drama", "Focus Feature", "Miranda July","Miranda July", "Evan Rachel Wood, Debra Winger, Gina Rodriguez", "18 September 2020 (USA)","5.8/10" ,"Plan B Entertaiment", "https://www.youtube.com/watch?v=bN25v1US0h8" ,stars));

        result.add(new Movie("Unhinged", R.drawable.unhinged,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Thriller", "Andrew Gunn, Mark Gill, Lisa Ellzey", "Derrick Borte","Carl Ellsworth", "Russell Crowe, Jimmi Simpson, Caren Pistorius", "1 July 2020 (USA)","-" ,"Ingenious Media", "https://www.youtube.com/watch?v=vdxDXoODKN8" ,stars));

        result.add(new Movie("Tenet", R.drawable.tenet,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Action, Sci_fi, Thriller", "Christopher Nolan ", "Christopher Nolan","Christopher Nolan", "John David Washington, Robert Pattinson, Elizabeth Debicki", "17 July 2020 (USA)","-" ,"Warner Bross", "https://www.youtube.com/watch?v=L3pk_TBkihU" ,stars));

        result.add(new Movie("Mulan", R.drawable.mulan,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "105 Menit", "Action, Adventure, Drama", "Niki Caro", "Niki Caro","Rick Jaffa", "Yifei Liu, Donnie Yen, Li Gong ", "July 23, 2020","-" ,"Walt Disney Picture", "https://www.youtube.com/watch?v=KK8FHdFluOQ" ,stars));

        result.add(new Movie("Most Wanted", R.drawable.most_wanted,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "135 Menit", "Biography, Chrime, Thriller", "Daniel Roby", "Daniel Roby","Daniel Roby", "Josh Hartnett, Stephen McHattie, J.C. MacKenzie", "2020 (Canada)","-" ,"Rotten Tomatoes", "https://www.youtube.com/watch?v=WWGE29d34iU" ,stars));

        result.add(new Movie("The SpongeBob Movie: Sponge on the Run", R.drawable.the_spongebob_movie_sponge_on_the_run,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "135 Menit", "Animation, Adventure, Comedy", "Ryan Harris", "Tim Hill","Tim Hill", "Keanu Reeves, Clancy Brown, Awkwafina", "7 August 2020 (USA)","-" ,"Nickelodeon Movies", "https://www.youtube.com/watch?v=HfiH_526qhY" ,stars));

        result.add(new Movie("Wonder Woman 1984", R.drawable.wonder_woman_1984,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Action, Adventure, Fantasy ", "Gal Galdot", "Patty Jenkins","Geoff Johns", "Pedro Pascal, Connie Nielsen, Gal Gadot ", "14 August 2020 (USA)","-" ,"DC Films", "https://www.youtube.com/watch?v=sfM7_JLk-84" ,stars));

        result.add(new Movie("The One and Only Ivan", R.drawable.the_one_and_only_ivan,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Animation, Adventure, Comedy", "Gal Galdot", "Thea Sharrock","Katherine Applegate", "Angelina Jolie, Sam Rockwell, Bryan Cranston", "14 August 2020 (USA)","-" ,"Walt Disney Pictures", "https://www.youtube.com/watch?v=54lIUi5-kb4" ,stars));

        result.add(new Movie("The Secret Garden", R.drawable.the_secret_garden,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "99 Menit", "Drama, Family, Fantasy", "Frederick A. Stokes\u200E ", "Marc Munden","Frances Hodgson Burnett", "Dixie Egerickx, Colin Firth, Julie Walters", "20 August 2020 (Singapore)","-" ,"Heyday Films", "https://www.youtube.com/watch?v=gHNOXDiD9Vk" ,stars));

        result.add(new Movie("Sputnik ", R.drawable.sputnik,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "113 Menit", "Horror, Sci-Fi", "Frederick A. Stokes ", "Egor Abramenko","Andrei Zolotarev", "Oksana Akinshina, Fedor Bondarchuk, Pyotr Fyodorov", "15 April 2020 (USA)","-" ,"Energia Films", "https://www.youtube.com/watch?v=xhLORcya9GU" ,stars));

        result.add(new Movie("Antebellum ", R.drawable.antebellum,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "104 Menit", "Horror, Thriller ", "Sean McKittrick ", "Gerard Bush, Christopher Renz","Gerard Bush, Christopher Renz", "Janelle Monáe, Eric Lange, Jena Malone", "21 August 2020 (USA)","-" ,"Lionsgate Films", "https://www.youtube.com/watch?v=mXcZ7WDsVwk" ,stars));

        result.add(new Movie("Let Him Go ", R.drawable.let_him_go,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Crime, Drama, Thriller ", "Mitchell Kaplan ", "Thomas Bezucha","Thomas Bezucha", "Kevin Costner, Diane Lane, Lesley Manville", "21 August 2020 (USA)","-" ,"Mazur Kaplan Company", "https://www.youtube.com/watch?v=mXcZ7WDsVwk" ,stars));

        result.add(new Movie("Tesla  ", R.drawable.tesla,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "86 Menit", "Biography, Drama", "Uri Singer ", "Michael Almereyda","Michael Almereyda", "Eve Hewson, Ethan Hawke, Hannah Gross |", "27 January 2020 (USA)","6.9/10" ,"IFC Films", "https://www.youtube.com/watch?v=C-7o8i4geIw" ,stars));

        result.add(new Movie("The New Mutants  ", R.drawable.the_new_mutans,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Action, Horror, Sci-Fi", "Karen Rosenfelt ", "Josh Boone","Josh Boone", "Maisie Williams, Anya Taylor-Joy, Charlie Heaton", "28 August 2020 (USA)","6.9/10" ,"20th Century Studios", "https://www.youtube.com/watch?v=C-7o8i4geIw" ,stars));

        return result;
    }

}
