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
import com.example.tabletopsupp.activity.GameMasterTokenNavigation;
import com.example.tabletopsupp.activity.InvitePlayers;
import com.example.tabletopsupp.adapter.AdapterPlayer;
import com.example.tabletopsupp.model.PlayersMaster;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class PlayersFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdapterPlayer.RecyclerViewClickListener listener;
    private List<PlayersMaster> playersList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private String Document = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<String> UIDplayer = new ArrayList<>();
    private int i = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, container, false);
        floatingActionButton = view.findViewById(R.id.addPlayer);
        recyclerView = view.findViewById(R.id.recyclerTablesPlayers);

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            Document = extras.getString("name");
        }

        loadUtilities();
        addPlayer();
        setAdapterItems();

        return view;
    }

    public void loadUtilities() {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        db.collection("tables").document(Document).collection("players")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("teste", error.getMessage());
                            return;
                        }
                        List<DocumentSnapshot> docs = value.getDocuments();
                        for (int i = 0; i < docs.size(); i++) {
                            String pName = docs.get(i).get("playerName").toString();
                            String pRace = docs.get(i).get("playerRace").toString();
                            String pClass = docs.get(i).get("playerClass").toString();
                            String pLevel = docs.get(i).get("playerLevel").toString();
                            String uid = docs.get(i).get("uid").toString();

                            makeItems(pName, pRace, pClass, pLevel, uid);
                        }
                    }
                });
    }

    public void makeItems(String name, String race, String Class, String level, String uid) {
        PlayersMaster playersMaster = new PlayersMaster(name, race, Class, level, uid);
        this.playersList.add(playersMaster);
    }

    public void addPlayer() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), InvitePlayers.class);
                intent.putExtra("name", Document);
                startActivity(intent);
            }
        });
    }

    private void setAdapterItems() {
        setOnClickListener();
        AdapterPlayer adapterPlayer = new AdapterPlayer(playersList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterPlayer);
    }


    private void setOnClickListener() {
        listener = new AdapterPlayer.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), GameMasterTokenNavigation.class);
                intent.putExtra("name", Document);
                intent.putExtra("uid", playersList.get(position).getUid());
                startActivity(intent);
            }
        };
    }
}