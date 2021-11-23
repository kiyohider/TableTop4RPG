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
import com.example.tabletopsupp.activity.NewTable;
import com.example.tabletopsupp.activity.Table_Navigation;
import com.example.tabletopsupp.adapter.AdapterTables;
import com.example.tabletopsupp.model.TableMaster;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TablesFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<TableMaster> tableList = new ArrayList<>();
    private AdapterTables.RecyclerViewClickListener listener;
    private FloatingActionButton floatingActionButton;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Query query;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tables, container, false);
        recyclerView = view.findViewById(R.id.recyclerTablesGM);
        floatingActionButton = view.findViewById(R.id.addTable);

        setAdapterItems();
        loadUtilities();
        addItem();
        return view;
    }

    public void loadUtilities() {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        query = db.collection("tables").whereEqualTo("master", user).orderBy("adventureName");

                query.addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("teste", error.getMessage());
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
                Intent intent = new Intent(getContext(), NewTable.class);
                startActivity(intent);
            }
        });
    }

    private void setAdapterItems() {
        setOnClickListener();
        AdapterTables adapterTables = new AdapterTables(tableList,listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterTables);
    }

    private void setOnClickListener() {
        listener = new AdapterTables.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), Table_Navigation.class);
                intent.putExtra("name",tableList.get(position).getAdventureName());
                startActivity(intent);
            }
        };
    }
}