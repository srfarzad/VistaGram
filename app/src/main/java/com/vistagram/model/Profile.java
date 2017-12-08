package com.vistagram.model;

import com.orm.SugarRecord;

/**
 * Created by Android on 11/24/2017.
 */

public class Profile extends SugarRecord<Profile> {

    String name;
    String userName;
    String website;
    String bio;
    String icon;
    String phoneNumber;
    String email;
    boolean gender;


    public Profile(){}

    public Profile(String name,String userName,String website,String bio,String icon,String phoneNumber,String email,boolean gender){

        this.name=name;
        this.userName=userName;
        this.website=website;
        this.bio=bio;
        this.icon=icon;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.gender=gender;
    }



}
