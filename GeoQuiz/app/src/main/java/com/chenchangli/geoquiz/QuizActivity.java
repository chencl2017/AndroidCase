package com.chenchangli.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private static final String ACTIVITY_TAG="QuizActivity";
    private Button mTrueButton ;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank=new Question[]{
            new Question(R.string.question_ocean,true),
            new Question(R.string.question_mideast,true),
            new Question(R.string.question_america,true),
            new Question(R.string.question_asia,false),
    };
    private int mCurrentIndex=0;
    private void updateQuestion(){
        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPressTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if(userPressTrue==answerIsTrue){
            messageResId=R.string.correct_toast;
        }else{
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.e(ACTIVITY_TAG,"1111111");
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        Log.e(ACTIVITY_TAG,"222222");
        mTrueButton = (Button) findViewById(R.id.true_button);
        Log.e(ACTIVITY_TAG,"333333");
        mFalseButton = (Button) findViewById(R.id.false_button);
        Log.e(ACTIVITY_TAG,"444444");
        mNextButton = (ImageButton)findViewById(R.id.next_button);
        Log.e(ACTIVITY_TAG,"555555");
        mPrevButton = (ImageButton)findViewById(R.id.priv_button);
        Log.e(ACTIVITY_TAG,"6666666");
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex=(mCurrentIndex+1)% mQuestionBank.length;
                updateQuestion();
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex=mCurrentIndex-1;
                if(mCurrentIndex<0)
                    mCurrentIndex+=mQuestionBank.length;
                updateQuestion();
            }
        });
        updateQuestion();
    }
}
