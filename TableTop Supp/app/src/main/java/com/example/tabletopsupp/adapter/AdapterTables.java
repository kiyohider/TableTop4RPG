package com.example.tabletopsupp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.TableMaster;

import java.util.List;

public class AdapterTables extends RecyclerView.Adapter<AdapterTables.MyViewHolder> {
    private List<TableMaster> tablesList;

    public AdapterTables(List<TableMaster> tables) {

        this.tablesList = tables;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemTableList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_tables, parent, false);

        return new MyViewHolder(itemTableList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        TableMaster tableMaster = tablesList.get(position);
        holder.tableName.setText(tableMaster.getAdventureName());
        holder.masterName.setText(tableMaster.getmasterName());
        holder.number.setText(tableMaster.getPlayNumber());
        holder.systemName.setText(tableMaster.getSystemName());

    }
    public void clear() {
        int size = tablesList.size();
        tablesList.clear();
        notifyItemRangeRemoved(0, size);
    }
    @Override
    public int getItemCount() {

        return tablesList.size();
    }


    public  class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tableName;
        TextView masterName;
        TextView number;
        TextView systemName;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            tableName = itemView.findViewById(R.id.adventureNameTxt);
            masterName = itemView.findViewById(R.id.masterNameTxt);
            number = itemView.findViewById(R.id.playNumberTxt);
            systemName = itemView.findViewById(R.id.systemNameTxt);
        }
    }

}