package com.vistagram.model;

import java.util.List;

/**
 * Created by Android on 12/8/2017.
 */

public abstract class ResponseListener<T> {

    public void onResponseAsList(List<T> tList) {}

    public void onResponseObject(T tObject) {}

    public void onResponseMessage(String message) {}

    public  abstract void  onFailure(String d);


}
