package com.example.espresso_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ListDetailsPage extends Activity {

    private TextView mSelectedMovie;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);
        mSelectedMovie = findViewById(R.id.selected_movie);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("data");
        mSelectedMovie.setText("You have selected"+" "+data);
    }
}
