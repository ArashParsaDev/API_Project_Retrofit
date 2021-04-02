package com.example.api_project_retrofit.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null ;
    public static Retrofit getApiClient(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
