package com.example.newsarena;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homefrag extends Fragment{
    String api="eaad5b08a1164a45b2898af23f573f38";
    ArrayList<modalclass>modalclassArrayList;
    adapter adapter;
    String country="in";
    private RecyclerView recyclerViewh;


    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_homefrag,container,false);
        recyclerViewh=v.findViewById(R.id.rechome);
        modalclassArrayList=new ArrayList<>();
        recyclerViewh.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new adapter(getContext(),modalclassArrayList);
        recyclerViewh.setAdapter(adapter);
        findnews();

        return v;


    }

    private void findnews() {
        apiutil.getapiinterface().getnews(country,10,api).enqueue(new Callback<mainnews>() {
            @Override
            public void onResponse(Call<mainnews> call, Response<mainnews> response) {
                if(response.isSuccessful())
                {
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