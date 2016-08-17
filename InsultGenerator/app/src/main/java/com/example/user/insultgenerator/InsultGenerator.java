package com.example.user.insultgenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

/**
 * Created by user on 16/08/2016.
 */
public class InsultGenerator extends AppCompatActivity {
    Button mMild;
    Button mMod;
    Button mMean;
    Button mNice;
    EditText mName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMild =(Button)findViewById(R.id.mild);
        mMod =(Button)findViewById(R.id.mod);
        mMean =(Button)findViewById(R.id.mean);
        mNice =(Button)findViewById(R.id.nice);
        mName =(EditText)findViewById(R.id.nameField);


        mMild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = mName.getText().toString();
                getInsult("mild");
            }
        });
        mMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = mName.getText().toString();
                getInsult("mod");
            }
        });
        mMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = mName.getText().toString();
                getInsult("mean");
            }
        });
        mNice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = mName.getText().toString();
                getInsult("nice");
            }
        });
    }

    public void getInsult(String level){
        String insult;


        if(level == "mild"){
           insult = mild();
        }else if(level == "mod"){
            insult = mod();
        }else if(level =="mean"){
            insult = mean();
        }else{
            insult = nice();
        }


        Log.d("insult", insult);
        Intent intent = new Intent(this, Insulter.class);
        intent.putExtra("insult", insult);
        intent.putExtra("name", name);
        startActivity(intent);
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
        String[] part3 = {"dick","cock","tit","gooch", "bellend","fucknugget"};

        Random rand = new Random();

        String insult = part1[rand.nextInt(part1.length)]+ " " + part2[rand.nextInt(part2.length)] + " " + part3[rand.nextInt(part3.length)];
        return insult;
    }

    public String nice() {
        String[] part1 = {"off","yourself","a duck"};

        Random rand = new Random();

        String insult = "can fuck " + part1[rand.nextInt(part1.length)]+ ". User, pick a proper insult.";
        return insult;
    }
}
