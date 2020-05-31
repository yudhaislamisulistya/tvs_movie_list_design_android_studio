package com.example.asistensi1dan2tahap1.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.adapters.MovieAdapter;
import com.example.asistensi1dan2tahap1.adapters.MovieItemClickListener;
import com.example.asistensi1dan2tahap1.adapters.SliderPagerAdapter;
import com.example.asistensi1dan2tahap1.models.Movie;
import com.example.asistensi1dan2tahap1.models.Slide;
import com.example.asistensi1dan2tahap1.models.Star;
import com.example.asistensi1dan2tahap1.models.TVShow;
import com.example.asistensi1dan2tahap1.ui.movies.AllMovieActivity;
import com.example.asistensi1dan2tahap1.ui.movies.MovieDetailActivity;
import com.example.asistensi1dan2tahap1.ui.tv_shows.TVShowsActivity;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements MovieItemClickListener {

    private List<Slide> lstSlides ;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV, UpcomingRV, NowPlayingRV, SemuaFilmRV, TVShowRV;
    private TextView TVDetailAllMovie, TVDetailTVShow;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#303960")));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>ProfileFragment</font>"));


        sliderpager = root.findViewById(R.id.slider_pager) ;
        indicator = root.findViewById(R.id.indicator);
        MoviesRV = root.findViewById(R.id.Rv_movies);
        UpcomingRV = root.findViewById(R.id.Rv_Upcoming);
        NowPlayingRV = root.findViewById(R.id.Rv_Nowplaying);
        SemuaFilmRV = root.findViewById(R.id.Rv_SemuaFilm);
        TVShowRV = root.findViewById(R.id.Rv_TVShows);
        TVDetailAllMovie = root.findViewById(R.id.detail_all_movie);
        TVDetailTVShow = root.findViewById(R.id.detail_all_tv_show);

        TVDetailAllMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AllMovieActivity.class));
            }
        });

        TVDetailTVShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TVShowsActivity.class));
            }
        });



        lstSlides = new ArrayList<>() ;
        lstSlides.add(new Slide(R.drawable.slide1,"X-Men: Apocalypse", "https://www.youtube.com/watch?v=Jer8XjMrUB4"));
        lstSlides.add(new Slide(R.drawable.slide2,"Fantastic Beasts and Where to Find Them", "https://www.youtube.com/watch?v=ViuDsy7yb8M"));
        lstSlides.add(new Slide(R.drawable.slide1,"X-Men: Apocalypse", "https://www.youtube.com/watch?v=Jer8XjMrUB4"));
        lstSlides.add(new Slide(R.drawable.slide2,"Fantastic Beasts and Where to Find Them", "https://www.youtube.com/watch?v=ViuDsy7yb8M"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(getContext(),lstSlides);
        sliderpager.setAdapter(adapter);
        indicator.setupWithViewPager(sliderpager,true);

        // Recyclerview Setup
        // ini data

        List<Movie> lstMovies = getDataMovieBestPopuler();

        MovieAdapter movieAdapter = new MovieAdapter(getContext(),lstMovies,this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        List<Movie> upcomingMovies = getDataMovieUpCominng();

        MovieAdapter upcomingMovieAdapater = new MovieAdapter(getContext(),upcomingMovies,this);
        UpcomingRV.setAdapter(upcomingMovieAdapater);
        UpcomingRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        List<Movie> nowPlayingMovies = getDataNowPlaying();

        MovieAdapter nowPlayingMovieAdapater = new MovieAdapter(getContext(),nowPlayingMovies,this);
        NowPlayingRV.setAdapter(nowPlayingMovieAdapater);
        NowPlayingRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        List<Movie> semuaFilm = getDataSemuaFilm();

        MovieAdapter semuaFilmAdapter = new MovieAdapter(getContext(),semuaFilm,this);
        SemuaFilmRV.setAdapter(semuaFilmAdapter);
        SemuaFilmRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        List<Movie> TVShows = getDataTVShow();

        MovieAdapter TVShowAdapter = new MovieAdapter(getContext(),TVShows,this);
        TVShowRV.setAdapter(TVShowAdapter);
        TVShowRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        return root;
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
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

    @Override
    public void onStarClick(Star star, ImageView starImageView) {

    }

    private ArrayList<Star> getDataStar(){
        ArrayList<Star> stars = new ArrayList<>();

        stars.add(new Star(R.drawable.anna_kendrick, "Anna Kendrick", "Poppy"));
        stars.add(new Star(R.drawable.justin_timberlake, "Justin Timberlake", "Branch"));
        stars.add(new Star(R.drawable.rachel_bloom, "Rachel Bloom", "Bloom"));
        stars.add(new Star(R.drawable.kelly_clarkson, "Kelly Clarkson", "Kelly"));
        stars.add(new Star(R.drawable.james_corden, "James Corden", "James"));

        return stars;
    }

    private List<Movie> getDataNowPlaying(){
        ArrayList<Movie> result = new ArrayList<>();
        ArrayList<Star> stars = getDataStar();

        result.add(new Movie("Tarung Sarung", R.drawable.tarung_sarung,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "130 Menit", "Drama, Religious", "Chand Parwez Servia, Fiaz Servia", "Archie Hekagery","Archie Hekagery", "Panji Zoni, Yayan Ruhiyan, Maizura, Cemal Faruk", "December 31, 2020","-" ,"Starvision", "https://www.youtube.com/watch?v=V48qhATHklc" ,stars));

        result.add(new Movie("Walking Dead Tomate", R.drawable.walking_dead_tomate,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Horror, Drama", "Nona Quiliem, Ekadi Katili", "Ekadi Katili","Beni Susanto", "Iqbal Perdana, Yulinar Arief, Aga Dirgantara", "April 16, 2020","-" ,"Cinekadi Pictures", "https://www.youtube.com/watch?v=6CNbITLDWos" ,stars));

        result.add(new Movie("My Spy", R.drawable.my_spy,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Action, Comedy, Family", "Dave Bautista, Chris Bender", "Peter Segal","Erich Hoeber, Jon Hoeber", "Dave Bautista, Kristen Schaal, Parisa Fitz-Henley", "January 9, 2020","6.2/10" ,"MWM Studios", "https://www.youtube.com/watch?v=imMQskUW_Ik" ,stars));

        result.add(new Movie("Jodohku yang Mana? (Molulo 2)", R.drawable.jodohku_yang_mana,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Drama, Comedy", "Partono Wiraputra, Andi Arsyil Rahman, Santi Muzhar", "Irham Acho Bahtiar","Ferdy. K, Andi Arsyil Rahman", "Andi Arsyil, Arlita Reggiana, Alexa Key", "March 19, 2020","-" ,"Moov Pictures", "https://www.youtube.com/watch?v=1zb64S1bF_U" ,stars));

        result.add(new Movie("Djoerig Salawe", R.drawable.djorieg_salawe,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "168 Menit", "Drama, Comedy, Horror", "dr Robby Hilman, Budi Yulianto, Cut Puti, M Rizky", "Sahrul Gibran","Fajar Umbara, Isman H", "Joe P Project, Fico Fahreza, Aming, Ben Kasyafani", "March 26, 2020","-" ,"MBK Pictures", "https://www.youtube.com/watch?v=D-Un3p637js" ,stars));

        return result;
    }

    private List<Movie> getDataMovieBestPopuler(){
        ArrayList<Movie> result = new ArrayList<>();
        ArrayList<Star> stars = getDataStar();

        result.add(new Movie("The Godfather", R.drawable.the_godfather,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "172 Menit", "Crime, Drama", "Albert S. Ruddy", "Francis Ford Coppola","Mario Puzo, Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan", "24 March 1972 (USA)","9.2/10" ,"Paramount Picture", "https://www.youtube.com/watch?v=sY1S34973zA" ,stars));

        result.add(new Movie("The Shawshank Redemption", R.drawable.the_shawshank_redemption,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "142 Menit", "Drama", "Niki Marvin", "Frank Darabont"," Stephen King, Frank Darabont", "Tim Robbins, Morgan Freeman, Bob Gunton", "14 October 1994 (USA)","9.3/10" ,"Castle Rock Entertaiment", "https://www.youtube.com/watch?v=6hB3S9bIaco" ,stars));

        result.add(new Movie("The Godfather", R.drawable.the_godfather,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "172 Menit", "Crime, Drama", "Albert S. Ruddy", "Francis Ford Coppola","Mario Puzo, Francis Ford Coppola", "Al Pacino, Robert De Niro, Robert Duvall", "18 December 1974 (USA)","9.0/10" ,"Paramount Picture", "https://www.youtube.com/watch?v=sY1S34973zA" ,stars));

        result.add(new Movie("The Dark Knight", R.drawable.the_dark_knight,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "153", "Action, Crime, Drama", "Emma Thomas", "Christopher Nolan","Jonathan Nolan, Christpoher Nolan", "Christian Bale, Heath Ledger, Aaron Eckhart", "18 July 2008 (USA)","9.0/10" ,"Warner Bross", "https://www.youtube.com/watch?v=EXeTwQWrcwY" ,stars));

        result.add(new Movie("12 Angry Man", R.drawable.angry_man_12,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "96 Menit", "Crime, Drama", "Henry Fonda", "Sidney Lumet","Reginald Rose", "Henry Fonda, Lee J. Cobb, Martin Balsam", "10 April 1957 (USA)","8.9/10" ,"Orion-Nova Productions\n Bross", "https://www.youtube.com/watch?v=_13J_9B5jEk" ,stars));

        return result;
    }

    private List<Movie> getDataMovieUpCominng(){
        ArrayList<Movie> result = new ArrayList<>();
        ArrayList<Star> stars = getDataStar();

        result.add(new Movie("Sputnik ", R.drawable.sputnik,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "113 Menit", "Horror, Sci-Fi", "Frederick A. Stokes ", "Egor Abramenko","Andrei Zolotarev", "Oksana Akinshina, Fedor Bondarchuk, Pyotr Fyodorov", "15 April 2020 (USA)","-" ,"Energia Films", "https://www.youtube.com/watch?v=xhLORcya9GU" ,stars));

        result.add(new Movie("Antebellum ", R.drawable.antebellum,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "104 Menit", "Horror, Thriller ", "Sean McKittrick ", "Gerard Bush, Christopher Renz","Gerard Bush, Christopher Renz", "Janelle Monáe, Eric Lange, Jena Malone", "21 August 2020 (USA)","-" ,"Lionsgate Films", "https://www.youtube.com/watch?v=mXcZ7WDsVwk" ,stars));

        result.add(new Movie("Let Him Go ", R.drawable.let_him_go,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Crime, Drama, Thriller ", "Mitchell Kaplan ", "Thomas Bezucha","Thomas Bezucha", "Kevin Costner, Diane Lane, Lesley Manville", "21 August 2020 (USA)","-" ,"Mazur Kaplan Company", "https://www.youtube.com/watch?v=mXcZ7WDsVwk" ,stars));

        result.add(new Movie("Tesla  ", R.drawable.tesla,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "86 Menit", "Biography, Drama", "Uri Singer ", "Michael Almereyda","Michael Almereyda", "Eve Hewson, Ethan Hawke, Hannah Gross |", "27 January 2020 (USA)","6.9/10" ,"IFC Films", "https://www.youtube.com/watch?v=C-7o8i4geIw" ,stars));

        result.add(new Movie("The New Mutants  ", R.drawable.the_new_mutans,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Action, Horror, Sci-Fi", "Karen Rosenfelt ", "Josh Boone","Josh Boone", "Maisie Williams, Anya Taylor-Joy, Charlie Heaton", "28 August 2020 (USA)","6.9/10" ,"20th Century Studios", "https://www.youtube.com/watch?v=C-7o8i4geIw" ,stars));

        return result;
    }

    public List<Movie> getDataSemuaFilm(){
        ArrayList<Movie> result = new ArrayList<>();
        ArrayList<Star> stars = getDataStar();

        result.add(new Movie("Avengers: Endgame", R.drawable.avengers_endgame,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "181 Menit", "Action, Adventure, Drama ", "Gina Shay", "Anthony Russo, Joe Russo","Christopher Markus", "Robert Downey Jr., Chris Evans, Mark Ruffalo ", "26 April 2019 (USA)","8.4/10" ,"Marvel Studio", "https://www.youtube.com/watch?v=yP86-TR6IME" ,stars));

        result.add(new Movie("1917 ", R.drawable.sembilan_belas,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "119 Menit", "Drama, War", "Sam Mendes", "Sam Mendes","Sam Mendes, Krysty Wilson-Cairns", "Dean-Charles Chapman, George MacKay, Daniel Mays", "10 January 2020 (USA)","8.3/10" ,"Neil Soans", "https://www.youtube.com/watch?v=yP86-TR6IME" ,stars));

        result.add(new Movie("Public Enemies ", R.drawable.public_enemies,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "140 Menit", "Biography, Crime, Drama", "Sam Mendes", "Michael Mann, Kevin Misher","Ronan Bennett ", "Christian Bale, Johnny Depp, Christian Stolte", "1 July 2009 (USA)","7.0/10" ,"Relative Media", "https://www.youtube.com/watch?v=Q8xOgO7_eT8" ,stars));

        return result;
    }

    public  List<Movie> getDataTVShow(){
        ArrayList<Movie> result = new ArrayList<>();

        result.add(new Movie("Planet Earth ", R.drawable.planet_earth));
        result.add(new Movie("Breaking Bad", R.drawable.breaking_bad));
        result.add(new Movie("Chernobyl", R.drawable.chernobyl));

        return result;
    }
}

