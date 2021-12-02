package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.tabletopsupp.R;

import com.google.firebase.auth.FirebaseAuth;

public class InvitePlayers extends AppCompatActivity {
    private String document = "";
    private TextView inviteAdventure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_players);
        inviteAdventure = findViewById(R.id.adventureInvite);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            document = extras.getString("name");
        }

        invite();
    }

    public void invite() {
        inviteAdventure.setText(document);
    }

    public void share(View view) {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String body = " adventure = " + inviteAdventure.getText().toString();
        String sub = "paste in enter new room";
        myIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
        myIntent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(myIntent, "Share Using"));
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