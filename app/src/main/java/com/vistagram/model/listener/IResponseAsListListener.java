package com.vistagram.model.listener;

import com.vistagram.model.Post;

import java.util.List;

import retrofit2.Response;

/**
 * Created by Android on 12/1/2017.
 */

public interface IResponseAsListListener<T> {


    public void onSuccess(Response<List<T>> response);
    public void onFailure(String error);


}
