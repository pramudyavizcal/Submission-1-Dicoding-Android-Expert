package com.pramu.moviesubmission1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private String[] judul, overview, genre, durasiFilm, bahasaFilm,
                    statusFilm, skorPengunjung, tahunFilm;
    private TypedArray posterFilm;
    private MyMoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MyMoviesAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);


        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyMovies movie = new MyMovies();

                movie.setposterFilm(posterFilm.getResourceId(i, -1));
                movie.setjudul(judul[i]);
                movie.setOverview(overview[i]);
                movie.setgenre(genre[i]);
                movie.setstatusFilm(statusFilm[i]);
                movie.setdurasiFilm(durasiFilm[i]);
                movie.setskorPengunjung(skorPengunjung[i]);
                movie.setbahasaFilm(bahasaFilm[i]);
                movie.settahunRilis(tahunFilm[i]);


                Intent moveWithObject = new Intent(MainActivity.this, MyDetailMovies.class);
                moveWithObject.putExtra(MyDetailMovies.EXTRA_MOVIE, movie);
                startActivity(moveWithObject);
            }
        });
    }
//    private MyMovies createNewMovie(){
//        MyMovies movies = new MyMovies();
//        movies.setjudul("");
//        movies.setOverview("");
//        movies.setskorPengunjung("");
//        movies.settahunRilis("");
//        movies.setdurasiFilm("");
//        movies.setbahasaFilm("");
//        movies.setgenre("");
//        movies.setstatusFilm("");
//        movies.setposterFilm(1);
//        return movies;
//    }

    @Override
    public void onClick(View v) {
        //
    }

    private void addItem() {

        ArrayList<MyMovies> movies = new ArrayList<>();

        for (int i = 0; i < judul.length; i++) {
            MyMovies movie = new MyMovies();
            movie.setposterFilm(posterFilm.getResourceId(i, -1));
            movie.setjudul(judul[i]);
            movie.setOverview(overview[i]);
            movie.setgenre(genre[i]);
            movie.setstatusFilm(statusFilm[i]);
            movie.setdurasiFilm(durasiFilm[i]);
            movie.setskorPengunjung(skorPengunjung[i]);
            movie.setbahasaFilm(bahasaFilm[i]);
            movie.settahunRilis(tahunFilm[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        judul = getResources().getStringArray(R.array.data_judul);
        overview = getResources().getStringArray(R.array.data_deskripsi);
        posterFilm = getResources().obtainTypedArray(R.array.data_posterfilm);
        genre = getResources().getStringArray(R.array.data_genres);
        statusFilm = getResources().getStringArray(R.array.data_status);
        skorPengunjung = getResources().getStringArray(R.array.data_skorpengunjung);
        bahasaFilm = getResources().getStringArray(R.array.data_bahasa);
        durasiFilm = getResources().getStringArray(R.array.data_durasi);
        tahunFilm = getResources().getStringArray(R.array.data_tahun);
    }
        public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure Want to Exit?")
                .setCancelable(true)//tidak bisa tekan tombol back
                //jika pilih yess
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
                        finish();
                    }
                })
                //jika pilih no
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

}
