package com.android.tsotsi.codeproject.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by TSOTSI on 2015/11/04.
 */
public class NetworkConnectivity {

    private Context context;
    private static NetworkConnectivity networkConnectivity;

    private NetworkConnectivity(Context context) {
        this.context = context;
    }

    public static synchronized NetworkConnectivity getInstance(Context context) {
        if (networkConnectivity == null) {
            networkConnectivity = new NetworkConnectivity(context);
        }
        return networkConnectivity;
    }

    public boolean isConnectedToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService((Context.CONNECTIVITY_SERVICE));
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

}
