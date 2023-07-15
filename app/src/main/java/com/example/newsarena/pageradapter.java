package com.example.newsarena;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageradapter extends FragmentPagerAdapter {

    int tabcnt;

    public pageradapter(@NonNull  FragmentManager fm, int behavior) {
        super(fm,behavior);
        tabcnt=behavior;

    }

    private void tabcnt(int behavior) {
    }

    @NonNull

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new homefrag();
            case 1:
                return new science();
            case 2:
                return new sports();
            case 3:
                return new entertainment();
            case 4:
                return new techfrag();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return tabcnt;
    }
}
