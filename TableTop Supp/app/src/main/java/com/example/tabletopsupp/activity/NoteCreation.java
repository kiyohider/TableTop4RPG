package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.ItensMaster;
import com.example.tabletopsupp.model.NotesMaster;
import com.example.tabletopsupp.model.TableMaster;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class NoteCreation extends AppCompatActivity {
    private  String document = "";
    private EditText tittle, body;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_creation);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            document = extras.getString("name");
        }

        tittle = findViewById(R.id.noteHead);
        body = findViewById(R.id.noteBody);
    }
    private void saveUserStore() {
        String noteName = tittle.getText().toString();
        String noteText = body.getText().toString();

        NotesMaster notesMaster = new NotesMaster(noteName, noteText);

        db.collection("tables").document(document)
                .collection("notes").document(noteName)
                .set(notesMaster)
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
    }

    public void uploadNote(View view) {
        saveUserStore();
        Intent intent = new Intent(getApplicationContext(), Table_Navigation.class);
        intent.putExtra("name",document);
        startActivity(intent);
        finish();
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