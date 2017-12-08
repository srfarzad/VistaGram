package com.vistagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vistagram.R;
import com.vistagram.model.Profile;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_profile, container, false);


        try {

            Profile profile=new Profile("f","ff","http://google.com","asdasd","http://dd","091222","email",true);


            profile.save();


            Profile profile1=Profile.findById(Profile.class,(long)1);
        }
        catch (Exception e){

            e.printStackTrace();
        }




        return view;
    }

}
