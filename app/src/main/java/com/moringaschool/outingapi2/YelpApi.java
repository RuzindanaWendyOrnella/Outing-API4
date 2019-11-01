package com.moringaschool.outingapi2;

import com.moringaschool.outingapi2.models.YelpSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpApi {

    @GET("events")
    Call<YelpSearchResponse> getEvents(
            @Query("location") String location
    );
}