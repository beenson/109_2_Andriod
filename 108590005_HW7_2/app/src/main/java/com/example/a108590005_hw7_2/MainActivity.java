package com.example.a108590005_hw7_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<String[]> mWordList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList<String> name = new LinkedList<>();
        LinkedList<String> desc = new LinkedList<>();
        readFile(getResources().openRawResource(R.raw.recipe_names), name);
        readFile(getResources().openRawResource(R.raw.recipe_desc), desc);
        Log.d("size", name.size() + "");
        for(int i = 0; i < name.size(); i++) {
            mWordList.add(new String[] {name.get(i), desc.get(i)});
        }

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public static void readFile(InputStream ins, LinkedList<String> list) {
        String contents = null;
        String [] contents_array = null;
        StringBuffer fileContent = new StringBuffer("");

        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader(ins, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        contents = textBuilder.toString();

        if (contents != null) {
            contents_array = contents.split("\\r?\\n");
        }
        if (contents_array != null) {
            for (int i = 0; i < contents_array.length ; i++){
                list.add(i, contents_array[i]);
                Log.d("ARRAY CONTENTS", contents_array[i]);
            }
        }
    }
}