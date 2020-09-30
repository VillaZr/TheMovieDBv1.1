package com.example.themoviedb.utils;

import android.util.Log;

import com.example.themoviedb.model.PopularMovies;
import com.example.themoviedb.model.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUtilsPopularMovies {

    private static final String TAG = "JsonUtilsPopMovies * ";

    private static final String PAGE = "page";
    private static final String TOTAL_RESULTS = "total_results";
    private static final String TOTAL_PAGES = "total_pages";
    private static final String RESULT_LIST = "results";

    private static Integer page = 0;
    private static Integer total_results = 0;
    private static Integer total_pages = 0;
    private static ArrayList<Result> result_list = new ArrayList<Result>();


    public static PopularMovies parsePopularMoviesJson(String json) {

        try {

            JSONObject popularMoviesObject = new JSONObject(json);

            page = popularMoviesObject.getInt(PAGE);
            total_results = popularMoviesObject.getInt(TOTAL_RESULTS);
            total_pages = popularMoviesObject.getInt(TOTAL_PAGES);

            result_list.clear();
            JSONArray aResult_List = popularMoviesObject.getJSONArray(RESULT_LIST);

            for (int i = 0; i < aResult_List.length(); i++){

                Result mResult = new Result();

                mResult.setPopularity(aResult_List.getJSONObject(i).getDouble("popularity"));
                mResult.setVote_count(aResult_List.getJSONObject(i).getInt("vote_count"));
                mResult.setVideo(aResult_List.getJSONObject(i).getBoolean("video"));
                mResult.setPoster_path(aResult_List.getJSONObject(i).getString("poster_path"));
                mResult.setId(aResult_List.getJSONObject(i).getInt("id"));
                mResult.setAdult(aResult_List.getJSONObject(i).getBoolean("adult"));
                mResult.setBackdrop_path(aResult_List.getJSONObject(i).getString("backdrop_path"));
                mResult.setOriginal_language(aResult_List.getJSONObject(i).getString("original_language"));
                mResult.setOriginal_title(aResult_List.getJSONObject(i).getString("original_title"));

                List<Integer> aGenre_Ids = new ArrayList<>();
                JSONArray a = aResult_List.getJSONObject(i).getJSONArray("genre_ids");
                for (int k = 0; k < a.length(); k++) {
                    aGenre_Ids.add(a.getInt(k));
                }
                mResult.setGenre_ids(aGenre_Ids.toArray(new Integer[aGenre_Ids.size()]));
                Integer [] myGenres = new Integer[mResult.getGenre_ids().length];
                for (int m = 0; m < mResult.getGenre_ids().length; m++) {
                    myGenres[m] = aGenre_Ids.get(m);
                    Log.i(TAG, "*** POPULAR MOVIES PARSING m Genres:  m " + String.valueOf(i) + "   m " + String.valueOf(m) + "   " + String.valueOf(myGenres[m]) + "/n");
                }

                mResult.setTitle(aResult_List.getJSONObject(i).getString("title"));

                mResult.setVote_average(aResult_List.getJSONObject(i).getDouble("vote_average"));
                mResult.setOverview(aResult_List.getJSONObject(i).getString("overview"));
                mResult.setRelease_date(aResult_List.getJSONObject(i).getString("release_date"));

                result_list.add(mResult);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new PopularMovies(page, total_results, total_pages, result_list);

    }

}
