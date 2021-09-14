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
import com.squareup.picasso.Picasso;

import java.util.List;


public class AdapterItens extends RecyclerView.Adapter<AdapterItens.MyViewHolder>{
    private List<ItensMaster> tablesList;
    private RecyclerViewClickListener listener;

    public AdapterItens(List<ItensMaster> tables, RecyclerViewClickListener listener) {

        this.tablesList = tables;
        this.listener = listener;
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
        Picasso.get()
                .load(itemsMaster.getItemPhoto())
                .into(holder.itemImage);
    }

    @Override
    public int getItemCount() {

        return tablesList.size();
    }


    public  class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView itemName;
        ImageView itemImage;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            itemName = itemView.findViewById(R.id.itemNameTxt);
            itemImage = itemView.findViewById(R.id.itemImage);

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