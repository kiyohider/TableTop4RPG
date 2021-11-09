package com.example.tabletopsupp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tabletopsupp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.ShortDynamicLink;

public class InvitePlayers extends AppCompatActivity {

    private TextView inviteCode,inviteAdventure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_players);
        inviteCode = findViewById(R.id.inviteCode);
        inviteAdventure = findViewById(R.id.adventureInvite);

        invite();
    }
    public void invite(){
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String document = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            document = extras.getString("name");
        }
        inviteCode.setText(user);
        inviteAdventure.setText(document);
    }



    public void share(View view) {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String body = "code = " + inviteCode.getText().toString() + "adventure = " + inviteAdventure.getText().toString();
        String sub = "paste in enter new room";
        myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
        myIntent.putExtra(Intent.EXTRA_TEXT,body);
        startActivity(Intent.createChooser(myIntent, "Share Using"));
    }
}