package com.iak.finalproject.listiani.popularmovielisti.network;

import com.iak.finalproject.listiani.popularmovielisti.model.MovieResponse;
import com.iak.finalproject.listiani.popularmovielisti.utils.ServiceUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ACER on 26/08/2017.
 */

public interface MovieService {
    /**
     * Untuk return URI :
     * http://api.themoviedb.org/3/movie/popular?api_key=<key><page>
     * @param apiKey
     * @return
     */
    @GET(ServiceUtils.POP_MOVIE_URL)
    Call<MovieResponse> getPopularMovie(
            @Query("api_key") String apiKey,
            @Query("page") int page);
    @GET(ServiceUtils.TOP_MOVIE_URL)
    Call<MovieResponse> getTopRatedMovie(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );
}
