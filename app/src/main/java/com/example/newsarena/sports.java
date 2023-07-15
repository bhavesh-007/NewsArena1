package com.example.newsarena;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sports  extends Fragment {
    String api="eaad5b08a1164a45b2898af23f573f38";
    ArrayList<modalclass>modalclassArrayList;
    adapter adapter;
    String country="in";
    private RecyclerView recyclerViewsp;
    private String category="sports";

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_sports,container,false);
        recyclerViewsp=v.findViewById(R.id.recsports);
        modalclassArrayList=new ArrayList<>();
        recyclerViewsp.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new adapter(getContext(),modalclassArrayList);
        recyclerViewsp.setAdapter(adapter);
        findnews();

        return v;


    }

    private void findnews() {
        apiutil.getapiinterface().getcategoyrnews(country,category,10,api).enqueue(new Callback<mainnews>() {
            @Override
            public void onResponse(Call<mainnews> call, Response<mainnews> response) {
                if(response.isSuccessful()) {
                    modalclassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<mainnews> call, Throwable t) {

            }
        });

    }
}
