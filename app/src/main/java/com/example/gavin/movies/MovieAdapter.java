package com.example.gavin.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;
import static android.support.v7.widget.AppCompatDrawableManager.get;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;

/**
 * Created by Gavin on 12/23/2016.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    ArrayList<Movie> mMovies;
    private final String LOG_TAG = MovieAdapter.class.getSimpleName();


    private final String URL_PREFIX = "http://image.tmdb.org/t/p/w185";

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        super(context, 0, movies);

        mMovies = movies;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item, parent, false);
        }

        Movie currentMovie = mMovies.get(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.movie_image);
        Picasso.with(getContext()).load(URL_PREFIX + currentMovie.mMoviePosterUrl).into(imageView);

        return listItemView;

    }



}
