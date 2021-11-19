package com.example.tabletopsupp.playerCreation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.tabletopsupp.R;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreationStep03 extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CheckBox bullying, intuition, identifyMagic, initiative, cheat, stealth, cure, diplomacy, ride, knowledge, stunt,
            trainAnimals, perception, survival, getInformation, craft, gambling, thieving, athletics, acting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_step03);
        bullying = findViewById(R.id.bullying);
        intuition = findViewById(R.id.intuition);
        identifyMagic = findViewById(R.id.identifyMagic);
        initiative = findViewById(R.id.initiative);
        cheat = findViewById(R.id.cheat);
        stealth = findViewById(R.id.stealth);
        cure = findViewById(R.id.cure);
        diplomacy = findViewById(R.id.diplomacy);
        ride = findViewById(R.id.ride);
        knowledge = findViewById(R.id.knowledge);
        stunt = findViewById(R.id.stunt);
        trainAnimals = findViewById(R.id.trainAnimals);
        perception = findViewById(R.id.perception);
        survival = findViewById(R.id.survival);
        getInformation = findViewById(R.id.getInformation);
        craft = findViewById(R.id.craft);
        gambling = findViewById(R.id.gambling);
        thieving = findViewById(R.id.thieving);
        athletics = findViewById(R.id.athletics);
        acting = findViewById(R.id.acting);

    }
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        int cont = 0;




    }
}