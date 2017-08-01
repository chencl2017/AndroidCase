package com.chenchangli.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton ;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private Question mQuestionBank=new Question[]{
            new Question(R.string.question_ocean,true),
            new Question(R.string.question_mideast,true),
            new Question(R.string.question_america,true),
            new Question(R.string.question_asia,false),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button)findViewById(R.id.next_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              Toast.makeText(QuizActivity.this,R.string.correct_toast, Toast.LENGTH_LONG).show();
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_LONG).show();
            }
        });
    }
}