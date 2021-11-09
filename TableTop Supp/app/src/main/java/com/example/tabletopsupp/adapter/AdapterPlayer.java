package com.example.tabletopsupp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.PlayersMaster;

import java.util.List;

public class AdapterPlayer extends RecyclerView.Adapter<AdapterPlayer.MyViewHolder>
{
    private List<PlayersMaster> playersList;
    private RecyclerViewClickListener listener;
    public AdapterPlayer(List<PlayersMaster> players, RecyclerViewClickListener listener) {
        this.playersList = players;
        this.listener = listener;
    }

    @Override
    public AdapterPlayer.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View playerTableList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_players, parent, false);

        return new MyViewHolder(playerTableList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PlayersMaster playersMaster = playersList.get(position);
        holder.playerName.setText(playersMaster.getPlayerName());
        holder.playerRace.setText(playersMaster.getPlayerRace());
        holder.playerClass.setText(playersMaster.getPlayerClass());
        holder.playerLevel.setText(playersMaster.getPlayerLevel());
    }

    @Override
    public int getItemCount() {
        return playersList.size();
    }



    public  class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView playerName;
        TextView playerRace;
        TextView playerClass;
        TextView playerLevel;

        public MyViewHolder(@NonNull View playerView) {
            super(playerView);

             playerName = playerView.findViewById(R.id.playerNameTxt);
             playerRace = playerView.findViewById(R.id.playerRaceTxt);
             playerClass = playerView.findViewById(R.id.playerClassTxt);
             playerLevel = playerView.findViewById(R.id.playerLevelTxt);

            playerView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }

    public  interface  RecyclerViewClickListener{
        void onClick(View view, int position);
    }
}
