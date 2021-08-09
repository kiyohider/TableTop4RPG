package com.example.tabletopsupp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.adapter.AdapterTables;
import com.example.tabletopsupp.model.TableMaster;

import java.util.ArrayList;
import java.util.List;

public class TablesFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<TableMaster> tableList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tables, container, false);

        recyclerView = view.findViewById(R.id.recyclerTablesGM);

        this.makeTables();

        AdapterTables adapterTables = new AdapterTables(tableList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterTables);
        return view;
    }

    public void makeTables(){
        TableMaster tables = new TableMaster("kiyohide", "zenodia", "5");
        this.tableList.add(tables);

        tables = new TableMaster("jao", "xitauri", "5");
        this.tableList.add(tables);

        tables = new TableMaster("jonne", "horda", "5");
        this.tableList.add(tables);

        tables = new TableMaster("zed", "alliance", "5");
        this.tableList.add(tables);

        tables = new TableMaster("lola", "bicotinico", "5");
        this.tableList.add(tables);

    }

}