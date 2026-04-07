package com.unity.androidplugin;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class AndroidPlugin {

    private Activity activity;

    public AndroidPlugin(Context context) {
        this.activity = (Activity) context;
    }

    public void ToastMakeText(String message) {
        activity.runOnUiThread(() -> {
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
        });
    }
}
