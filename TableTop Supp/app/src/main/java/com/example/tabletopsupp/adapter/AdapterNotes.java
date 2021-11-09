package com.example.tabletopsupp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.NotesMaster;
import com.example.tabletopsupp.model.PlayersMaster;

import java.util.List;

public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.MyViewHolder>
{
    private List<NotesMaster> notesList;
    private RecyclerViewClickListener listener;
    public AdapterNotes(List<NotesMaster> notes, RecyclerViewClickListener listener) {

        this.notesList = notes;
        this.listener = listener;
    }

    @Override
    public AdapterNotes.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View notesTableList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_notes, parent, false);

        return new MyViewHolder(notesTableList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NotesMaster notesMaster = notesList.get(position);
        holder.noteName.setText(notesMaster.getnoteName());
        holder.noteText.setText(notesMaster.getnoteText());


    }

    @Override
    public int getItemCount() {

        return notesList.size();
    }



    public  class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView noteName;
        TextView noteText;


        public MyViewHolder(@NonNull View notesView) {

            super(notesView);

            noteName = notesView.findViewById(R.id.noteTxt);


            notesView.setOnClickListener(this);

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
