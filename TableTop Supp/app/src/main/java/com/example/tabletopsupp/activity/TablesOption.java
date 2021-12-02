package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.adapter.AdapterTables;
import com.example.tabletopsupp.model.TableMaster;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class TablesOption extends AppCompatActivity {

    //  private AdapterTables.RecyclerViewClickListener listener;
    // private RecyclerView recyclerView;
    //  private FloatingActionButton floatingActionButton;
    //  private FirestoreRecyclerAdapter adapter;
    // private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_option);

        /*db = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recyclerTablesGameMaster);
        floatingActionButton = findViewById(R.id.addTables);

        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Query query = db.collection("tables").orderBy("adventureName");

        FirestoreRecyclerOptions<TableMaster> options = new FirestoreRecyclerOptions.Builder<TableMaster>()
                .setQuery(query, TableMaster.class)
                .build();

         adapter = new FirestoreRecyclerAdapter<TableMaster, TableViewHolder>(options) {
            @NonNull
            @Override
            public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_tables, parent, false);

                return new TableViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull TableViewHolder holder, int position, @NonNull TableMaster model) {

                holder.tableName.setText(model.getAdventureName());
                holder.masterName.setText(model.getmasterName());
                holder.number.setText(model.getPlayNumber());
                holder.systemName.setText(model.getSystemName());
            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        //addItem();
        //setAdapterItems();
        */
    }

  /*  public void addItem() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewTable.class);
                startActivity(intent);
            }
        });
    }

    private void setOnClickListener() {
      //  listener = new AdapterTables.RecyclerViewClickListener() {
           // @Override
           // public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), Table_Navigation.class);
             //   intent.putExtra("name",tableList.get(position).getAdventureName());
                startActivity(intent);
        //    }
        };
    //}

    private class TableViewHolder extends  RecyclerView.ViewHolder {

        private TextView tableName;
        private TextView masterName;
        private TextView number;
        private TextView systemName;

        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            tableName = itemView.findViewById(R.id.adventureNameTxt);
            masterName = itemView.findViewById(R.id.masterNameTxt);
            number = itemView.findViewById(R.id.playNumberTxt);
            systemName = itemView.findViewById(R.id.systemNameTxt);
           // itemView.setOnClickListener(this);

        }

    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

   */
}