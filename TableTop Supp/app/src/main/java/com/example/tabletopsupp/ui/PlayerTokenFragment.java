package com.example.tabletopsupp.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabletopsupp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class PlayerTokenFragment extends Fragment {
    private String Document = "", uid = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private TextView name, race, lvl, lvlC, classP, str, dex, consti, intel, charis, sab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_token, container, false);
        name = view.findViewById(R.id.playerName1);
        race = view.findViewById(R.id.playerRace1);
        lvl = view.findViewById(R.id.lvlPlayer1);
        lvlC = view.findViewById(R.id.lvlClass1);
        classP = view.findViewById(R.id.classPlayer1);
        str = view.findViewById(R.id.strenghP1);
        dex = view.findViewById(R.id.dexP1);
        consti = view.findViewById(R.id.constP1);
        intel = view.findViewById(R.id.intP1);
        charis = view.findViewById(R.id.charP1);
        sab = view.findViewById(R.id.sabP1);

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {

            Document = extras.getString("name");
            uid = extras.getString("uid");
            loadUtilities();
        }

        return view;
    }

    public void loadUtilities(){

        db.collection("tables").document(Document).collection("players").document(uid)
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

        db.collection("tables").document(Document).collection("players").document(uid)
                .collection("Token").document(namePlay).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                String supp;

                supp = value.get("strenght").toString();
                str.setText(value.get("strenght").toString() +"| "+ modcall(supp));
                supp = value.get("dexterity").toString();
                dex.setText(value.get("dexterity").toString() +"| "+ modcall(supp));
                supp = value.get("constitution").toString();
                consti.setText(value.get("constitution").toString() +"| "+ modcall(supp));
                supp = value.get("intelligence").toString();
                intel.setText(value.get("intelligence").toString() +"| "+ modcall(supp));
                supp = value.get("charisma").toString();
                charis.setText(value.get("charisma").toString() +"| "+ modcall(supp));
                supp = value.get("wisdom").toString();
                sab.setText(value.get("wisdom").toString() +"| "+ modcall(supp));

            }
        });
    }

    public String modcall(String mod){
        int modAtt, modBase, modcalc = 10;
        String back;

        modAtt=Integer.valueOf(mod);

        modBase = modAtt - modcalc;
        if(modBase > 0){

            if (modBase != 10){
                modBase = modBase / 2;
            }
        }
        if(modBase < 0){

            if(modAtt % 2 == 0 ){
                modBase = modBase / 2;
            }
            else{
                modBase = modBase / 2 - 1;
            }
        }

        back = String.valueOf(modBase);

        return back;

    }


}