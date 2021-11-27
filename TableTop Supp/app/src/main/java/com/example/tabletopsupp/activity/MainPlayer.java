package com.example.tabletopsupp.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.adapter.AdapterTables;
import com.example.tabletopsupp.model.TableMaster;
import com.example.tabletopsupp.playerCreation.CreationStep01;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainPlayer extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<TableMaster> tableList = new ArrayList<>();
    private AdapterTables.RecyclerViewClickListener listener;
    private FloatingActionButton floatingActionButton;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_player);

        recyclerView = findViewById(R.id.recyclerTablesP);
        floatingActionButton = findViewById(R.id.enterTable);

        setAdapterItems();
        loadUtilities();
         addItem();

    }

    public void loadUtilities() {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        db.collection("tables").whereEqualTo(user,user)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("teste", error.getMessage());
                            Toast.makeText(MainPlayer.this, "erro", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        List<DocumentSnapshot> docs = value.getDocuments();
                        for (int i = 0; i < docs.size(); i++) {
                            String mName = docs.get(i).get("masterName").toString();
                            String aName = docs.get(i).get("adventureName").toString();
                            String numberPlay = docs.get(i).get("playNumber").toString();
                            String system = docs.get(i).get("systemName").toString();
                            makeItems(mName, aName, numberPlay, system);
                        }
                    }
                });
    }
    public void makeItems(String mName, String aName, String numberPlay, String system) {
        TableMaster tablesMaster = new TableMaster(mName, aName, numberPlay, system);
        this.tableList.add(tablesMaster);
    }

    public void addItem() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewTableEnter.class);
                startActivity(intent);
            }
        });
    }

    private void setAdapterItems() {
        setOnClickListener();
        AdapterTables adapterTables = new AdapterTables(tableList,listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterTables);
    }

    private void setOnClickListener() {
        listener = new AdapterTables.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), PlayerNavigation.class);
                intent.putExtra("adventure",tableList.get(position).getAdventureName());
                startActivity(intent);
            }
        };
    }

}