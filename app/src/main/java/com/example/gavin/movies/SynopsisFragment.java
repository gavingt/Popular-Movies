package com.example.gavin.movies;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.ColorFilterTransformation;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import static com.squareup.picasso.Picasso.with;


/**
 * A simple {@link Fragment} subclass.
 */
public class SynopsisFragment extends Fragment {

    private final String LOG_TAG = SynopsisFragment.class.getSimpleName();
    private final String BACKGROUND_URL_PREFIX = "http://image.tmdb.org/t/p/w500";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_synopsis, container, false);
        Movie currentMovie = (Movie) getActivity().getIntent().getSerializableExtra("movieObject");

        ImageView backgroundImage = (ImageView) rootView.findViewById(R.id.background_image);
        ColorFilterTransformation transformation = new ColorFilterTransformation(0x96000032);
        with(getContext()).load(BACKGROUND_URL_PREFIX + currentMovie.mBackdropImageUrl).transform(transformation).into(backgroundImage);


        final TextView plotSynopsis = (TextView) rootView.findViewById(R.id.movie_synopsis);
        plotSynopsis.setText(currentMovie.mPlotSynopsis);

        return rootView;

    }


}
