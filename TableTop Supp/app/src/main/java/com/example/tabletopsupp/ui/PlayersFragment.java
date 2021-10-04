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
import com.example.tabletopsupp.activity.ItemPage;
import com.example.tabletopsupp.activity.ItenCreation;
import com.example.tabletopsupp.adapter.AdapterItens;
import com.example.tabletopsupp.adapter.AdapterPlayer;
import com.example.tabletopsupp.model.ItensMaster;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, container, false);
        floatingActionButton = view.findViewById(R.id.addPlayer);
        recyclerView = view.findViewById(R.id.recyclerTablesPlayers);

        loadUtilities();
        addItem();
        setAdapterItems();

        return view;
    }

    private void setAdapterItems() {
       // setOnClickListener();
        AdapterPlayer adapterPlayer = new AdapterPlayer(playersList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterPlayer);
    }

    /*private void setOnClickListener() {
        listener = new AdapterItens.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), ItemPage.class);
                intent.putExtra("tittle", playersList.get(position).getPlayerName());
                intent.putExtra("description", playersList.get(position).getPlayerRace());
                intent.putExtra("photo", playersList.get(position).getPlayerClass());
                intent.putExtra("weigth", playersList.get(position).getPlayerLevel());
                startActivity(intent);
            }
        };
    }*/

    public void addItem() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String document = "";
                Bundle extras = getActivity().getIntent().getExtras();
                if (extras != null){
                    document = extras.getString("name");
                }

                Intent intent = new Intent(getContext(), ItenCreation.class);
                intent.putExtra("name",document);
                startActivity(intent);

            }
        });
    }

    public void loadUtilities(){
        String document = "";
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null){
            document = extras.getString("name");
        }
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseFirestore.getInstance().collection("users").document(user).collection("tables").document(document).collection("players")
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
                            int pLevel = docs.get(i).get("playerLevel").hashCode();

                            makeItems(pName, pRace, pClass, pLevel);


                        }

                    }
                });
    }


    public void makeItems(String name, String race, String Class, int level) {

        PlayersMaster playersMaster = new PlayersMaster(name, race, Class, level);
        this.playersList.add(playersMaster);


    }
}