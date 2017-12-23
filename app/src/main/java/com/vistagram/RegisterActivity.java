package com.vistagram;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.vistagram.R;
import com.vistagram.adapter.ViewPagerAdapter;
import com.vistagram.fragments.EmailFragment;
import com.vistagram.fragments.PhoneFragment;
import com.vistagram.util.ImageConverter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Elmerooz on 12/12/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.rel_register)
    RelativeLayout rel_register;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_login);
        ButterKnife.bind(this);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.profile);
        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);
        ImageView imgProfile = (ImageView) findViewById(R.id.img_profile);
        imgProfile.setImageBitmap(circularBitmap);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PhoneFragment(), "PHONE");
        adapter.addFragment(new EmailFragment(), "EMAIL");
        viewPager.setAdapter(adapter);
    }
}
