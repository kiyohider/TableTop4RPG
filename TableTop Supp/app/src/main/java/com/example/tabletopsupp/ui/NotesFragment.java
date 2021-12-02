package com.example.tabletopsupp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.activity.NoteCreation;
import com.example.tabletopsupp.activity.NotePlayerCreation;
import com.example.tabletopsupp.activity.NotesPage;
import com.example.tabletopsupp.adapter.AdapterNotes;
import com.example.tabletopsupp.model.NotesMaster;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class NotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterNotes.RecyclerViewClickListener listener;
    private List<NotesMaster> notesList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private String Document = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        floatingActionButton = view.findViewById(R.id.newNote);
        recyclerView = view.findViewById(R.id.recyclerPlayerNotes);

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            Document = extras.getString("adventure");
        }

        loadUtilities();
        addNotes();
        setAdapterItems();

        return view;
    }

    public void loadUtilities() {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        db.collection("tables").document(Document).collection("players").document(user).collection("notes")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("teste", error.getMessage());
                            return;
                        }
                        List<DocumentSnapshot> docs = value.getDocuments();
                        for (int i = 0; i < docs.size(); i++) {
                            String tittle = docs.get(i).get("noteName").toString();
                            String body = docs.get(i).get("noteText").toString();
                            makeNotes(tittle, body);
                        }
                    }
                });
    }

    public void makeNotes(String name, String text) {
        NotesMaster noteMaster = new NotesMaster(name, text);
        this.notesList.add(noteMaster);
    }

    public void addNotes() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NotePlayerCreation.class);
                intent.putExtra("adventure", Document);
                startActivity(intent);
            }
        });
    }

    private void setAdapterItems() {
        setOnClickListener();
        AdapterNotes adapterNotes = new AdapterNotes(notesList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterNotes);
    }

    private void setOnClickListener() {
        listener = new AdapterNotes.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), NotesPage.class);
                intent.putExtra("head", notesList.get(position).getnoteName());
                intent.putExtra("body", notesList.get(position).getnoteText());
                startActivity(intent);
            }
        };
    }

}