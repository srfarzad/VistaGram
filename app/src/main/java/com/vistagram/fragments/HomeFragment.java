package com.vistagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vistagram.R;
import com.vistagram.adapter.PostsAdapter;
import com.vistagram.helperlibrary.utils.Logger;
import com.vistagram.model.Post;
import com.vistagram.model.listener.IResponseAsListListener;
import com.vistagram.serviceApi.WebserivceHandler;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.recyclerView_posts)
    RecyclerView recyclerView_posts;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        WebserivceHandler webserivceHandler=new WebserivceHandler(getActivity());
       // webserivceHandler.getPosts("", "", new IRes  )

        webserivceHandler.getPosts("", "", new IResponseAsListListener() {
            @Override
            public void onSuccess(Response response) {
                Logger.Log("Response",response.toString());
                List<Post> postList= (List<Post>) response.body();
                recyclerView_posts.setAdapter(new PostsAdapter(getActivity(),postList));
                recyclerView_posts.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            }

            @Override
            public void onFailure(String error) {

            }
        });




        return view;
    }

}
