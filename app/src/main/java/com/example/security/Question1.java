package com.example.security;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.security.entity.Question;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Question1 extends AppCompatActivity {
    //Model :
   private ArrayList<Question> questions = new ArrayList<>();
   //initialization of the model
    {
        questions.add(new Question(R.string.question1,true));
        questions.add(new Question(R.string.question2,true));
        questions.add(new Question(R.string.question3,false));
        questions.add(new Question(R.string.question4,false));
        questions.add(new Question(R.string.question5,true));
        questions.add(new Question(R.string.question6,true));
        questions.add(new Question(R.string.question7,false));
        questions.add(new Question(R.string.question8,false));
        questions.add(new Question(R.string.question9,true));
        questions.add(new Question(R.string.question10,false));
    }
   private  RadioGroup reponse_radiogroup;
    private TextView tvQuestion;
    private ProgressBar progressBar;
    private TextView tvProgress;
    private int index ;
    private int score = 0;
    private final int PROGRESS_BY_Q = (int) 100 / questions.size() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        //assigning values to the views :
        tvQuestion = (TextView) findViewById(R.id.question_tv);
        tvProgress = (TextView) findViewById(R.id.tvProgress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        reponse_radiogroup = (RadioGroup) findViewById(R.id.reponse_radiogroup);
    }
    public void OnclickAnswer(View view){
        AtomicReference<Boolean> userAnswer= new AtomicReference<>(false);

        int reponseId = reponse_radiogroup.getCheckedRadioButtonId();

            RadioButton reponse_rb = (RadioButton) findViewById(reponseId);

        String reponse_str = reponse_rb.getText().toString();

        if(reponse_str.equals("Vrai")){
           userAnswer.set(true);
        }
        reponse_rb.clearFocus();
        checkAnswer(userAnswer.get());
        updateQuestion();
        if (index >= questions.size()) {
            Intent intent = new Intent(this,Score.class);
            startActivity(intent);
        }

    }

    private void updateQuestion(){
        tvQuestion.setText(questions.get(index++).getIdQuestion());
        tvProgress.setText(index +"/"+questions.size());
        progressBar.incrementProgressBy(PROGRESS_BY_Q);
    }
    private void checkAnswer(Boolean b){
        if (b == questions.get(index).getAnswer()) {
            ScoreNumber.setScoreNumber(++score);
            Toast.makeText(this, "Bien Jouer !!",
                    Toast.LENGTH_SHORT).show();
            Log.d("Question1","Your score : "+ScoreNumber.getScoreNumber());
        }
        else {
            Toast.makeText(this, "Incorrecte :(",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickExit(View view) {
        finish();
    }
}
