package com.example.espresso_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShowListActivity extends Activity {

    private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist);

            recyclerView =  findViewById(R.id.recycler_view);

            mAdapter = new ItemAdapter(itemList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);

            prepareMovieData();

        }



        private void prepareMovieData () {
            Item item = new Item("Maybelline New York", "Maybelline New York color show Bright Matt",
                    "1");
            itemList.add(item);

            item = new Item(" Maybelline New York", "Maybelline New York Nail Paint", "1");
            itemList.add(item);

            item = new Item("Nick K Perfect", "Nick K Perfect eye shadow", "1");
            itemList.add(item);

            item = new Item("Nykaa", "Nykaa collosal", "1");
            itemList.add(item);

            item = new Item("Mac", "Mac Rubby", "1");
            itemList.add(item);


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

