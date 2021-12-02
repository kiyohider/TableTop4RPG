package com.example.tabletopsupp.playerCreation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.PlayersMaster;
import com.example.tabletopsupp.model.TokenPlayer;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreationStep02 extends AppCompatActivity {
    private String infoClass, infoRace, name, adventure;
    private EditText strenght, dexterity, constitution, intelligence, wisdom, charisma;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private int skillClass = 0;
    private int skillRace = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_step02);

        strenght = findViewById(R.id.strenght);
        dexterity = findViewById(R.id.dexterity);
        constitution = findViewById(R.id.constitution);
        intelligence = findViewById(R.id.intelligence);
        wisdom = findViewById(R.id.wisdom);
        charisma = findViewById(R.id.charisma);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            adventure = extras.getString("adventure");
            infoClass = extras.getString("class");
            infoRace = extras.getString("race");
            name = extras.getString("name");
            skillRace = extras.getInt("skillR");
            skillClass = extras.getInt("skillC");
        }
    }

    public void nextStep03(View view) {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String strenghtT = strenght.getText().toString();
        String dexterityT = dexterity.getText().toString();
        String constitutionT = constitution.getText().toString();
        String intelligenceT = intelligence.getText().toString();
        String wisdomT = wisdom.getText().toString();
        String charismaT = charisma.getText().toString();

        TokenPlayer token = new TokenPlayer(name, infoRace, infoClass, "1", "1", strenghtT, dexterityT, constitutionT, intelligenceT, wisdomT, charismaT);
        db.collection("tables").document(adventure).collection("players")
                .document(user).collection("Token").document(name).set(token).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("testeuri", e.getMessage());
                    }
                });

        int modInt = Integer.parseInt(intelligenceT) - 10;
        if (modInt > 0) {
            skillClass += modInt;

            Intent intent = new Intent(getApplicationContext(), CreationStep03.class);
            intent.putExtra("skillsR", skillRace);
            intent.putExtra("skillsC", skillClass);
            intent.putExtra("classes", infoClass);
            intent.putExtra("adventure", adventure);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(getApplicationContext(), CreationStep03.class);
            intent.putExtra("skillsR", skillRace);
            intent.putExtra("skillsC", skillClass);
            intent.putExtra("classes", infoClass);
            intent.putExtra("adventure", adventure);
            startActivity(intent);
            finish();
        }
    }
}