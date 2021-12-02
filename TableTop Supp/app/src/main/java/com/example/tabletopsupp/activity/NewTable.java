package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.TableMaster;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class NewTable extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private String itemSelected;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText Mname, Aname;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_table);
        spinner = findViewById(R.id.spinner);
        Mname = findViewById(R.id.masterName);
        Aname = findViewById(R.id.adventureName);
        add = findViewById(R.id.addNewTable);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.system, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        AddData();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        itemSelected = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void saveUserStore() {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        String masterName = Mname.getText().toString();
        String tableName = Aname.getText().toString();
        String system = itemSelected;

        TableMaster tableMaster = new TableMaster(masterName, tableName, "1", system, user);


        db.collection("tables").document(tableName).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Toast.makeText(NewTable.this, "this adventure exists", Toast.LENGTH_SHORT).show();
                    } else {
                        db.collection("tables")
                                .document(tableName)
                                .set(tableMaster)
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
                        finish();
                    }
                } else {

                }
            }
        });

    }

    public void AddData() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveUserStore();
                //  Intent intent = new Intent(getApplicationContext(), GameMasterNavigation.class);
                //   startActivity(intent);

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