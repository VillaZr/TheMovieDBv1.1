package com.example.themoviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.themoviedb.model.Movie;
import com.example.themoviedb.model.PopularMovies;
import com.example.themoviedb.model.Result;
import com.example.themoviedb.utils.Constants;
import com.example.themoviedb.utils.JsonUtilsMovie;
import com.example.themoviedb.utils.JsonUtilsPopularMovies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface{

    private static final String TAG = "*MainActivity: ";

    public static String menuMoviesSelected = Constants.urlPopularMovies;  // Default: Popular Movies

    public static String mJsonString;
    public static PopularMovies mpv;

    public static String []arr = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    public static String []aTitle = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    private Object Movie;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.source_menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.Popular_Movies:
                menuMoviesSelected = Constants.urlPopularMovies;
                getPopularMovies();

                recyclerView.removeAllViews();
                recyclerViewAdapter=new RecyclerViewAdapter(arr, aTitle, this);
                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerView.setHasFixedSize(true);
                return true;
            case R.id.TopRated_Movies:
                menuMoviesSelected = Constants.urlTopRatedMovies;
                getPopularMovies();

                recyclerView.removeAllViews();
                recyclerViewAdapter=new RecyclerViewAdapter(arr, aTitle, this);
                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerView.setHasFixedSize(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        getPopularMovies();

        /*if (Thread.currentThread().isAlive()){
            for (int i = 0; i < arr.length; i++) {
                Log.i(TAG, "*CHECK -> arr[i] " + "   position = " + String.valueOf(i) + "   *" + arr[i] + "*\n");
            }
        }*/

        recyclerView.removeAllViews();
        recyclerViewAdapter=new RecyclerViewAdapter(arr, aTitle, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

    }


    @Override
    public void onItemClick(int position) throws IOException {

        //Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, arr[position], Toast.LENGTH_SHORT).show();

        //getMovieInfo();
        //getPopularMovies();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("RESULT", (Serializable) mpv.getResult_list().get(position));

        startActivity(intent);

    }


    @Override
    public void onLongItemClick(int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Long Item Click ", Toast.LENGTH_SHORT).show();
    }


    private void getMovieInfo() {

        new Thread(new Runnable(){
            @Override
            public void run() {
                // Do network action in this function
                URL url = null;
                try  {
                    url = new URL("https://api.themoviedb.org/3/movie/550?api_key=262a1dd31aadac22f14df2ecd7846dcd");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    //con.setDoOutput(true);
                    con.setRequestMethod("GET");
                    con.setRequestProperty("Content-Type", "application/json");


                    BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

                    String output;
                    System.out.println("Output from Server .... \n");
                    while ((output = br.readLine()) != null) {
                        System.out.println(output);
                        mJsonString = mJsonString + output;
                    }

                } catch (Exception e) {
                    System.out.println("There is an error .... \n");
                    e.printStackTrace();
                }
            }
        }).start();

        Movie movie = JsonUtilsMovie.parseMovieJson(mJsonString);

        for (int i = 0; i < movie.getGenres().size(); i++) {
            System.out.println("*** MAIN Genre SIZE: " + String.valueOf(movie.getGenres().size()));
            System.out.println("*** MAIN Genre Object ID: " + movie.getGenres().get(i).getId());
            System.out.println("*** MAIN Genre Object NAME: " + movie.getGenres().get(i).getName());
        }

    }


    private void getPopularMovies() {

        new Thread(new Runnable(){
            @Override
            public void run() {
                // Do network action in this function
                URL url = null;
                try  {
                    //url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=262a1dd31aadac22f14df2ecd7846dcd&language=en-US&page=1"); // Popular Movies
                    //url = new URL("https://api.themoviedb.org/3/movie/top_rated?api_key=262a1dd31aadac22f14df2ecd7846dcd&language=en-US&page=1"); // Top Rated Movies
                    url = new URL(menuMoviesSelected);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    //con.setDoOutput(true);
                    con.setRequestMethod("GET");
                    con.setRequestProperty("Content-Type", "application/json");

                    BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

                    String output;
                    mJsonString = "";
                    while ((output = br.readLine()) != null) {
                        mJsonString = mJsonString + output;
                    }

                } catch (Exception e) {
                    Log.i(TAG, "*ERROR -> error MainActivity " + "\n");
                    e.printStackTrace();
                }

                mpv = JsonUtilsPopularMovies.parsePopularMoviesJson(mJsonString);

                for (int i = 0; i < mpv.getResult_list().size(); i++) {
                    arr[i] = "https://image.tmdb.org/t/p/w500//" + mpv.getResult_list().get(i).getPoster_path();
                    aTitle[i] = mpv.getResult_list().get(i).getTitle();
                    //Log.i(TAG, "*CHECK -> arr[i] " + "   position = " + String.valueOf(i) + "   *" + arr[i] + "*\n");
                }

            }
        }).start();

    }

}