package com.example.tabletopsupp.playerCreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.activity.PlayerNavigation;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.jar.Attributes;

public class CreationStep03 extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CheckBox bullying, intuition, identifyMagic, initiative, cheat, stealth, cure, diplomacy, ride, knowledge, stunt,
            trainAnimals, perception, survival, getInformation, craft, gambling, thieving, athletics, acting, fortitude, war
            , fight, aim, reflexes, investigation, mysticism, nobility, piloting, religion, will;
    private int checkCount = 0;
    private Count check = new Count();
    private int skillRace, skillClass;
    private String NameClass, adventure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_step03);
        bullying = findViewById(R.id.bullying);
        intuition = findViewById(R.id.intuition);
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
        craft = findViewById(R.id.craft);
        gambling = findViewById(R.id.gambling);
        thieving = findViewById(R.id.thieving);
        athletics = findViewById(R.id.athletics);
        acting = findViewById(R.id.acting);
        fortitude = findViewById(R.id.fortitude);
        war = findViewById(R.id.war);
        fight = findViewById(R.id.fight);
        aim = findViewById(R.id.aim);
        mysticism = findViewById(R.id.mysticism);
        nobility = findViewById(R.id.nobility);
        piloting = findViewById(R.id.piloting);
        religion = findViewById(R.id.religion);
        reflexes = findViewById(R.id.reflexes);
        investigation = findViewById(R.id.investigation);
        will = findViewById(R.id.will);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            skillRace = extras.getInt("skillsR");
            skillClass = extras.getInt("skillsC");
            NameClass = extras.getString("classes");
            adventure = extras.getString("adventure");

            checkCount= skillClass - 1;
            defineClass(NameClass);
        }





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


    public void countBox( View view){

        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.acting:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
            else
                    checkCount +=1;
                break;

            case R.id.aim:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
            else

                    checkCount +=1;
                break;

            case R.id.athletics:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.trainAnimals:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.war:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.ride:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.bullying:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.investigation:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.intuition:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.stealth:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.survival:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.cheat:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.initiative:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.cure:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.diplomacy:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.knowledge:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.stunt:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.perception:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.nobility:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.craft:
                if (checked ){
                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.gambling:
                if (checked ){
                    if(checkCount > 0){

                        checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.thieving:
                if (checked ){
                    if(checkCount > 0){

                        checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.fortitude:
                if (checked){
                    if(checkCount > 0){

                        checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.reflexes:
                if (checked){

                    if(checkCount > 0){

                    checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else

                    checkCount +=1;
                Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                break;

            case R.id.mysticism:
                if (checked){
                    if(checkCount > 0){

                        checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.piloting:
                if (checked){
                    if(checkCount > 0){

                        checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.religion:
                if (checked){
                    if(checkCount > 0){

                        checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.will:
                if (checked){
                    if(checkCount > 0){

                        checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else
                    checkCount +=1;
                break;

            case R.id.fight:
                if (checked){
                    if(checkCount > 0){

                        checkCount -= 1;
                        Toast.makeText(this, String.valueOf(checkCount), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        disable();
                    }
                }
                else

                    checkCount +=1;
                break;
        }
    }

    public void disable(){
        trainAnimals.setEnabled(false);
        athletics.setEnabled(false);
        ride.setEnabled(false);
        war.setEnabled(false);
        initiative.setEnabled(false);
        bullying.setEnabled(false);
        fight.setEnabled(false);
        craft.setEnabled(false);
        perception.setEnabled(false);
        aim.setEnabled(false);
        reflexes.setEnabled(false);
    }

    public void print(View view) {

        Intent intent = new Intent(getApplicationContext(), PlayerNavigation.class);
        intent.putExtra("adventure",adventure);
        startActivity(intent);
        finish();
    }

}