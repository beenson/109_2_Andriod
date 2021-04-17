package com.example.a108590005_hw7_2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    private final LinkedList<String[]> mWordList;
    private LayoutInflater mInflater;

    public static final String EXTRA_MESSAGE = "extra.MESSAGE";

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.titleTxt.setText(mWordList.get(position)[0]);
        holder.desTxt.setText(mWordList.get(position)[1]);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public WordListAdapter(Context context, LinkedList<String[]> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView titleTxt;
        public final TextView desTxt;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.title);
            desTxt = itemView.findViewById(R.id.describe);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            Intent intent = new Intent(v.getContext(), recipe.class);
            intent.putExtra(EXTRA_MESSAGE, mPosition);
            v.getContext().startActivity(intent);
        }
    }
}
