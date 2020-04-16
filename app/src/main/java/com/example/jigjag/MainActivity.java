package com.example.jigjag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Psychometric testing";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.RvList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        GamesAdapter.RecyclerViewClickListener listener = new GamesAdapter.RecyclerViewClickListener(){
            @Override
            public void onClick(View view, int position){
                launchgameone(position);
            }
        };
        mAdapter = new GamesAdapter(Games.getGames(), listener);
        mRecyclerView.setAdapter(mAdapter);

    }
    private void launchgameone (int position){
        Intent intent = new Intent(this, GameOneFragment.class);
        intent.putExtra(EXTRA_MESSAGE ,position);
        startActivity(intent);
    }
}