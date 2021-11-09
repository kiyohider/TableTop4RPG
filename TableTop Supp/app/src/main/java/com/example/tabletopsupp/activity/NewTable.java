package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.TableMaster;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

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


        FirebaseFirestore.getInstance().collection("tables")
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


    }




    public void AddData() {


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserStore();
                Intent intent = new Intent(getApplicationContext(), GameMasterNavigation.class);
                startActivity(intent);
                finish();
            }
        });

    }

}