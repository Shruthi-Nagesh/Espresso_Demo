package com.example.espresso_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends Activity {

    private List<Item> selectedItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemAdapter mAdapter;
    private Toolbar mToolbar ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView =  findViewById(R.id.cart_recycle_view);

        mToolbar =  findViewById(R.id.toolbar);
        mToolbar.setTitle("Product List");

        mAdapter = new ItemAdapter(selectedItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("data");
        int quant = bundle.getInt("quant");
        prepareMovieData(data,quant);

    }



    private void prepareMovieData (String data, int count) {
        Item item = new Item(data, null, String.valueOf(count));
        selectedItems.add(item);


        mAdapter.notifyDataSetChanged();

        mAdapter.setOnItemClickListner(new ItemAdapter.RecyclerViewClickInterface() {
            @Override
            public void getItemPosition(String str) {
                Intent detailIntent = new Intent(getApplicationContext(), ListDetailsPage.class);
                Bundle bundle = new Bundle();

                bundle.putString("data", str);
                detailIntent.putExtras(bundle);

                startActivity(detailIntent);
            }
        });
    }
}


