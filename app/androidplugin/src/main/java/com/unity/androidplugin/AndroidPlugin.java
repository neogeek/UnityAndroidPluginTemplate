package com.unity.androidplugin;

import android.content.Context;
import android.widget.Toast;

public class AndroidPlugin {

    private Context context;

    public AndroidPlugin(Context context) {
        this.context = context;
    }

    public void ToastMakeText(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
