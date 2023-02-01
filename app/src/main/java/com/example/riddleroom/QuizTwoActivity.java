package com.example.riddleroom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuizTwoActivity extends AppCompatActivity {

    TextView questionText;
    TextView scoreText;
    ProgressBar progressBar;
    TextView questionNo;

    int mIndex;
    int mQuestion;
    int count=0;

    private QueAnsAdapter[] mQuestionBank=new QueAnsAdapter[]{
            new QueAnsAdapter(R.string.question_1,true),
            new QueAnsAdapter(R.string.question_2,false),
            new QueAnsAdapter(R.string.question_3,true),
            new QueAnsAdapter(R.string.question_4,false),
            new QueAnsAdapter(R.string.question_5,true),
            new QueAnsAdapter(R.string.question_6,false),
            new QueAnsAdapter(R.string.question_7,true),
            new QueAnsAdapter(R.string.question_8,false),
            new QueAnsAdapter(R.string.question_9,true),
            new QueAnsAdapter(R.string.question_10,false)

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_two);


        questionText=findViewById(R.id.question);
        scoreText=findViewById(R.id.score);
        progressBar=findViewById(R.id.progressBar);
        getSupportActionBar().hide();


        mQuestion=mQuestionBank[mIndex].getmQuestionID();
        questionText.setText(mQuestion);
        questionNo=findViewById(R.id.questionNo);
        questionNo.setText("Q "+(mIndex+1)+"/10");

    }

    public void trueButton(View view)
    {
        check_answer(true);
       update_screen();
    }
    public void falseButton(View view)
    {
        check_answer(false);
        update_screen();
    }

    public void update_screen(){

        mIndex=(mIndex+1)%10;
        questionNo.setText("Q "+(mIndex+1)+"/10");
        mQuestion=mQuestionBank[mIndex].getmQuestionID();
        questionText.setText(mQuestion);

        progressBar=findViewById(R.id.progressBar);
        progressBar.incrementProgressBy(10);

        scoreText=findViewById(R.id.score);
        scoreText.setText("Score: "+count+"/10");

        if(mIndex==0){
            AlertDialog.Builder myAlertDialog=new AlertDialog.Builder(this);
            myAlertDialog.setTitle("You are at the end of the quiz!");
            myAlertDialog.setCancelable(false);
            myAlertDialog.setMessage("View Score "+count+" points");
            myAlertDialog.setPositiveButton("Play Next Quiz.", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            myAlertDialog.show();
        }

    }
    public void check_answer(boolean userInput){
        boolean correctAnswer=mQuestionBank[mIndex].ismAnswer();


        if(userInput==correctAnswer){
            count=count+1;
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "InCorrect Answer", Toast.LENGTH_SHORT).show();

        }
    }

    //QueAnsAdapter object=new QueAnsAdapter(R.string.question_1,true);
}