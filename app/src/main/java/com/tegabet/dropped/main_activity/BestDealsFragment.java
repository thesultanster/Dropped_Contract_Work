package com.tegabet.dropped.main_activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tegabet.dropped.R;
import com.tegabet.dropped.data_layer.BestDealItem;

import java.util.ArrayList;

/**
 * Created by sultankhan on 3/16/17.
 */
public class BestDealsFragment extends Fragment {

    private Activity activity;
    private RecyclerView recyclerView;
    private BestDealsFragmentRecyclerAdapter adapter;

    public BestDealsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setup Recycler adapter for Favorite Items
        adapter = new BestDealsFragmentRecyclerAdapter(getActivity(), new ArrayList<BestDealItem>());
        adapter.addRow(new BestDealItem("Item 1"));
        adapter.addRow(new BestDealItem("Item 2"));

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

        View view = inflater.inflate(R.layout.fragment_best_deals, container, false);


        // Setup Recycler view
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}
