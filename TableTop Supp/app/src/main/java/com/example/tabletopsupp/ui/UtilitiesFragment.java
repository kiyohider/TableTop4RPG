package com.example.tabletopsupp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.activity.GameMasterNavigation;
import com.example.tabletopsupp.activity.ItenCreation;
import com.example.tabletopsupp.adapter.AdapterItens;
import com.example.tabletopsupp.adapter.AdapterTables;
import com.example.tabletopsupp.model.ItensMaster;
import com.example.tabletopsupp.model.TableMaster;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class UtilitiesFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ItensMaster> tableList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_utilities, container, false);
        floatingActionButton = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.recyclerTablesItens);

        this.makeItens();
        AdapterItens adapterItens = new AdapterItens(tableList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterItens);

        addIten();
        return view;
    }

    public void addIten() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ItenCreation.class);
                startActivity(intent);
            }
        });

    }
    public void makeItens(){
        ItensMaster itensMaster = new ItensMaster("revolver","chablau",R.drawable._017_11_16_17_03_05,10);
        this.tableList.add(itensMaster);

         itensMaster = new ItensMaster("revolver","chablau",R.drawable._017_11_16_17_03_05,10);
        this.tableList.add(itensMaster);

         itensMaster = new ItensMaster("revolver","chablau",R.drawable._017_11_16_17_03_05,10);
        this.tableList.add(itensMaster);

         itensMaster = new ItensMaster("revolver","chablau",R.drawable._017_11_16_17_03_05,10);
        this.tableList.add(itensMaster);



    }

}