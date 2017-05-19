package com.imageviewer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.imageviewer.adapters.ImageViewer_Adapter;
import com.imageviewer.Model;
import com.imageviewer.R;
import com.imageviewer.internet.InternetService;
import com.imageviewer.internet.InternetSetting;
import com.imageviewer.models.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RV_Fragment extends Fragment {

    private ImageViewer_Adapter mAdapter;
    private RecyclerView mRecyclerView;
    Context context;


    public RV_Fragment() {
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


        /*Call<List<Users>> call = InternetSetting.client().getUsers();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                Toast.makeText(getContext(), "sucess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });*/

        return v;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_imageViewer);
       /* LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());*/
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);


        List<Model> list = new ArrayList<>();
        Model m1 = new Model("http://www.newsread.in/wp-content/uploads/2016/06/Mobile-Wallpapers-3.jpg", "1", "Pavan", "Akshay");

        list.add(m1);

        for (int i = 2; i < 6; i++) {
            list.add(new Model("http://www.newsread.in/wp-content/uploads/2016/06/Mobile-Wallpapers-4.jpg", "" + i, "Akshay", "Pavan")
            );
        }

        for (int i = 7; i < 12; i++) {
            list.add(new Model("http://www.newsread.in/wp-content/uploads/2016/06/Mobile-Wallpapers-3.jpg", "" + i, "Ram", "Design"));
        }


        mAdapter = new ImageViewer_Adapter(list, getContext());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
