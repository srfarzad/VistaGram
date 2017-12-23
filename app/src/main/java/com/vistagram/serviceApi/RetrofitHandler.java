package com.vistagram.serviceApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android on 12/1/2017.
 */

public class RetrofitHandler {

    public static String BaseURl = "http://androidsupport.ir/vistagram/";

    private static Retrofit retrofit = null;


    public static Retrofit getRetrofit() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BaseURl).addConverterFactory(GsonConverterFactory.create(gson))
                    .build();


         /*   retrofit = new Retrofit.Builder()
                    .baseUrl(BaseURl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();*/

        }
        return retrofit;
    }


}
