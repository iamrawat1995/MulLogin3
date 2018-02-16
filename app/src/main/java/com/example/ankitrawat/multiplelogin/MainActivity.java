package com.example.ankitrawat.multiplelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity {

    ImageView i,ii;
    EditText e;
    EditText ee;
    LoginButton loginButton;
    CallbackManager callbackManager;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        loginButton = (LoginButton) findViewById(R.id.fb_login_button);
        textView =(TextView)findViewById(R.id.login_status);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                textView.setText("Login Success \n" +
                loginResult.getAccessToken().getUserId()+
                "\n"+loginResult.getAccessToken().getToken());

            }

            @Override
            public void onCancel() {
                textView.setText("Login cancelled");

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        i=(ImageView)findViewById(R.id.imageView1);
        ii=(ImageView)findViewById(R.id.imageView2);
        e=(EditText)findViewById(R.id.editText2);
        ee=(EditText)findViewById(R.id.editText3);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            i.setBackgroundResource(R.drawable.border_blue);
            ii.setBackgroundResource(R.drawable.white);

            }
        });
        ii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.setBackgroundResource(R.drawable.white);
                ii.setBackgroundResource(R.drawable.border_blue);
            }
        });
        e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus==true)
                    e.setBackgroundResource(R.drawable.border_blue);
                if(hasFocus==false)
                    e.setBackgroundResource(R.drawable.white);
            }
        });
        ee.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus==true)
                    ee.setBackgroundResource(R.drawable.border_blue);
                if(hasFocus==false)
                    ee.setBackgroundResource(R.drawable.white);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
