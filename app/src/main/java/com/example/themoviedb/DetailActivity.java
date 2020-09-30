package com.example.themoviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.themoviedb.model.Movie;
import com.example.themoviedb.model.Result;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    public static final String POSTER_PATH = "poster_path";
    public static final String TITLE = "title";
    public static final String PLOT_SYNOPSIS = "plot_synopsis";
    public static final String USER_RATING = "user_rating";
    public static final String RELEASE_DATE = "release_date";

    private static final Integer DEFAULT_PATH = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView poster_Path = findViewById(R.id.poster_path);
        TextView title = findViewById(R.id.title);
        TextView plot_synopsis = findViewById(R.id.plot_synopsis);
        TextView user_rating = findViewById(R.id.user_rating);
        TextView release_date = findViewById(R.id.release_date);

        Result result = (Result) getIntent().getSerializableExtra("RESULT");

        Picasso.with(this)
                .load("https://image.tmdb.org/t/p/w500//" + result.getPoster_path())
                .into(poster_Path);

        title.setText(result.getTitle());
        plot_synopsis.setText(result.getOverview());
        user_rating.setText(String.valueOf(result.getVote_average()));
        release_date.setText(result.getRelease_date());

        //Log.i(TAG, "*DetailActivity -> *" + result.getTitle() + "*" + "\n");

    }

}