package com.example.espresso_demo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import javax.microedition.khronos.egl.EGLDisplay;

public class LoginActivity extends Activity implements View.OnClickListener {

    private Button mLoginBtn;
    private EditText mUserNmae;
    private EditText mPassword;
    private TextView mErrorText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginBtn = (Button) findViewById(R.id.login);
        mUserNmae = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mErrorText = (TextView) findViewById(R.id.error);

        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login :
                if(!TextUtils.isEmpty(mUserNmae.getText().toString()) && !TextUtils.isEmpty(mPassword.getText().toString())) {
                    mErrorText.setVisibility(View.GONE);
                    Intent intent = new Intent(this, WelcomeActivity.class);
                    startActivity(intent);
                } else {
                    mErrorText.setVisibility(View.VISIBLE);
                }
        }
    }
}


