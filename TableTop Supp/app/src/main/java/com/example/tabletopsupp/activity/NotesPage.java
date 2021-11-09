package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tabletopsupp.R;

public class NotesPage extends AppCompatActivity {
    private TextView head,body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_page);

        head=findViewById(R.id.noteTittle);
        body=findViewById(R.id.textNote);

        String tittle="";
        String description="";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            tittle = extras.getString("head");
            description = extras.getString("body");
        }

        head.setText(tittle);
        body.setText(description);
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