package com.example.tabletopsupp.ui;


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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class NewTableFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public void question1from10() {
    }

    private Spinner spinner;
    private String itemSelected;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText Mname, Aname;
    private Button add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_new_table, container, false);
        spinner = rootView.findViewById(R.id.spinner);
        Mname = rootView.findViewById(R.id.masterName);
        Aname = rootView.findViewById(R.id.adventureName);
        add = rootView.findViewById(R.id.addNewTable);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.system, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        AddData();

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        itemSelected = (String) parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void AddData() {


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sucesso = "succes", falha = "failure";
                Map<String, Object> user = new HashMap<>();
                user.put("masterName", Mname.getText());
                user.put("adventureName", Aname.getText());
                user.put("system", itemSelected);

// Add a new document with a generated ID
                db.collection("user")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(sucesso, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(falha, "Error adding document", e);
                            }
                        });

            }
        });

    }


}