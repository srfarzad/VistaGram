package com.vistagram.serviceApi;

import android.content.Context;
import android.util.Log;

import com.vistagram.helperlibrary.utils.DataParser;
import com.vistagram.model.listener.IMessageListener;
import com.vistagram.model.Post;
import com.vistagram.model.listener.IResponseAsListListener;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

/**
 * Created by Android on 12/1/2017.
 */

public class WebserivceHandler {
    ApiInterface apiInterface;
    Context context;

    private WebserivceHandler() {
    }


    public WebserivceHandler(Context context) {
        this.context = context;
        apiInterface = RetrofitHandler.getRetrofit().create(ApiInterface.class);
    }


    public void login(String user, String pass, final IMessageListener messageListener) throws Exception {

        Call<ResponseBody> login = apiInterface.login(user, pass);

        login.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String bodyString = new String(response.body().bytes());
                    messageListener.onSuccess(bodyString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                messageListener.onFailure(throwable.getMessage().toString());
            }
        });


    }


    public void register(String user, String pass, final IMessageListener messageListener) {

        Call<ResponseBody> login = apiInterface.register(user, pass);

        login.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String bodyString = new String(response.body().bytes());

                    try {
                        messageListener.onSuccess(DataParser.getRegisterResponse(bodyString) + "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // messageListener.onSuccess(bodyString);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                messageListener.onFailure(throwable.getMessage().toString());
            }
        });


    }


    public void getPosts(String from, String to, final IResponseAsListListener messageListener) {

        Call<List<Post>> listCall = apiInterface.getPosts("111", "111");

        listCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.e("Data", response.toString());
                messageListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable throwable) {
                messageListener.onFailure(throwable.getMessage().toString());
            }
        });


    }


    public void getData() {

        Call<POST> postCall = apiInterface.getData();
        postCall.enqueue(new Callback<POST>() {
            @Override
            public void onResponse(Call<POST> call, Response<POST> response) {

            }

            @Override
            public void onFailure(Call<POST> call, Throwable throwable) {

            }
        });


    }


}
