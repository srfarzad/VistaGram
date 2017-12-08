package com.vistagram.helperlibrary.utils;

import org.json.JSONObject;

/**
 * Created by Android on 12/8/2017.
 */

public class DataParser {


    public static int getRegisterResponse(String data) throws Exception {
        JSONObject jsonObject = new JSONObject(data);
        int code = jsonObject.getInt("code");
        return code;
    }

}
