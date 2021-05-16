package com.example.a108590005_hw10_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    Spinner spinner;
    TextView txtResult, txtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        txtUrl = findViewById(R.id.txtUrl);
        txtResult = findViewById(R.id.txtResult);

        //Create an ArrayAdapter by using a string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.http, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appear
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Now apply the adapter to spinner
        spinner.setAdapter(adapter);

        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String urlString = "";

        if (args != null) {
            urlString = args.getString("urlString");
        }

        return new UrlLoader(this, urlString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        txtResult.setText(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public void getSource(View view) {
        Bundle urlBundle = new Bundle();
        urlBundle.putString("urlString", spinner.getSelectedItem().toString() + String.valueOf(txtUrl.getText()));
        Log.d("URL", urlBundle.getString("urlString"));
        getSupportLoaderManager().restartLoader(0, urlBundle, this);
    }
}