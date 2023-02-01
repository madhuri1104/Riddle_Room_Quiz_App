package com.example.riddleroom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ScienceActivity extends AppCompatActivity {


    //QuesAndAnsAdapter object=new QuesAndAnsAdapter(R.string.question_1,false);
    TextView question;
    TextView qNo;
    TextView score;
    ProgressBar progress;
    int index;
    int ques;

    int score_count=0;



    QuesAndAnsAdapter[] questionBanks=new QuesAndAnsAdapter[]{
            new QuesAndAnsAdapter(R.string.question_11,true),
            new QuesAndAnsAdapter(R.string.question_12,false),
            new QuesAndAnsAdapter(R.string.question_13,true),
            new QuesAndAnsAdapter(R.string.question_14,false),
            new QuesAndAnsAdapter(R.string.question_15,false),
            new QuesAndAnsAdapter(R.string.question_16,false),
            new QuesAndAnsAdapter(R.string.question_17,true),
            new QuesAndAnsAdapter(R.string.question_18,false),
            new  QuesAndAnsAdapter(R.string.question_19,false),
            new QuesAndAnsAdapter(R.string.question_20,true)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        getSupportActionBar().hide();

        qNo=findViewById(R.id.questionNumber);
        question=findViewById(R.id.questions);
        score=findViewById(R.id.scores);
        progress=findViewById(R.id.progressBar2);


        ques=questionBanks[index].getQue();
        question.setText(ques);


    }

    public void pressTrue(View view){
        check_answer(true);
        update_screen();
    }


    public void pressFalse(View view){
        check_answer(false);
        update_screen();
    }

    public void update_screen(){
        index = (index + 1);
        //ans
        score.setText("Score "+score_count+"/10");
        progress.incrementProgressBy(10);
        if(index<10){
            //qno
            qNo.setText("Q "+(index+1)+"/10");

            //que
            ques = questionBanks[index].getQue();
            question.setText(ques);


        }
        else{

            AlertDialog.Builder myAlertDialog=new AlertDialog.Builder(this);

            myAlertDialog.setTitle("You are at the end of the quiz");
            myAlertDialog.setCancelable(false);
            myAlertDialog.setMessage("View Your Score "+score_count+" points");

            myAlertDialog.setPositiveButton("Play Next Quiz ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            myAlertDialog.show();

        }

    }

    public void check_answer(boolean userInput){  //true
        boolean correctAns=questionBanks[index].isAns(); //index 3- false
        if(userInput==correctAns){ //true==false
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
            score_count=score_count+1;
        }
        else{
            Toast.makeText(this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
        }
    }


//    QuesAndAnsAdapter object=new QuesAndAnsAdapter(R.string.question_1,false);
//   QuesAndAnsAdapter object1=new QuesAndAnsAdapter(R.string.question_2,true);
//    QuesAndAnsAdapter object2=new QuesAndAnsAdapter(R.string.question_3,true);
//    QuesAndAnsAdapter object3=new QuesAndAnsAdapter(R.string.question_4,true);
//    QuesAndAnsAdapter object4=new QuesAndAnsAdapter(R.string.question_5,true);
}