package com.example.tabletopsupp.ui;

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
import com.example.tabletopsupp.adapter.AdapterItensPlayer;
import com.example.tabletopsupp.model.ItensPlayer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class BackpackFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<ItensPlayer> itensPlayerList = new ArrayList<>();
    private AdapterItensPlayer.RecyclerViewClickListener listener;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Query query;
    private String Document = "", uid = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_backpack, container, false);
        recyclerView = view.findViewById(R.id.recyclerItensG);


        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            Document = extras.getString("name");
            uid = extras.getString("uid");
            loadUtilities();
        }
        setAdapterItems();

        return view;
    }


    public void loadUtilities() {

        query = db.collection("tables").document(Document).collection("players").document(uid).collection("inventory");

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.e("teste", error.getMessage());
                    return;
                }

                List<DocumentSnapshot> docs = value.getDocuments();
                for (int i = 0; i < docs.size(); i++) {
                    String Iname = docs.get(i).get("itenName").toString();
                    String Icount = docs.get(i).get("itenCount").toString();
                    String Iweight = docs.get(i).get("itenWeight").toString();

                    makeItems(Iname, Icount, Iweight);
                }


            }
        });
    }


    public void makeItems(String Iname, String Icount, String Iweight) {
        ItensPlayer itensPlayer = new ItensPlayer(Iname, Icount, Iweight);
        this.itensPlayerList.add(itensPlayer);
    }

    private void setAdapterItems() {
        //setOnClickListener();
        AdapterItensPlayer adapterItensPlayer = new AdapterItensPlayer(itensPlayerList,listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterItensPlayer);
    }

   /* private void setOnClickListener() {
        listener = new AdapterTables.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), Table_Navigation.class);
                intent.putExtra("name",itensPlayerList.get(position).getAdventureName());
                startActivity(intent);
            }
        };
    }

    */
}