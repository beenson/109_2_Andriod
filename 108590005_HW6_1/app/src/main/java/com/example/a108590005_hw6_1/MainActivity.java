package com.example.a108590005_hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<CheckBox> chkBoxes = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkBoxes.add(findViewById(R.id.chkBox_1));
        chkBoxes.add(findViewById(R.id.chkBox_2));
        chkBoxes.add(findViewById(R.id.chkBox_3));
        chkBoxes.add(findViewById(R.id.chkBox_4));
        chkBoxes.add(findViewById(R.id.chkBox_5));
    }

    public void toast(View view) {
        String txt = "Toppings:";

        for(CheckBox obj : chkBoxes){
            if(obj.isChecked()) {
                txt += " " + obj.getText();
            }
        }

        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }
}