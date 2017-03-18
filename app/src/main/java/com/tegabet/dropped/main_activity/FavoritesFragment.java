package com.tegabet.dropped.main_activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tegabet.dropped.R;
import com.tegabet.dropped.data_layer.Product;
import com.tegabet.dropped.service_layer.FavoriteProductService;
import com.tegabet.dropped.service_layer.ProductService;

import java.util.ArrayList;

/**
 * Created by sultankhan on 3/16/17.
 */
public class FavoritesFragment extends Fragment{

    private Activity activity;
    private RecyclerView recyclerView;
    private FavoritesFragmentRecyclerAdapter adapter;
    private SwipeRefreshLayout srlSwipeRefreshLayout;
    private LinearLayout llTutorialLayout;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FavoritesFragmentRecyclerAdapter(getActivity(), FavoriteProductService.getInstance().getData());

    }

    @Override
    public void onResume() {
        super.onResume();

        Refresh();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if (context instanceof Activity){
            activity = (Activity) context;
            this.activity = activity;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        // Setup Recycler view
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        llTutorialLayout = (LinearLayout) view.findViewById(R.id.llTutorialLayout);

        srlSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srlSwipeRefreshLayout);
        srlSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Refresh();
                srlSwipeRefreshLayout.setRefreshing(false);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void Refresh(){

        if ( adapter == null ) {
            srlSwipeRefreshLayout.setRefreshing(false);
            return;
        }

        //adapter.clearData();

        //for (Product product : FavoriteProductService.getInstance().getData()){
        //    adapter.addRow(product);
        //}

        adapter.notifyDataSetChanged();

        if(adapter.getItemCount() != 0){
            llTutorialLayout.setVisibility(View.GONE);
        } else {
            llTutorialLayout.setVisibility(View.VISIBLE);
        }
    }
}
