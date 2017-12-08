package com.vistagram.vistaFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vistagram.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserPosts_ProfileFragment extends Fragment {


    public UserPosts_ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_posts__profile, container, false);
    }

}
