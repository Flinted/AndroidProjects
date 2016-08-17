package com.example.user.insultgenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by user on 16/08/2016.
 */
public class Insulter extends AppCompatActivity {
    TextView mInsulter;
    Button mMild;
    Button mMod;
    Button mMean;
    Button mNice;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insult);
        mInsulter = (TextView)findViewById(R.id.insulter);
        mMild =(Button)findViewById(R.id.mild);
        mMod =(Button)findViewById(R.id.mod);
        mMean =(Button)findViewById(R.id.mean);
        mNice=(Button)findViewById(R.id.nice);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        name = extras.getString("name");
        String insult = extras.getString("insult");

        if(name.equalsIgnoreCase("Chris")){
            insult = "would think they would know better...";
        }

        String response = "Hey " + name + ", you " + insult;
        mInsulter.setText(response);

        mMild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reInsult("mild");
            }
        });
        mMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reInsult("mod");
            }
        });
        mMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reInsult("mean");
            }
        });

        mNice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reInsult("nice");
            }
        });
    }

    public void reInsult(String level){
        String insult;

        if(level == "mild"){
            insult = mild();
        }else if(level == "mod"){
            insult = mod();
        }else if(level == "mean"){
            insult = mean();
        }else {
            insult = nice();
        }

        if(name.equalsIgnoreCase("Chris")){
            insult = "would think they would know better...";
        }

        String response = "Hey " + name + ", you " + insult;
        mInsulter.setText(response);
    }



    public String mild() {
        String[] part1 = {"tiny","massive","slobbering","smelly","foolish","clumsy"};
        String[] part2 = {"monkey","pixie","emu","bumblebee","alien", "parrot", "eskimo"};
        String[] part3 = {"catcher","chaser","lover","eater","dancer", "cuddler", "surveyor"};

        Random rand = new Random();

        String insult = part1[rand.nextInt(part1.length)]+ " " + part2[rand.nextInt(part2.length)] + " " + part3[rand.nextInt(part3.length)];
        return insult;
    }

    public String mod() {
        String[] part1 = {"fugly","repulsive","colossal","ignorant","miniature","medieval"};
        String[] part2 = {"horse","camel","goldfish", "space","dragon"};
        String[] part3 = {"knob","crap","twat","appendix","pants"};

        Random rand = new Random();

        String insult = part1[rand.nextInt(part1.length)]+ " " + part2[rand.nextInt(part2.length)] + " " + part3[rand.nextInt(part3.length)];
        return insult;
    }

    public String mean() {
        String[] part1 = {"utter","cock","total","absolute", "monumental","contemptible"};
        String[] part2 = {"fucking","cocking","shitting","juggling","farting", "free running", "ass clenching"};
        String[] part3 = {"dick","cock","tit","gooch", "bellend", "fucknugget"};

        Random rand = new Random();

        String insult = part1[rand.nextInt(part1.length)]+ " " + part2[rand.nextInt(part2.length)] + " " + part3[rand.nextInt(part3.length)];
        return insult;
    }

    public String nice() {
        String[] part1 = {"off","yourself","a duck"};

        Random rand = new Random();

        String insult = "can fuck " + part1[rand.nextInt(part1.length)] + ". User, pick a proper insult.";
        return insult;
    }
}
