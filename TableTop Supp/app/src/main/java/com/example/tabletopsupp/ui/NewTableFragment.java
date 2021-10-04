package com.example.tabletopsupp.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.activity.GameMasterNavigation;
import com.example.tabletopsupp.model.ItensMaster;
import com.example.tabletopsupp.model.TableMaster;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;


public class NewTableFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    private Spinner spinner;
    private String itemSelected;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText Mname, Aname;
    private Button add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_table, container, false);
        spinner = view.findViewById(R.id.spinner);
        Mname = view.findViewById(R.id.masterName);
        Aname = view.findViewById(R.id.adventureName);
        add = view.findViewById(R.id.addNewTable);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.system, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        AddData();

        return view;
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

        TableMaster tableMaster = new TableMaster(masterName, tableName, "1", system);


        FirebaseFirestore.getInstance().collection("users").document(user)
                .collection("tables")
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
                Intent intent = new Intent(getContext(), GameMasterNavigation.class);
                String empty = "";
                Mname.setText(empty);
                Aname.setText(empty);
            }
        });

    }


}