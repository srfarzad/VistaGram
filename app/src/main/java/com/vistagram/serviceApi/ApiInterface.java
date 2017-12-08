package com.vistagram.serviceApi;

import com.vistagram.model.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Android on 12/1/2017.
 */

public interface ApiInterface<T> {

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> register(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("posts.php")
    Call<List<Post>> getPosts(@Field("from") String from, @Field("to") String to);


    @FormUrlEncoded
    @POST("login.php")
    Call<T> getData();


}
