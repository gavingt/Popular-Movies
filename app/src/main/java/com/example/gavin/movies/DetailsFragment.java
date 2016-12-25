package com.example.gavin.movies;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    public String mMoviePosterUrl;
    public String mTitle;
    public double mPopularity;
    public double mUserRating;
    public String mPlotSynopsis;
    public String mReleaseDate;
    public String mBackdropImageUrl;

    private final String URL_PREFIX = "http://image.tmdb.org/t/p/w780";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        Movie currentMovie = (Movie) getActivity().getIntent().getSerializableExtra("movieObject");

        ImageView backgroundImage = (ImageView) rootView.findViewById(R.id.background_image);
        //backgroundImage.setColorFilter(Color.argb(150, 0, 0, 50));
        Picasso.with(getContext()).load(URL_PREFIX + currentMovie.mBackdropImageUrl).into(backgroundImage);






        return rootView;
    }

}
