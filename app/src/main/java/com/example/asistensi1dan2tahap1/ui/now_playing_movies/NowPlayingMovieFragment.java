package com.example.asistensi1dan2tahap1.ui.now_playing_movies;

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
import com.example.asistensi1dan2tahap1.adapters.NowPlayingMovieAdapter;
import com.example.asistensi1dan2tahap1.models.Movie;
import com.example.asistensi1dan2tahap1.models.Star;
import com.example.asistensi1dan2tahap1.ui.movies.MovieDetailActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class NowPlayingMovieFragment extends Fragment {

    private NowPlayingMovieViewModel mViewModel;
    private ListView LSNowPlaying;
    public static NowPlayingMovieFragment newInstance() {
        return new NowPlayingMovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#303960")));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>ProfileFragment</font>"));
        View root = inflater.inflate(R.layout.fragment_now_playing_movie, container, false);

        LSNowPlaying = (ListView) root.findViewById(R.id.LS_NowPlaying);

        ArrayList nowPlayingList = getDataNowPlaying();

        NowPlayingMovieAdapter nowPlayingMovieAdapter = new NowPlayingMovieAdapter(getContext(), nowPlayingList);
        LSNowPlaying.setAdapter(nowPlayingMovieAdapter);
        LSNowPlaying.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Movie movie = (Movie) LSNowPlaying.getItemAtPosition(position);

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
        mViewModel = ViewModelProviders.of(this).get(NowPlayingMovieViewModel.class);
        // TODO: Use the ViewModel
    }

    private ArrayList getDataNowPlaying(){
        ArrayList<Movie> result = new ArrayList<>();
        ArrayList<Star> stars = new ArrayList<>();

        stars.add(new Star(R.drawable.anna_kendrick, "Anna Kendrick", "Poppy"));
        stars.add(new Star(R.drawable.justin_timberlake, "Justin Timberlake", "Branch"));
        stars.add(new Star(R.drawable.rachel_bloom, "Rachel Bloom", "Bloom"));
        stars.add(new Star(R.drawable.kelly_clarkson, "Kelly Clarkson", "Kelly"));
        stars.add(new Star(R.drawable.james_corden, "James Corden", "James"));

        result.add(new Movie("Trolls World Tour", R.drawable.trolls_world_tour,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "120 Menit", "Animation, Adventure, Comedy", "Gina Shay", "Walter Dohrn","Jonathan Aibel, Glenn Berger", "Anna Kendrick, Justin Timberlake, Rachel Bloom", "April","-" ,"Universal Pictures", "https://www.youtube.com/watch?v=yP86-TR6IME" ,stars));

        result.add(new Movie("Jexi", R.drawable.jexi,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "110 Menit", "Comedy", "Suzanne Todd", "Jon Lucas, Scott Moore","Jon Lucas, Scott Moore", "Adam Devine, Rose Byrne, Alexandra Shipp", "Oktober","-" ,"Entertaiment One", "https://www.youtube.com/watch?v=txSOaY-je-o" ,stars));

        result.add(new Movie("Bucin", R.drawable.bucin,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "126 Menit", "Comedy, Romance", "Gope T Samtani, Sunil Samtani", "Chandra Liow","Jovial da Lopez", "Andovi da Lopez, Jovial da Lopez, Tommy Limmm", "Maret","-" ,"Rapi Films", "https://www.youtube.com/watch?v=xSdAC9WSJ5s" ,stars));

        result.add(new Movie("Malik & Elsa", R.drawable.malik_dan_elsa,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "110 Menit", "Romance", "Agus Basuki, Ody Mulya Hidayat", "Eddy Prasetya","Nana Mulyana, Media Kita", "Salshabilla Andriani, Endi Arfian, H. Mahyeldi SP", "April","-" ,"MAX Pictures", "https://www.youtube.com/watch?v=KGXTYsZE5Vo" ,stars));

        result.add(new Movie("I Still Believe", R.drawable.i_still_believe,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "155 Menit", "Drama, Music, Romance", "Kevin Downes, Andrew Erwin", "Andrew Erwin, Jon Erwin","Jon Erwin, Jon Gunn", "K.J. Apa, Britt Robertson, Abigail Cowen", "Maret","6.5/10" ,"Lionsgate", "https://www.youtube.com/watch?v=YnxHyBbYwQQ" ,stars));

        result.add(new Movie("The Cave", R.drawable.the_cave,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "197 menit", "Horror, Thriller", "Allen Liu, Tom Waller", "Tom Waller","Tom Waller", "Maythavee Burapasing, Ron Smoorenburg, Kelly B. Jones", "Maret","5.1/10" ,"De Warrenner Picture", "https://www.youtube.com/watch?v=GloDhxD_bbc" ,stars));

        result.add(new Movie("Tarung Sarung", R.drawable.tarung_sarung,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "130 Menit", "Drama, Religious", "Chand Parwez Servia, Fiaz Servia", "Archie Hekagery","Archie Hekagery", "Panji Zoni, Yayan Ruhiyan, Maizura, Cemal Faruk", "December 31, 2020","-" ,"Starvision", "https://www.youtube.com/watch?v=V48qhATHklc" ,stars));

        result.add(new Movie("Walking Dead Tomate", R.drawable.walking_dead_tomate,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Horror, Drama", "Nona Quiliem, Ekadi Katili", "Ekadi Katili","Beni Susanto", "Iqbal Perdana, Yulinar Arief, Aga Dirgantara", "April 16, 2020","-" ,"Cinekadi Pictures", "https://www.youtube.com/watch?v=6CNbITLDWos" ,stars));

        result.add(new Movie("My Spy", R.drawable.my_spy,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Action, Comedy, Family", "Dave Bautista, Chris Bender", "Peter Segal","Erich Hoeber, Jon Hoeber", "Dave Bautista, Kristen Schaal, Parisa Fitz-Henley", "January 9, 2020","6.2/10" ,"MWM Studios", "https://www.youtube.com/watch?v=imMQskUW_Ik" ,stars));

        result.add(new Movie("Jodohku yang Mana? (Molulo 2)", R.drawable.jodohku_yang_mana,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Drama, Comedy", "Partono Wiraputra, Andi Arsyil Rahman, Santi Muzhar", "Irham Acho Bahtiar","Ferdy. K, Andi Arsyil Rahman", "Andi Arsyil, Arlita Reggiana, Alexa Key", "March 19, 2020","-" ,"Moov Pictures", "https://www.youtube.com/watch?v=1zb64S1bF_U" ,stars));

        result.add(new Movie("Djoerig Salawe", R.drawable.djorieg_salawe,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "168 Menit", "Drama, Comedy, Horror", "dr Robby Hilman, Budi Yulianto, Cut Puti, M Rizky", "Sahrul Gibran","Fajar Umbara, Isman H", "Joe P Project, Fico Fahreza, Aming, Ben Kasyafani", "March 26, 2020","-" ,"MBK Pictures", "https://www.youtube.com/watch?v=D-Un3p637js" ,stars));

        result.add(new Movie("Roh Mati Paksa", R.drawable.roh_mati_paksa,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "177", "Horror, Action", "Unchu Viejay", "Adi Garing","Agus Noor Ismail", "Arnold Leonard, Dea Annisa, Gabriella Larasati", "March 26, 2020","-" ,"Super Media Pictures", "https://www.youtube.com/watch?v=5Hl6isbAW24" ,stars));

        result.add(new Movie("Trauma Center", R.drawable.trauma_center,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "147 Menit", "Action, Thriller", "Randall Emmett, George Furla, Luillo Ruiz, Mark Stewart", "Matt Eskandari","Paul Da Silva", "Bruce Willis, Nicky Whelan, Steve Guttenberg", "December 6, 2019","5/10" ,"Highland Film Group", "https://www.youtube.com/watch?v=1gUR-WRVf6U" ,stars));

        result.add(new Movie("Killer Man", R.drawable.killerman,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "133 Menit", "Action, Crime, Drama", "Mary Aloe, Craig Chapman, Myles Nestel", "Malik Bader","Malik Bader", "Liam Hemsworth, Emory Cohen, Diane Guerrero", "August 8, 2019","5.6/10" ,"Solution Entertainment Group", "https://www.youtube.com/watch?v=i5niXDUtGEM" ,stars));

        result.add(new Movie("Gretel & Hansel", R.drawable.greter_and_hansel,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "87 Menit", "Horror, Fantasy", "Brian Kavanaugh Jones, Fred Berger", "Osgood Perkins","Rob Hayes", "Sophia Lillis, Sammy Leakey, Charles Babalola", "August 8, 2019","5.3/10" ,"Orion Pictures", "https://www.youtube.com/watch?v=6ZgkHjpUM8w" ,stars));

        result.add(new Movie("Teen Spirit", R.drawable.teen_spirit,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "87 Menit", "Drama, Music", "Fred Berger", "Max Minghella","Max Minghella", "Elle Fanning, Rebecca Hall, Agnieszka Grochowska", "June 20, 2019","6.1/10" ,"Elevation Pictures", "https://www.youtube.com/watch?v=CkA6DpQEKTU" ,stars));



        return result;
    }

}
