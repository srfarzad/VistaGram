package com.vistagram.model.listener;

/**
 * Created by Android on 12/1/2017.
 */

public interface IMessageListener {


    public void onSuccess(String response);

    public void onFailure(String error);


}
