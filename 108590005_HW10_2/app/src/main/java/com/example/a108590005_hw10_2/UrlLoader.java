package com.example.a108590005_hw10_2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class UrlLoader extends AsyncTaskLoader<String> {
    private String mQueryString;

    public BookLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return null;
    }
}
