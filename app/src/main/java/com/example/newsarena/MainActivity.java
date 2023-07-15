package com.example.newsarena;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TabLayout tablay;
    TabItem mhome,mscience,msports,ment,mtech;
    pageradapter padapter;
    ViewPager viewPager;
    Toolbar mtoolbar;
    ConstraintLayout constraintLayout;
    Button retry;
    SwipeRefreshLayout swipeRefreshLayout;
    Switch aSwitch;




    String api="eaad5b08a1164a45b2898af23f573f38";
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageView=findViewById(R.id.navbar);
        setContentView(R.layout.activity_main);
        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mscience=findViewById(R.id.science);
        mhome=findViewById(R.id.lhome);
        msports=findViewById(R.id.sports);
        ment=findViewById(R.id.entertainment);
        mtech=findViewById(R.id.technology);
        swipeRefreshLayout=findViewById(R.id.refresh);
        viewPager=findViewById(R.id.fragmentcontainer);
        tablay=findViewById(R.id.tablayout);
        padapter=new pageradapter(getSupportFragmentManager(),tablay.getTabCount());
        constraintLayout=findViewById(R.id.include);
        retry=constraintLayout.findViewById(R.id.rbutton);
        aSwitch=findViewById(R.id.dark);
        //aSwitch.setOnCheckedChangeListener(_,isChecked ->
              //  );
        if(!networkutil.check(this))
        {
            viewPager.setVisibility(View.GONE);
            constraintLayout.setVisibility(View.VISIBLE);

        }
        else
        {
            viewPager.setVisibility(View.VISIBLE);
            viewPager.setAdapter(padapter);
            constraintLayout.setVisibility(View.GONE);
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(!networkutil.check(getApplicationContext()))
                {
                    viewPager.setVisibility(View.GONE);
                    constraintLayout.setVisibility(View.VISIBLE);
                    swipeRefreshLayout.setRefreshing(false);

                }
                else
                {
                    constraintLayout.setVisibility(View.GONE);
                    viewPager.setVisibility(View.VISIBLE);
                    viewPager.setAdapter(padapter);
                    Toast.makeText(MainActivity.this, "Refrshed SuccessFull", Toast.LENGTH_SHORT).show();
                    swipeRefreshLayout.setRefreshing(false);

                }

            }
        });
        retry.setOnClickListener(v -> {
            if(!networkutil.check(getApplicationContext()))
            {
                viewPager.setVisibility(View.GONE);
                constraintLayout.setVisibility(View.VISIBLE);

            }
            else
            {
                viewPager.setVisibility(View.VISIBLE);
                viewPager.setAdapter(padapter);
                constraintLayout.setVisibility(View.GONE);
            }
        });



        tablay.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4)
                    padapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablay));

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "NAvbar clicked", Toast.LENGTH_SHORT).show();
//            }
  //      });





    }
}