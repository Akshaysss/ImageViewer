package com.imageviewer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imageviewer.adapters.ImageViewer_Adapter;
import com.imageviewer.R;


public class RV_Fragment2 extends Fragment {
    private ImageViewer_Adapter mAdapter;
    private RecyclerView mRecyclerView;
    Context context;


    public RV_Fragment2() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rv_, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_imageViewer);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);


       /* List<Model> list = new ArrayList<>();
        Model m1 = new Model("http://www.newsread.in/wp-content/uploads/2016/06/Mobile-Wallpapers-3.jpg");
        list.add(m1);

        for (int i = 0; i < 5; i++) {
            list.add(new Model("http://www.newsread.in/wp-content/uploads/2016/06/Mobile-Wallpapers-4.jpg")
            );
        }

        for (int i = 0; i < 5; i++) {
            list.add(new Model("http://www.newsread.in/wp-content/uploads/2016/06/Mobile-Wallpapers-3.jpg"));
        }


        mAdapter = new ImageViewer_Adapter(list, getContext());*/
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
