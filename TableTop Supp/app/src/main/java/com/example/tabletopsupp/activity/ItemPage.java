package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabletopsupp.R;
import com.squareup.picasso.Picasso;

public class ItemPage extends AppCompatActivity {
    private TextView tittleI, descriptionI, weigthI;
    private ImageView photoI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        tittleI = findViewById(R.id.loadTittleItem);
        descriptionI = findViewById(R.id.loadItemDescription);
        weigthI = findViewById(R.id.loadItemWeigth);
        photoI = findViewById(R.id.loadImageItem);

        String tittle = "";
        String description = "";
        int weigth = 0;
        String photo = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tittle = extras.getString("tittle");
            description = extras.getString("description");
            weigth = extras.getInt("weigth");
            photo = extras.getString("photo");
        }

        tittleI.setText(tittle);
        descriptionI.setText(description);
        weigthI.setText(String.valueOf(weigth));
        Picasso.get()
                .load(photo)
                .into(photoI);
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