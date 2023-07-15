package com.example.newsarena;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiinterface {
    String BASE_URL="https://newsapi.org/v2/";
    @GET("top-headlines")
    Call<mainnews> getnews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey);
    @GET("top-headlines")
    Call<mainnews> getcategoyrnews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey
            );
}
