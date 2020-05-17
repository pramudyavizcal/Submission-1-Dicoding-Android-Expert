package com.pramu.moviesubmission1;

import android.os.Parcel;
import android.os.Parcelable;

public class MyMovies implements Parcelable {
    private String judul;
    private String overview;
    private String skorPengunjung;
    private String statusFilm;
    private String bahasaFilm;
    private String durasiFilm;
    private String genre;
    private String tahunRilis;

    public String gettahunRilis() {
        return tahunRilis;
    }

    public void settahunRilis(String tahunRilis) {
        this.tahunRilis = tahunRilis;
    }

    public String getskorPengunjung() {
        return skorPengunjung;
    }

    public void setskorPengunjung(String skorPengunjung) {
        this.skorPengunjung = skorPengunjung;
    }

    public String getstatusFilm() {
        return statusFilm;
    }

    public void setstatusFilm(String statusFilm) {
        this.statusFilm = statusFilm;
    }

    public String getbahasaFilm() {
        return bahasaFilm;
    }

    public void setbahasaFilm(String bahasaFilm) {
        this.bahasaFilm = bahasaFilm;
    }

    public String getdurasiFilm() {
        return durasiFilm;
    }

    public void setdurasiFilm(String durasiFilm) {
        this.durasiFilm = durasiFilm;
    }

    public String getgenre() {
        return genre;
    }

    public void setgenre(String genre) {
        this.genre = genre;
    }

    public int getposterFilm() {
        return posterFilm;
    }

    public void setposterFilm(int posterFilm) {
        this.posterFilm = posterFilm;
    }

    private int posterFilm;

    public String getjudul() {
        return judul;
    }

    public void setjudul(String judul) {
        this.judul = judul;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public MyMovies() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.overview);
        dest.writeString(this.skorPengunjung);
        dest.writeString(this.statusFilm);
        dest.writeString(this.bahasaFilm);
        dest.writeString(this.durasiFilm);
        dest.writeString(this.genre);
        dest.writeString(this.tahunRilis);
        dest.writeInt(this.posterFilm);
    }

    protected MyMovies(Parcel in) {
        this.judul = in.readString();
        this.overview = in.readString();
        this.skorPengunjung = in.readString();
        this.statusFilm = in.readString();
        this.bahasaFilm = in.readString();
        this.durasiFilm = in.readString();
        this.genre = in.readString();
        this.tahunRilis = in.readString();
        this.posterFilm = in.readInt();
    }

    public static final Parcelable.Creator<MyMovies> CREATOR = new Parcelable.Creator<MyMovies>() {
        @Override
        public MyMovies createFromParcel(Parcel source) {
            return new MyMovies(source);
        }

        @Override
        public MyMovies[] newArray(int size) {
            return new MyMovies[size];
        }
    };
}
