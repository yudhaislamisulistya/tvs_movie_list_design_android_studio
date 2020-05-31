package com.example.asistensi1dan2tahap1.ui.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.adapters.AllMovieAdapter;
import com.example.asistensi1dan2tahap1.adapters.NowPlayingMovieAdapter;
import com.example.asistensi1dan2tahap1.models.Movie;
import com.example.asistensi1dan2tahap1.models.Star;

import java.io.Serializable;
import java.util.ArrayList;

public class AllMovieActivity extends AppCompatActivity {

    private ListView LSAllMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movie);
        LSAllMovie = (ListView) findViewById(R.id.LS_AllMovie);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#303960")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Semua Film</font>"));
        getSupportActionBar().setElevation(0);
        initDataAllMovie();
    }

    private void initDataAllMovie(){


        ArrayList allMovieList = getDataAllMovie();

        AllMovieAdapter nowPlayingMovieAdapter = new AllMovieAdapter(this, allMovieList);
        LSAllMovie.setAdapter(nowPlayingMovieAdapter);
        LSAllMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Movie movie = (Movie) LSAllMovie.getItemAtPosition(position);

                Intent intent = new Intent(AllMovieActivity.this, MovieDetailActivity.class);
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

    }

    private ArrayList getDataAllMovie(){
        ArrayList<Movie> result = new ArrayList<>();
        ArrayList<Star> stars = new ArrayList<>();

        stars.add(new Star(R.drawable.anna_kendrick, "Anna Kendrick", "Poppy"));
        stars.add(new Star(R.drawable.justin_timberlake, "Justin Timberlake", "Branch"));
        stars.add(new Star(R.drawable.rachel_bloom, "Rachel Bloom", "Bloom"));
        stars.add(new Star(R.drawable.kelly_clarkson, "Kelly Clarkson", "Kelly"));
        stars.add(new Star(R.drawable.james_corden, "James Corden", "James"));

        result.add(new Movie("Avengers: Endgame", R.drawable.avengers_endgame,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "181 Menit", "Action, Adventure, Drama ", "Gina Shay", "Anthony Russo, Joe Russo","Christopher Markus", "Robert Downey Jr., Chris Evans, Mark Ruffalo ", "26 April 2019 (USA)","8.4/10" ,"Marvel Studio", "https://www.youtube.com/watch?v=yP86-TR6IME" ,stars));

        result.add(new Movie("1917 ", R.drawable.sembilan_belas,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "119 Menit", "Drama, War", "Sam Mendes", "Sam Mendes","Sam Mendes, Krysty Wilson-Cairns", "Dean-Charles Chapman, George MacKay, Daniel Mays", "10 January 2020 (USA)","8.3/10" ,"Neil Soans", "https://www.youtube.com/watch?v=yP86-TR6IME" ,stars));

        result.add(new Movie("Public Enemies ", R.drawable.public_enemies,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "140 Menit", "Biography, Crime, Drama", "Sam Mendes", "Michael Mann, Kevin Misher","Ronan Bennett ", "Christian Bale, Johnny Depp, Christian Stolte", "1 July 2009 (USA)","7.0/10" ,"Relative Media", "https://www.youtube.com/watch?v=Q8xOgO7_eT8" ,stars));

        result.add(new Movie("Maleficent: Mistress of Evil", R.drawable.maleficent_mistress_of_evil,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "119", "Adventure, Family, Fantasy", "Joe Roth, Angelina Jolie", "Joachim Rønning","Linda Woolverton, Noah Harpster", "Angelina Jolie, Elle Fanning, Harris Dickinson", "18 October 2019 (USA)","7.0/10" ,"Walt Disney Pictures", "https://www.youtube.com/watch?v=n0OFH4xpPr4" ,stars));

        result.add(new Movie("Midsommar ", R.drawable.midsommar,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "148 Menit", "Drama, Horror, Mystery", "Patrik Andersson", "Ari Aster","Ari Aster", "Florence Pugh, Jack Reynor, Vilhelm Blomgren", "3 July 2019 (USA)","7.0/10" ,"Square Peg", "https://www.youtube.com/watch?v=1Vnghdsjmd0" ,stars));

        result.add(new Movie("Justice League Dark: Apokolips War ", R.drawable.justice_league_dark_apokalis_war,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "90 Menit", "Animation, Action, Sci-Fi", "Patrik Andersson", "Matt Peters","Ernie Altbacker", "Roger Cross, Rosario Dawson, Christopher Gorham", "5 May 2020","7.9/10" ,"DC Animation", "https://www.youtube.com/watch?v=tnCkn5xD2jg" ,stars));

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
