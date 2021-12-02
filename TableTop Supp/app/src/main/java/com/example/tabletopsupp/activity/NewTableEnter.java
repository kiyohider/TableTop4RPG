package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.PlayersMaster;
import com.example.tabletopsupp.playerCreation.CreationStep01;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class NewTableEnter extends AppCompatActivity {
    private TextView enterAdventure;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_table_enter);
        enterAdventure = findViewById(R.id.adventureEnter);

    }

    public void enter(View view) {
        String adventure = enterAdventure.getText().toString();
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        PlayersMaster player = new PlayersMaster();

        db.collection("tables").document(adventure).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
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

                        db.collection("tables").document(adventure).update(user, user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
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

                        Intent intent = new Intent(getApplicationContext(), CreationStep01.class);
                        intent.putExtra("adventure", adventure);
                        startActivity(intent);

                        finish();


                    } else {

                        Toast.makeText(NewTableEnter.this, "this adventure  not exists", Toast.LENGTH_SHORT).show();
                    }
                } else {

                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}