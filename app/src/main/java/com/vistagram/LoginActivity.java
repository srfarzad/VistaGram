package com.vistagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vistagram.model.User;
import com.vistagram.model.listener.IMessageListener;
import com.vistagram.serviceApi.ApiInterface;
import com.vistagram.serviceApi.RetrofitHandler;
import com.vistagram.serviceApi.WebserviceHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

/**
 * Created by Elmerooz on 12/12/2017.
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_Next)
    Button btnNext;

    @BindView(R.id.txt_inputUserName)
    EditText inputUserName;

    @BindView(R.id.txt_inputPassword)
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        final WebserviceHandler webserviceHandler = new WebserviceHandler(getApplicationContext());

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = inputUserName.getText().toString();
                String password = inputPassword.getText().toString();
                try {
                    webserviceHandler.login(userName, password, new IMessageListener() {
                        @Override
                        public void onSuccess(String response) {

                            try {
                                JSONObject obj = new JSONObject(response);
                                String code = obj.getString("code");
                                System.out.println("code=" + code);
                                if (code.equals("0")) {
                                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_LONG).show();
                                } else if (code.equals("1")) {
                                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                                    startActivity(intent);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(String error) {
                            Log.e("error", "");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
