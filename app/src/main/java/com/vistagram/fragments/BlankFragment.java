package com.vistagram.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.vistagram.R;
import com.vistagram.adapter.ProfileTabLayout_Adapter;
import com.vistagram.vistaFragment.GridView_ProfileFragment;
import com.vistagram.vistaFragment.ListView_ProfileFragment;
import com.vistagram.vistaFragment.SavedPots_profileFragment;
import com.vistagram.vistaFragment.UserPosts_ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    ProfileTabLayout_Adapter pAdapter;
    @BindView(R.id.profile_tablayout)
    TabLayout profileTablayout;
    @BindView(R.id.profile_viewPager)
    ViewPager profileViewPager;
    Unbinder unbinder;
    @BindView(R.id.userImg)
    ImageView userImg;
    @BindView(R.id.userId)
    TextView userId;
    @BindView(R.id.postsCounter)
    TextView postsCounter;
    @BindView(R.id.followersCounter)
    TextView followersCounter;
    @BindView(R.id.followingCounter)
    TextView followingCounter;
    @BindView(R.id.editUserProfile)
    TextView editUserProfile;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        unbinder = ButterKnife.bind(this, view);

        initialisePaging();
        setupTabIcons();

        return view;
    }

    private void initialisePaging() {

        pAdapter = new ProfileTabLayout_Adapter(getActivity().getSupportFragmentManager());
        pAdapter.add(new GridView_ProfileFragment());
        pAdapter.add(new ListView_ProfileFragment());
        pAdapter.add(new UserPosts_ProfileFragment());
        pAdapter.add(new SavedPots_profileFragment());

        profileViewPager.setAdapter(pAdapter);
        profileTablayout.setupWithViewPager(profileViewPager);


    }

    private void setupTabIcons() {
        profileTablayout.getTabAt(0).setIcon(tabIcons[0]);
        profileTablayout.getTabAt(1).setIcon(tabIcons[1]);
        profileTablayout.getTabAt(2).setIcon(tabIcons[2]);
        profileTablayout.getTabAt(3).setIcon(tabIcons[3]);

    }

    private int[] tabIcons = {
            R.mipmap.apps,
            R.mipmap.note,
            R.mipmap.photograph,
            R.mipmap.bookmark,

    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.editUserProfile)
    public void onViewClicked() {



    }
}
