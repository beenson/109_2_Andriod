package com.example.a108590005_hw7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Intent intent = getIntent();
        int id = intent.getIntExtra(WordListAdapter.EXTRA_MESSAGE, 0);

        LinkedList<String> name = new LinkedList<>();
        MainActivity.readFile(getResources().openRawResource(R.raw.recipe_names), name);

        int[] imgList = new int[] {R.drawable.chocolate_mint_bar,
                R.drawable.blueberry_cupcakes,
                R.drawable.fudge_brownies,
                R.drawable.lemon_cake,
                R.drawable.cobbler,
                R.drawable.sheet_cake,
                R.drawable.espresso_crinkles,
                R.drawable.chocolate_cherry_cookies,
                R.drawable.tiramisu,
                R.drawable.carrot_cake,
                R.drawable.blueberry_ice_cream};

        TextView title = findViewById(R.id.title);
        TextView step = findViewById(R.id.step);
        ImageView image = findViewById(R.id.image);

        title.setText(name.get(id));
        image.setImageResource(imgList[id]);
    }
}