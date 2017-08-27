package com.iak.finalproject.listiani.popularmovielisti.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ACER on 26/08/2017.
 */

public class MovieResponse {


    public int page;
//    namanya harus sama, serialized name buat parsingnya. Ini cara gampangnya
//    @SerializedName("total_results")
    public int totalResults;
//    @SerializedName("total_pages")
    public int totalPages;
    public List<MovieEntity> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<MovieEntity> getResults() {
        return results;
    }

    public void setResults(List<MovieEntity> results) {
        this.results = results;
    }
}
