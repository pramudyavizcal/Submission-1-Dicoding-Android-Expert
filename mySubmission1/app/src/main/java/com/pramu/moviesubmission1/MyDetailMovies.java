package com.pramu.moviesubmission1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDetailMovies extends AppCompatActivity {


    public static final String EXTRA_MOVIE = "test_extra_movie";
    String judul, statusFilm, skorPengunjung, genre, durasiFilm, bahasaFilm, overview;
    int path;
    TextView tViewjudul, tViewstatusFilm, tViewskorPengunjung, tViewgenre,
            textViewdurasiFilm, tViewbahasaFilm, tViewOverview;

    ImageView imagePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        tViewjudul = findViewById(R.id.txt_judul);
        tViewstatusFilm = findViewById(R.id.statusFilm);
        tViewskorPengunjung = findViewById(R.id.skorPengunjung);
        tViewgenre = findViewById(R.id.genre);
        textViewdurasiFilm = findViewById(R.id.durasiFilm);
        tViewbahasaFilm = findViewById(R.id.bahasaFilm);
        tViewOverview = findViewById(R.id.overview);
        imagePoster = findViewById(R.id.posterFilm);

        MyMovies movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        judul = movie.getjudul();
        tViewjudul.setText(judul);

        statusFilm = movie.getstatusFilm();
        tViewstatusFilm.setText(statusFilm);

        skorPengunjung = movie.getskorPengunjung();
        tViewskorPengunjung.setText(skorPengunjung);

        genre = movie.getgenre();
        tViewgenre.setText(genre);

        durasiFilm = movie.getdurasiFilm();
        textViewdurasiFilm.setText(durasiFilm);

        bahasaFilm = movie.getbahasaFilm();
        tViewbahasaFilm.setText(bahasaFilm);

        overview = movie.getOverview();
        tViewOverview.setText(overview);

        path = movie.getposterFilm();
        imagePoster.setImageResource(path);

    }
}
