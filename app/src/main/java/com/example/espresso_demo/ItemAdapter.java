package com.example.espresso_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<Item> moviesList;
    private RecyclerViewClickInterface mListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle, mDescription, mQuantity;

        public MyViewHolder(View view) {
            super(view);

            mTitle = (TextView) view.findViewById(R.id.title);
            mDescription = (TextView) view.findViewById(R.id.description);
            mQuantity = (TextView) view.findViewById(R.id.quantity);
        }
    }


    public ItemAdapter(List<Item> moviesList) {
        this.moviesList = moviesList;
    }

    public void setOnItemClickListner(RecyclerViewClickInterface listener) {
        this.mListener = listener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Item item = moviesList.get(position);
        holder.mTitle.setText(item.getTitle());
        holder.mDescription.setText(item.getDesc());
        holder.mQuantity.setText(item.getQuantity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.getItemPosition(item.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
    public interface RecyclerViewClickInterface {

        public void getItemPosition(String data);

    }
}


