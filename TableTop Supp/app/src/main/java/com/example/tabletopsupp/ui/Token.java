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
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;


public class Token extends Fragment {
    private String Document = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private TextView name, race, lvl, lvlC, classP, str, dex;
    private int Smod, Dmod;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_token, container, false);
        name = view.findViewById(R.id.playerName);
        race = view.findViewById(R.id.playerRace);
        lvl = view.findViewById(R.id.lvlPlayer);
        lvlC = view.findViewById(R.id.lvlClass);
        classP = view.findViewById(R.id.classPlayer);
        str = view.findViewById(R.id.strenghP);
        dex = view.findViewById(R.id.dexP);



        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {

            Document = extras.getString("adventure");

        }
        loadUtilities();

        return view;
    }

    public void loadUtilities(){

        db.collection("tables").document(Document).collection("players").document(user)
                .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                        String  namePlayer, racePlayer, classPlayer;

                        namePlayer = value.get("playerName").toString();
                        racePlayer = value.get("playerRace").toString();
                        classPlayer = value.get("playerClass").toString();
                       lvl.setText(value.get("playerLevel").toString());
                       lvlC.setText(value.get("playerLevel").toString());
                        tittle(namePlayer, racePlayer, classPlayer);
                    }
                });
    }

    public void tittle(String namePlay, String racePlay, String classPlay){

        name.setText(namePlay);
        race.setText(racePlay);
        classP.setText(classPlay);

        db.collection("tables").document(Document).collection("players").document(user)
                .collection("Token").document(namePlay).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                String supp;

                supp = value.get("strenght").toString();
                str.setText(value.get("strenght").toString() +"| "+ modcall(supp));
                supp = value.get("dexterity").toString();
                dex.setText(value.get("dexterity").toString() +"| "+ modcall(supp));

            }
        });
    }

    public String modcall(String mod){
        int modBase, modcalc = 10;
        String back;

        modBase = Integer.valueOf(mod);
        modBase -= modcalc;
        back = String.valueOf(modBase);

        return back;

    }



}