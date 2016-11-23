package com.sommayah.practiceproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ItemAdapter mAdapter;


    public CameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_camera, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        ArrayList<Item> example = new ArrayList<>();
        example.add(new Item("apples","http://pngimg.com/upload/small/apple_PNG12455.png"));
        example.add(new Item("bananas","http://pngimg.com/upload/banana_PNG849.png"));
        example.add(new Item("pears", "http://pngimg.com/upload/pear_PNG3468.png"));
        example.add(new Item("orange", "http://pngimg.com/upload/juice_PNG7174.png"));
        example.add(new Item("mangoes","http://pngimg.com/upload/mango_PNG9188.png"));

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(CameraFragment.this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ItemAdapter(getContext(), example);
        mRecyclerView.setAdapter(mAdapter);



        return rootView;
    }

}
