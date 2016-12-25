package com.example.gavin.movies;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by Gavin on 12/23/2016.
 */

public class Movie implements Serializable {

    public String mMoviePosterUrl;
    public String mTitle;
    public double mPopularity;
    public double mUserRating;
    public String mPlotSynopsis;
    public String mReleaseDate;
    public String mBackdropImageUrl;

    public Movie(String moviePosterUrl, String title, double popularity, double userRating,
                 String plotSynopsis, String releaseDate, String backdropImageUrl){
        mMoviePosterUrl = moviePosterUrl;
        mTitle = title;
        mPopularity = popularity;
        mUserRating = userRating;
        mPlotSynopsis = plotSynopsis;
        mReleaseDate = releaseDate;
        mBackdropImageUrl = backdropImageUrl;
    }

}

