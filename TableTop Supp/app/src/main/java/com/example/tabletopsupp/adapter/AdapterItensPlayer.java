package com.example.tabletopsupp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.ItensPlayer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterItensPlayer extends RecyclerView.Adapter<AdapterItensPlayer.MyViewHolder>{
    private List<ItensPlayer> itensPlayerListList;
    private RecyclerViewClickListener listener;

    public AdapterItensPlayer(List<ItensPlayer> itens, RecyclerViewClickListener listener) {

        this.itensPlayerListList = itens;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemPlayerList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_iten_player, parent, false);

        return new MyViewHolder(itemPlayerList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItensPlayer itensPlayer = itensPlayerListList.get(position);
        holder.itemName.setText((itensPlayer.getItemName()));
        holder.itemCount.setText(itensPlayer.getItemCont());
        holder.itemWeight.setText(itensPlayer.getItemWeigth());
    }

    @Override
    public int getItemCount() {
        return itensPlayerListList.size();
    }



    public  class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView itemName;
        TextView itemCount;
        TextView itemWeight;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemNamePlayer);
            itemCount = itemView.findViewById(R.id.ItemContPlayer);
            itemWeight = itemView.findViewById(R.id.itemWeightPlayer);


            itemView.setOnClickListener(this);
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
