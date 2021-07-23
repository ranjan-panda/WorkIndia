package com.workindia.ui.home;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Retrofit retrofit;
    private  static Client client;
    private static final String BASE_URL = "https://run.mocky.io/v3/";



    private Client() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

    }

    public static synchronized Client getRetrofitInstance() {
        if (client == null) {
            client = new Client();

        }
        return client;

    }

    public Interface getApi(){
        return retrofit.create(Interface.class);
    }

}