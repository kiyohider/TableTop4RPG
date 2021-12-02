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
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterItens extends RecyclerView.Adapter<AdapterItens.MyViewHolder> {
    private List<ItensMaster> itensList;
    private RecyclerViewClickListener listener;

    public AdapterItens(List<ItensMaster> items, RecyclerViewClickListener listener) {

        this.itensList = items;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_itens, parent, false);

        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItensMaster itemsMaster = itensList.get(position);
        holder.itemName.setText((itemsMaster.getItemName()));
        Picasso.get()
                .load(itemsMaster.getItemPhoto())
                .into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return itensList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }
}