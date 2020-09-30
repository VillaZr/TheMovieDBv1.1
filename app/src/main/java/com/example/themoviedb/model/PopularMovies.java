package com.example.themoviedb.model;

import java.util.ArrayList;

public class PopularMovies {

    private Integer page;
    private Integer total_results;
    private Integer total_pages;
    private ArrayList<Result> result_list = new ArrayList<Result>();

    public PopularMovies() {

    }

    public PopularMovies(Integer page, Integer total_results, Integer total_pages, ArrayList<Result> result_list) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.result_list = result_list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<Result> getResult_list() {
        return result_list;
    }

    public void setResult_list(ArrayList<Result> result_list) {
        this.result_list = result_list;
    }
}
