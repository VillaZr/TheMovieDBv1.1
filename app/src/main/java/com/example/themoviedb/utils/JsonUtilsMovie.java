package com.example.themoviedb.utils;

import com.example.themoviedb.model.Genre;
import com.example.themoviedb.model.Movie;
import com.example.themoviedb.model.ProductionCompany;
import com.example.themoviedb.model.ProductionCountry;
import com.example.themoviedb.model.SpokenLanguage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;


public class JsonUtilsMovie {

    private static final String ADULT = "adult";
    private static final String BACKDROP_PATH = "backdrop_path";
    private static final String BELONGS_TO_COLLECTION = "belongs_to_collection";
    private static final String BUDGET = "budget";
    private static final String GENRES = "genres";
    private static final String HOMEPAGE = "homepage";
    private static final String ID = "id";
    private static final String IMDB_ID = "imdb_id";
    private static final String ORIGINAL_LANGUAGE = "original_language";
    private static final String ORIGINAL_TITLE = "original_title";
    private static final String OVERVIEW = "overview";
    private static final String POPULARITY = "popularity";
    private static final String POSTER_PATH = "poster_path";
    private static final String PRODUCTION_COMPANIES = "production_companies";
    private static final String PRODUCTION_COUNTRIES = "production_countries";
    private static final String RELEASE_DATE = "release_date";
    private static final String REVENUE = "revenue";
    private static final String RUNTIME = "runtime";
    private static final String SPOKEN_LANGUAGES = "spoken_languages";
    private static final String STATUS = "status";
    private static final String TAGLINE = "tagline";
    private static final String TITLE = "title";
    private static final String VIDEO = "video";
    private static final String VOTE_AVERAGE = "vote_average";
    private static final String VOTE_COUNT = "vote_count";

    private static String adult = "";
    private static String backdrop_path = "";
    private static String belongs_to_collection = null;
    private static Integer budget = 0;
    private static ArrayList<Genre> genres = new ArrayList<Genre>();
    private static String homepage = "";
    private static Integer id = 0;
    private static String imdb_id = "";
    private static String original_language = "";
    private static String original_title = "";
    private static String overview = "";
    private static Double popularity = 0.0;
    private static String poster_path = "";
    private static ArrayList<ProductionCompany> production_companies = new ArrayList<ProductionCompany>();
    private static ArrayList<ProductionCountry> production_countries = new ArrayList<ProductionCountry>();
    private static String release_date = "";
    private static Integer revenue = 0;
    private static Integer runtime = 0;
    private static ArrayList<SpokenLanguage> spoken_languages = new ArrayList<SpokenLanguage>();
    private static String status = "";
    private static String tagline = "";
    private static String title = "";
    private static Boolean video = false;
    private static Double vote_average = 0.0;
    private static Integer vote_count = 0;


    public static Movie parseMovieJson(String json) {

        try {

            JSONObject movieObject = new JSONObject(json);

            adult = movieObject.getString(ADULT);
            backdrop_path = movieObject.getString(BACKDROP_PATH);
            belongs_to_collection = movieObject.getString(BELONGS_TO_COLLECTION);
            budget = movieObject.getInt(BUDGET);

            Genre mGenre = new Genre();
            genres.clear();
            JSONArray aGenres = movieObject.getJSONArray(GENRES);
            for (int i = 0; i < aGenres.length(); i++){
                mGenre.setId(aGenres.getJSONObject(i).getInt("id"));
                mGenre.setName(aGenres.getJSONObject(i).getString("name"));
                genres.add(mGenre);
                System.out.println("*** Movie ID: " + String.valueOf(mGenre.getId()));
                System.out.println("*** Movie NAME: " + mGenre.getName());
            }
            for (int i = 0; i < aGenres.length(); i++) {
                System.out.println("*** Genre Object ID: " + genres.get(i).getId());
                System.out.println("*** Genre Object NAME: " + genres.get(i).getName());
            }


            homepage = movieObject.getString(HOMEPAGE);
            System.out.println("*** Movie HOMEPAGE: " + homepage);



/*            id = movieObject.getString(ID);
            imdb_id = movieObject.getString(IMDB_ID);
            original_language = movieObject.getString(ORIGINAL_LANGUAGE);
            original_title = movieObject.getString(ORIGINAL_TITLE);
            overview = movieObject.getString(OVERVIEW);
            popularity = movieObject.getString(POPULARITY);
            poster_path = movieObject.getString(POSTER_PATH);
            production_companies = movieObject.getString(PRODUCTION_COMPANIES);
            production_countries = movieObject.getString(PRODUCTION_COUNTRIES);
            release_date = movieObject.getString(RELEASE_DATE);
            revenue = movieObject.getString(REVENUE);
            runtime = movieObject.getString(RUNTIME);
            spoken_languages = movieObject.getString(SPOKEN_LANGUAGES);
            status = movieObject.getString(STATUS);
            tagline = movieObject.getString(TAGLINE);
            title = movieObject.getString(TITLE);
            video = movieObject.getString(VIDEO);
            vote_average = movieObject.getString(VOTE_AVERAGE);
            vote_count = movieObject.getString(VOTE_COUNT);*/




        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return null;
        //return new Movie(backdrop_path, Collections.singletonList(genres), homepage);
        return new Movie(backdrop_path, genres, homepage);
    }

}
