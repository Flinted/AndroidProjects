package com.example.user.eightball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by user on 16/08/2016.
 */
public class AnswerActivity extends AppCompatActivity {
    TextView mAnswerText;
    TextView mQuestionText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Log.d("Eightball", "answer activity created");
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String answer= extras.getString("answer");
        String question= extras.getString("question");
        mQuestionText = (TextView) findViewById(R.id.question_text);
        mAnswerText = (TextView) findViewById(R.id.answer_text);
        mQuestionText.setText("You asked: '"+question+"',");
        mAnswerText.setText("Computer says.. '" + answer +"'");
    }
}
