package com.example.espresso_demo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ListDetailsPage extends Activity implements View.OnClickListener {

    private TextView mSelectedMovie;
    private TextView mQuantity;
    private Button mAddBtn;
    private Button mMinusBtn;
    private Button mAddtoCart;
    private String mData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);
        mSelectedMovie = findViewById(R.id.selected_movie);
        mQuantity = findViewById(R.id.quantity);
        mAddBtn = findViewById(R.id.add_btn);
        mMinusBtn = findViewById(R.id. minus_btn);
        mAddtoCart = findViewById(R.id.add_to_cart_btn);

        mAddBtn.setOnClickListener(this);
        mMinusBtn.setOnClickListener(this);
        mAddtoCart.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("data");
        mData = data;
        mSelectedMovie.setText("You have selected"+" "+data);

    }

    @Override
    public void onClick(View v) {
        int count = 1;
        switch (v.getId()) {
            case R.id.add_btn:
                count = count + 1;
                mQuantity.setText("Quantity"+" "+count);
                break;
            case R.id.minus_btn:
                if(count >= 2) {
                    count = count - 1;
                }
                mQuantity.setText("Quantity"+" "+count);
                break;
            case R.id.add_to_cart_btn:
                Intent cartIntent = new Intent(getApplicationContext(), CartActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("data", mData);
                bundle.putInt("quant",count);
                cartIntent.putExtras(bundle);

                startActivity(cartIntent);
                break;
        }
    }
}
