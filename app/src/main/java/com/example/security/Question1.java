package com.example.security;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Question1 extends AppCompatActivity {
    RadioGroup reponse_radiogroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        reponse_radiogroup = (RadioGroup) findViewById(R.id.reponse_radiogroup);
    }
    public void OnclickAnswer(View view){
        int reponseId = reponse_radiogroup.getCheckedRadioButtonId();

        RadioButton reponse_rb = (RadioButton) findViewById(reponseId);
        String reponse_str = reponse_rb.getText().toString();
        if(reponse_str.equals("Oui")){
            ScoreNumber.setScoreNumber(ScoreNumber.getScoreNumber()+1);
        }
        Intent intent = new Intent(this,Score.class);
        startActivity(intent);
    }
}
