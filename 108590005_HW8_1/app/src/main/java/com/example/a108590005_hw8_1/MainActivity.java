package com.example.a108590005_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button add, minus;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        add = findViewById(R.id.add);
        minus = findViewById(R.id.minus);
        minus.setEnabled(false);
    }

    void setting(){
        add.setEnabled(id != 6);
        minus.setEnabled(id != 0);
        image.setImageLevel(id);

    }

    public void add(View view) {
        if(id != 6)
            id++;
        setting();
    }

    public void minus(View view) {
        if(id != 0)
            id--;
        setting();
    }
}