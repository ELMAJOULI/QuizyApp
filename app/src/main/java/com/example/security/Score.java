package com.example.security;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.lzyzsd.circleprogress.DonutProgress;

public class Score extends AppCompatActivity {

    private DonutProgress dunot_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        dunot_progress = (DonutProgress) findViewById(R.id.donut_progress);
        Log.d("Question1","Your score : sc "+ScoreNumber.getScoreNumber());
        dunot_progress.setProgress(ScoreNumber.getScoreNumber()*10);

    }

    public void onClickExit(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void onClickRestart(View view) {
        ScoreNumber.setScoreNumber(0);
        Intent intent = new Intent(this,Question1.class);
        startActivity(intent);
    }
}
