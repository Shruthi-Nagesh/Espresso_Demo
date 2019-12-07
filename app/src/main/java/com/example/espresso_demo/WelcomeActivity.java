package com.example.espresso_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class WelcomeActivity extends Activity implements View.OnClickListener{

    private TextView mWelcome;
    private CheckBox mCheckbox;
    private Button mShowListBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_welcome);
       mWelcome = (TextView) findViewById(R.id.welcome_text);
       mCheckbox = (CheckBox) findViewById(R.id.checkbox);
       mShowListBtn = (Button)findViewById(R.id.showlistbtn);
       mWelcome.setOnClickListener(this);
       mShowListBtn.setOnClickListener(this);
       mCheckbox.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.welcome_text :
                Intent webviewIntent = new Intent(this, WebviewActivity.class);
                startActivity(webviewIntent);
                break;
            case R.id.checkbox:
                if(mCheckbox.isChecked()) {
                    mShowListBtn.setEnabled(true);
                    mShowListBtn.setText("Show List");

                } else {
                    mShowListBtn.setEnabled(false);
                    mShowListBtn.setText("No List");
                }
                break;
            case R.id.showlistbtn :
                if(mCheckbox.isChecked()) {
                    Intent showListIntent = new Intent(this, ShowListActivity.class);
                    startActivity(showListIntent);
                }
                break;

        }
    }

}
