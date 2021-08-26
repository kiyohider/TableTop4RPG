package com.example.tabletopsupp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.ItensMaster;
import com.example.tabletopsupp.model.TableMaster;

import java.util.List;

public class AdapterItens extends RecyclerView.Adapter<AdapterItens.MyViewHolder> {
    private List<ItensMaster> tablesList;

    public AdapterItens(List<ItensMaster> tables) {

        this.tablesList = tables;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemTableList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_itens, parent, false);

        return new MyViewHolder(itemTableList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ItensMaster itemsMaster = tablesList.get(position);
        holder.itemName.setText((itemsMaster.getItemName()));
       // holder.itemImage.setImageResource(itemsMaster.getItemPhoto());

    }

    @Override
    public int getItemCount() {

        return tablesList.size();
    }

    public  class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView itemName;
        ImageView itemImage;



        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            itemName = itemView.findViewById(R.id.itemNameTxt);
            itemImage = itemView.findViewById(R.id.itemImage);

        }
    }

}