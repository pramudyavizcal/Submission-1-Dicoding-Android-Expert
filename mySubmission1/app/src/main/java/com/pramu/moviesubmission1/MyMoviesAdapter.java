package com.pramu.moviesubmission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyMoviesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MyMovies> movies;


    public void setMovies(ArrayList<MyMovies> movies) {
        this.movies = movies;
    }

    public MyMoviesAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();

    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        MyMovies movie = (MyMovies) getItem(i);
        viewHolder.bind(movie);
        return view;

    }

    private class ViewHolder {

        private TextView txtjudul, txtoverview, txtdurasiFilm, txtwaktuTayang, txtskorPengunjung;
        private ImageView imgPosterFilm;

        ViewHolder(View view) {
            txtjudul = view.findViewById(R.id.txt_judul);
            txtoverview = view.findViewById(R.id.overview);
            imgPosterFilm = view.findViewById(R.id.posterFilm);
            txtdurasiFilm= view.findViewById(R.id.durasiFilm);
            txtwaktuTayang = view.findViewById(R.id.tanggalRilis);
            txtskorPengunjung = view.findViewById(R.id.skorPengunjung);

        }

        void bind(MyMovies movie) {
            txtjudul.setText(movie.getjudul());
            txtoverview.setText(movie.getOverview());
            imgPosterFilm.setImageResource(movie.getposterFilm());
            txtdurasiFilm.setText(movie.getdurasiFilm());
            txtwaktuTayang.setText(movie.gettahunRilis());
            txtskorPengunjung.setText(movie.getskorPengunjung());
        }
    }
}
