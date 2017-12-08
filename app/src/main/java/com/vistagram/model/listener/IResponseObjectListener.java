package com.vistagram.model.listener;

import java.util.List;

/**
 * Created by Android on 12/1/2017.
 */

public interface IResponseObjectListener<T> {


    public void onSuccess(T response);
    public void onFailure(String error);


}
