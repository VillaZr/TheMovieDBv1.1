package com.example.themoviedb.model;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

public class Result implements Serializable {

    private Double popularity;
    private Integer vote_count;
    private Boolean video;
    private String poster_path;
    private Integer id;
    private Boolean adult;
    private String backdrop_path;
    private String original_language;
    private String original_title;
    private Integer[] genre_ids;
    private String title;
    private Double vote_average;
    private String overview;
    private String release_date;

    public Result() {

    }

    public Result(Double popularity, Integer vote_count, Boolean video, String poster_path, Integer id, Boolean adult, String backdrop_path, String original_language, String original_title, Integer[] genre_ids, String title, Double vote_average, String overview, String release_date) {
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.poster_path = poster_path;
        this.id = id;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.genre_ids = genre_ids;
        this.title = title;
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Integer[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(Integer[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
