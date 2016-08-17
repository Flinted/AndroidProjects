package com.example.user.eightball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by user on 16/08/2016.
 */
public class Eightball extends AppCompatActivity {
    EditText mQuestionEditText;
    Button mShakeButton;
    ArrayList<String> answers = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answers.add("Yep");
        answers.add("Nope");
        answers.add("Maybe");
        answers.add("Probably");
        answers.add("No Chance");
        answers.add("Ask Again");

        mQuestionEditText = (EditText) findViewById(R.id.question_text);
        mShakeButton = (Button) findViewById(R.id.shake_button);


        mShakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = mQuestionEditText.getText().toString();
                Log.d("Eightball", "CLICKED");
                Log.d("question", "The question asked was '" + question + "'");
                String answer = getAnswer();

                Intent intent = new Intent(Eightball.this, AnswerActivity.class);
                intent.putExtra("answer", answer);
                intent.putExtra("question", question);

                startActivity(intent);
            }
        });
    }

        public String getAnswer(){
            Collections.shuffle(answers);
            String response = answers.get(0);
            return response;
    }



}
