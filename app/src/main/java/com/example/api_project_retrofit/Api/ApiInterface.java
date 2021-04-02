package com.example.api_project_retrofit.Api;

import com.example.api_project_retrofit.Model.BaseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/popular")
    Call<BaseModel> getMovie(@Query("api_key") String api_key);
}
