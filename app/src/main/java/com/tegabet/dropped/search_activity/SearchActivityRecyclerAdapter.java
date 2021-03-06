package com.tegabet.dropped.search_activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.tegabet.dropped.ProductActivity;
import com.tegabet.dropped.R;
import com.tegabet.dropped.data_layer.Product;

import java.util.Collections;
import java.util.List;

/**
 * Created by sultankhan on 3/17/17.
 */
public class SearchActivityRecyclerAdapter extends RecyclerView.Adapter<SearchActivityRecyclerAdapter.MyViewHolder> {

    // emptyList takes care of null pointer exception
    List<Product> data = Collections.emptyList();
    LayoutInflater inflator;
    Context context;

    public SearchActivityRecyclerAdapter(Context context, List<Product> data) {
        this.context = context;
        inflator = LayoutInflater.from(context);
        this.data = data;
    }



    public void addRow(Product row) {


        final int index = getItemCount();


        data.add(row);
        notifyItemInserted(getItemCount() - 1);
    }

    public void updateRows(){
        notifyDataSetChanged();
    }

    public void clearData() {
        int size = this.data.size();

        data.clear();

        this.notifyItemRangeRemoved(0, size);
    }

    // Called when the recycler view needs to create a new row
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = inflator.inflate(R.layout.row_search_item, parent, false);
        final MyViewHolder holder = new MyViewHolder(view, new MyViewHolder.MyViewHolderClicks() {

            public void rowClick(View caller, int position) {
                Log.d("rowClick", "rowClicks");

                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("product", data.get(position));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }


        });
        return holder;
    }

    // Setting up the data for each row
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // This gives us current information list object
        Product current = data.get(position);
        holder.tvTitle.setText(current.getTitle());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    // Created my custom view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle;

        public MyViewHolderClicks mListener;

        // itemView will be my own custom layout View of the row
        public MyViewHolder(View itemView, MyViewHolderClicks listener) {
            super(itemView);

            mListener = listener;

            //Link the objects
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

            // Set a click listener on the whole row
            itemView.setOnClickListener(this);

        }

        // Handle on click events on different views of the row
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                //case R.id. ...
                default:
                    mListener.rowClick(v, getAdapterPosition());
                    break;
            }
        }

        public interface MyViewHolderClicks {
            void rowClick(View caller, int position);
        }

    }
}
