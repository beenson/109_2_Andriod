package com.example.a108590005_hw7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void createActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    public void dountClick(View view) {
        createActivity(dount.class);
    }

    public void froyoClick(View view) {
        createActivity(froyo.class);
    }

    public void icecreamClick(View view) {
        createActivity(icecream.class);
    }
}