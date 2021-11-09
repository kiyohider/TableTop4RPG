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
import com.example.tabletopsupp.model.ItensMaster;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class UtilitiesFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterItens.RecyclerViewClickListener listener;
    private List<ItensMaster> tableList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_utilities, container, false);
        floatingActionButton = view.findViewById(R.id.addItem);
        recyclerView = view.findViewById(R.id.recyclerTablesItems);

        loadUtilities();
        addItem();
        setAdapterItems();
        return view;
    }

    public void loadUtilities(){
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        db.collection("users").document(user).collection("utilites")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Log.e("teste",error.getMessage());
                            return;
                        }
                        List<DocumentSnapshot> docs = value.getDocuments();
                        for (int i = 0;i< docs.size();i++){
                            String photo = docs.get(i).get("itemPhoto").toString();
                            String name = docs.get(i).get("itemName").toString();
                            String description = docs.get(i).get("itemDescription").toString();
                            int weight = docs.get(i).get("itemWeigth").hashCode();
                            makeItems(name, description, photo, weight);
                        }
                    }
                });
    }

    public void makeItems(String name, String description, String photo, int weight){
        ItensMaster itemsMaster = new ItensMaster(name,description,photo,weight);
        this.tableList.add(itemsMaster);
    }

    public void addItem() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ItenCreation.class);
                startActivity(intent);
            }
        });
    }

    private void setAdapterItems(){
        setOnClickListener();
        AdapterItens adapterItems = new AdapterItens(tableList,listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterItems);
    }

    private void setOnClickListener() {
        listener = new AdapterItens.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), ItemPage.class);
                intent.putExtra("tittle",tableList.get(position).getItemName());
                intent.putExtra("description",tableList.get(position).getItemDescription());
                intent.putExtra("photo",tableList.get(position).getItemPhoto());
                intent.putExtra("weigth",tableList.get(position).getItemWeigth());
                startActivity(intent);
            }
        };
    }
}