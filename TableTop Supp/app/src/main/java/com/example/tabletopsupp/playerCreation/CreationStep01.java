package com.example.tabletopsupp.playerCreation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.PlayersMaster;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.base.MoreObjects;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreationStep01 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerR,spinnerC;
    private String itemSelectedR,itemSelectedC;
    RacesDescription descriptionR = new RacesDescription();
    ClassDescription descriptionC = new ClassDescription();
    private EditText descriptionRace, descriptionClass, characterN;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_step01);

        spinnerR = findViewById(R.id.spinnerRace);
        spinnerC = findViewById(R.id.spinnerClass);
        descriptionRace = findViewById(R.id.description);
        descriptionClass = findViewById(R.id.descriptionClass);
        characterN = findViewById(R.id.characterName);


        spinnerRace();
        spinnerClass();



    }

    public void spinnerRace(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.races, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerR.setAdapter(adapter);
        spinnerR.setOnItemSelectedListener(this);
    }
    public void spinnerClass(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categoryies, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerC.setAdapter(adapter);
        spinnerC.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinnerRace){
            itemSelectedR = (String) parent.getItemAtPosition(position);
            descriptionTextR();
        }
       else if(parent.getId() == R.id.spinnerClass){
            itemSelectedC = (String) parent.getItemAtPosition(position);
            descriptionTextC();
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void descriptionTextR(){
        String text = " ";

        if(itemSelectedR.equalsIgnoreCase("human")){
            text = descriptionR.human();
            descriptionRace.setText(text);
        }
        else if(itemSelectedR.equalsIgnoreCase("elf")){
            text = descriptionR.elf();
            descriptionRace.setText(text);
        }
        else{
            text = descriptionR.dwarf();
            descriptionRace.setText(text);
        }
    }

    public void descriptionTextC(){
        String text = " ";

        if(itemSelectedC.equalsIgnoreCase("guerreiro")){
            text = descriptionC.guerreiro();
            descriptionClass.setText(text);
        }
        else if(itemSelectedC.equalsIgnoreCase("ladino")){
            text = descriptionC.ladino();
            descriptionClass.setText(text);
        }
        else{
            text = descriptionC.lutador();
            descriptionClass.setText(text);
        }
    }

    public void create(View view) {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String name = characterN.getText().toString();
        String adventure = "";
        PlayersMaster player = new PlayersMaster(name,itemSelectedR,itemSelectedC,"1");

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            adventure = extras.getString("adventure");
        }

        db.collection("tables").document(adventure).collection("players")
                .document(user).set(player).addOnSuccessListener(new OnSuccessListener<Void>() {
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




        finish();

    }
}