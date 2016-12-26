package com.example.gavin.movies;


import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

import jp.wasabeef.picasso.transformations.ColorFilterTransformation;

import static android.os.Build.VERSION_CODES.M;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private final String LOG_TAG = DetailsFragment.class.getSimpleName();

    private final String BACKGROUND_URL_PREFIX = "http://image.tmdb.org/t/p/w780";
    private final String POSTER_URL_PREFIX = "http://image.tmdb.org/t/p/w185";


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.details_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        Movie currentMovie = (Movie) getActivity().getIntent().getSerializableExtra("movieObject");

        ImageView backgroundImage = (ImageView) rootView.findViewById(R.id.background_image);
        ColorFilterTransformation transformation = new ColorFilterTransformation(0x96000032);
        Picasso.with(getContext()).load(BACKGROUND_URL_PREFIX + currentMovie.mBackdropImageUrl).transform(transformation).into(backgroundImage);

        ImageView moviePoster = (ImageView) rootView.findViewById(R.id.movie_poster);
        Picasso.with(getContext()).load(POSTER_URL_PREFIX + currentMovie.mMoviePosterUrl).into(moviePoster);

        getActivity().setTitle(currentMovie.mTitle);

        RatingBar ratingBar = (RatingBar) rootView.findViewById(R.id.movie_rating);
        ratingBar.setRating((float) (currentMovie.mUserRating/2));

        final TextView plotSynopsis = (TextView) rootView.findViewById(R.id.movie_synopsis);
        plotSynopsis.setText(currentMovie.mPlotSynopsis);

        plotSynopsis.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewTreeObserver obs = plotSynopsis.getViewTreeObserver();
                obs.removeOnGlobalLayoutListener(this);
                int height = plotSynopsis.getHeight();
                int scrollY = plotSynopsis.getScrollY();
                Layout layout = plotSynopsis.getLayout();
                int firstVisibleLineNumber = layout.getLineForVertical(scrollY);
                int lastVisibleLineNumber = layout.getLineForVertical(height + scrollY);

                //check is latest line fully visible
                if (plotSynopsis.getHeight() < layout.getLineBottom(lastVisibleLineNumber)) {
                    Toast.makeText(getActivity(), "text cut off", Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView releaseDate = (TextView) rootView.findViewById(R.id.movie_release_date);
        releaseDate.setText("Release: " + formatDate(currentMovie));

        return rootView;
    }



    private String formatDate(Movie currentMovie) {
        String unformattedDate = currentMovie.mReleaseDate;
        String[] twoPieces = unformattedDate.split("-");
        return twoPieces[1] + "/" + twoPieces[2] + "/" + twoPieces[0];
    }

}
