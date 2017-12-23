package com.vistagram.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;

import com.vistagram.DashboardActivity;
import com.vistagram.LoginActivity;
import com.vistagram.MainActivity;
import com.vistagram.R;
import com.vistagram.config.AppConfiguration;
import com.vistagram.model.User;
import com.vistagram.model.listener.IMessageListener;
import com.vistagram.model.listener.IResponseAsListListener;
import com.vistagram.serviceApi.WebserviceHandler;
import com.vistagram.util.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Elmerooz on 12/7/2017.
 */

public class PhoneFragment extends Fragment {

    SharedPreferences.Editor editor;
    User user;

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.txt_inputUserName)
    EditText inputUserName;

    @BindView(R.id.txt_inputPassword)
    EditText inputPassword;

    public PhoneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_phone, container, false);
        ButterKnife.bind(this, view);

        final WebserviceHandler webserviceHandler = new WebserviceHandler(getActivity());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName = inputUserName.getText().toString();
                final String password = inputPassword.getText().toString();
                webserviceHandler.register(userName, password, new IMessageListener() {
                    @Override
                    public void onSuccess(String response) {
                        user = new User((long) 2, userName, password);
                        user.save();
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }

                    @Override
                    public void onFailure(String error) {
                        Log.e("error===", "");
                    }
                });
            }
        });
        return view;
    }

}
