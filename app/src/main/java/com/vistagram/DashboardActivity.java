package com.vistagram;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.vistagram.fragments.BlankFragment;
import com.vistagram.fragments.HomeFragment;
import com.vistagram.fragments.PostFragment;
import com.vistagram.fragments.SearchFragment;
import com.vistagram.helperlibrary.ApplicationManager;
import com.vistagram.helperlibrary.ApplicationPermission;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

   @BindView(R.id.menu_bottom)
    BottomNavigationView menu_bottom;

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        menu_bottom.setOnNavigationItemSelectedListener(this);


        String package1 = ApplicationManager.getPackageName(getApplicationContext());

        //R.color.amber_100;


        if(ApplicationPermission.isStoragePermissionGranted(DashboardActivity.this));


       /* WebserviceHandler webserivceHandler=new WebserviceHandler(getApplicationContext());

        try {
            webserivceHandler.register("android", "123", new IMessageListener() {
                @Override
                public void onSuccess(String data) {

                    Log.e("data",data);


                }

                @Override
                public void onFailure(String error) {
                    Log.e("Fail","fail");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        int number=1;
        switch (item.getItemId()){
            
            case R.id.itm_menu_home:
                    fragment=new HomeFragment();
                number=0;
                break;

            case R.id.itm_menu_post:
                    fragment=new PostFragment();
                number=2;
                break;
                
            case R.id.itm_menu_profile:
                fragment=new BlankFragment();
                number=3;
                break;
                
            case R.id.itm_menu_search:
                fragment=new SearchFragment();
                number=1;
                break;
            
        }
        
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

        menu_bottom.getMenu().getItem(number).setChecked(true);
        
        return false;
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
            finish();
            System.exit(0);
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}
