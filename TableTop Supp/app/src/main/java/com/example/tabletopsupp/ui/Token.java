package com.example.tabletopsupp.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabletopsupp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;


public class Token extends Fragment {
    private String Document = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TextView name,race;
    private String nameP ="", raceP ="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_token, container, false);
        name = view.findViewById(R.id.playerName);
        race = view.findViewById(R.id.playerRace);


        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {

            Document = extras.getString("adventure");

        }
        loadUtilities();

        return view;
    }

    public void loadUtilities(){
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        db.collection("tables").document(Document).collection("players").document(user)
                .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                        name.setText(value.get("playerName").toString());
                       race.setText(value.get("playerRace").toString());


                    }
                });


    }
}