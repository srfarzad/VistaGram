package com.vistagram.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Android on 12/8/2017.
 */

public class Post {
    @SerializedName("id")
    public String id;
    @SerializedName("user_id")
    public String user_id;
    @SerializedName("image")
    public String image;
    @SerializedName("description")
    public String description;
    @SerializedName("likeNumber")
    public String likeNumber;
    @SerializedName("comments")
    public String comments;


}
