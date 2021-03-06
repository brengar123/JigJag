package com.example.jigjag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {
    private ArrayList<Games> mGames;
    private RecyclerViewClickListener mListener;

    public GamesAdapter (ArrayList<Games> games, RecyclerViewClickListener listener){
        mGames = games;
        mListener = listener;
    }
    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class GamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView type;
        public TextView description;
        private RecyclerViewClickListener mListener;

        public GamesViewHolder(View v, RecyclerViewClickListener listener){
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            name = v.findViewById(R.id.ListName);
            type = v.findViewById(R.id.ListType);
            description = v.findViewById(R.id.ListDescription);
        }

        @Override
        public void onClick(View view){
            mListener.onClick(view, getAdapterPosition());
        }
    }
    @Override
    public GamesAdapter.GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_list, parent, false);
        return new GamesViewHolder(v, mListener);
    }
    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position){
        Games games = mGames.get(position);
        holder.name.setText(games.getName());
        holder.type.setText(games.getType());
        holder.description.setText(games.getDescription());
    }
    @Override
    public int getItemCount() {
        return mGames.size();
    }
}
