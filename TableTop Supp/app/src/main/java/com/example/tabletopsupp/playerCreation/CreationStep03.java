package com.example.tabletopsupp.playerCreation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tabletopsupp.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.jar.Attributes;

public class CreationStep03 extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CheckBox bullying, intuition, identifyMagic, initiative, cheat, stealth, cure, diplomacy, ride, knowledge, stunt,
            trainAnimals, perception, survival, getInformation, craft, gambling, thieving, athletics, acting, fortitude, war
            , fight, aim, reflexes;
    private int checkCount = 0;
    private Count check = new Count();
    private int skillRace, skillClass;
    private String NameClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_step03);
        bullying = findViewById(R.id.bullying);
        intuition = findViewById(R.id.intuition);
        identifyMagic = findViewById(R.id.identifyMagic);
        initiative = findViewById(R.id.initiative);
        cheat = findViewById(R.id.cheat);
        stealth = findViewById(R.id.stealth);
        cure = findViewById(R.id.cure);
        diplomacy = findViewById(R.id.diplomacy);
        ride = findViewById(R.id.ride);
        knowledge = findViewById(R.id.knowledge);
        stunt = findViewById(R.id.stunt);
        trainAnimals = findViewById(R.id.trainAnimals);
        perception = findViewById(R.id.perception);
        survival = findViewById(R.id.survival);
        getInformation = findViewById(R.id.getInformation);
        craft = findViewById(R.id.craft);
        gambling = findViewById(R.id.gambling);
        thieving = findViewById(R.id.thieving);
        athletics = findViewById(R.id.athletics);
        acting = findViewById(R.id.acting);
        fortitude = findViewById(R.id.fortitude);
        war = findViewById(R.id.war);
        fight = findViewById(R.id.fight);
        aim = findViewById(R.id.aim);
        reflexes = findViewById(R.id.reflexes);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            skillRace = extras.getInt("skillsR");
            skillClass = extras.getInt("skillsC");
            NameClass = extras.getString("classes");

            checkCount= skillClass;
            defineClass(NameClass);
        }
        //countBox();




    }
    public void defineClass(String define){

        if(define.equalsIgnoreCase("guerreiro")){

            trainAnimals.setEnabled(true);
            athletics.setEnabled(true);
            ride.setEnabled(true);
            war.setEnabled(true);
            initiative.setEnabled(true);
            bullying.setEnabled(true);
            fight.setEnabled(true);
            craft.setEnabled(true);
            perception.setEnabled(true);
            aim.setEnabled(true);
            reflexes.setEnabled(true);


        }
        else if(define.equalsIgnoreCase("ladino")){

        }
        else if(define.equalsIgnoreCase("anão")){

        }

    }

    public void countBox(){


        if(bullying.callOnClick()){
            checkCount += check.checked(checkCount, bullying);
        }
        if (intuition.callOnClick()){
            checkCount += check.checked(checkCount, intuition);
        }
        if (identifyMagic.callOnClick()){
            checkCount += check.checked(checkCount, identifyMagic);
        }

        if (initiative.callOnClick()){
            checkCount += check.checked(checkCount, initiative);
        }
        if (cheat.callOnClick()){
            checkCount += check.checked(checkCount, cheat);
        }
        if (stealth.callOnClick()){
            checkCount += check.checked(checkCount, stealth);
        }
        if (cure.callOnClick()){
            checkCount += check.checked(checkCount, cure);
        }
        else {
            checkCount --;
        }
        if (diplomacy.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (ride.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (knowledge.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (stunt.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (trainAnimals.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (perception.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (survival.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (getInformation.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (craft.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (gambling.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (thieving.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (athletics.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }
        if (acting.isChecked()){
            checkCount ++;
        }
        else {
            checkCount --;
        }







    }
    public void print(View view) {

        Toast.makeText(this, Integer.toString(checkCount), Toast.LENGTH_SHORT).show();
    }
    public void acting(View view) {

        //checkCount += check.checked(checkCount, acting);

    }




}