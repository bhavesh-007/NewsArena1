package com.example.newsarena;

import android.content.Context;
import android.net.ConnectivityManager;

public class networkutil {
    public static boolean check(Context context)
    {

        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
