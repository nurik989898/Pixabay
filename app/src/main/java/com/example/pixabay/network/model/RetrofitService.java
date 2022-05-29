package com.example.pixabay.network.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public pixApi getApi(){
        return retrofit.create(pixApi.class);
    }

}
