package com.example.a108590005_hw4_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    EditText txtInput;
    TextView txtCount;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInput = (EditText)findViewById(R.id.txtInput);
        txtCount = (TextView)findViewById(R.id.textView);
        if(savedInstanceState != null)
            count = savedInstanceState.getInt("count");
        txtCount.setText(Integer.toString(count));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", parseInt((String) txtCount.getText().toString()));
    }

    public void count(View view) {
        count++;
        txtCount.setText(Integer.toString(count));
    }
}