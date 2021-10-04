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
    private RecyclerViewClickListener listener;

    public AdapterTables(List<TableMaster> tables, RecyclerViewClickListener listener) {

        this.tablesList = tables;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemTableList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_tables, parent, false);

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

    @Override
    public int getItemCount() {

        return tablesList.size();
    }



    public  class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tableName;
        TextView masterName;
        TextView number;
        TextView systemName;


        public MyViewHolder(@NonNull View tableView) {

            super(tableView);

            tableName = tableView.findViewById(R.id.adventureNameTxt);
            masterName = tableView.findViewById(R.id.masterNameTxt);
            number = tableView.findViewById(R.id.playNumberTxt);
            systemName = tableView.findViewById(R.id.systemNameTxt);
            tableView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }

    }
    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

}