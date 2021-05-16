package com.example.a108590005_hw10_2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class UrlLoader extends AsyncTaskLoader<String> {
    private String mUrlString;

    public UrlLoader(Context context, String urlString) {
        super(context);
        mUrlString = urlString;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getSource(mUrlString);
    }
}
