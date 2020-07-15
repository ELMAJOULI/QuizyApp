package com.example.security;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;

public class Singup extends AppCompatActivity {

    private TextView tv_email;
    private TextView tv_pass;
    private FirbaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        tv_email = findViewById(R.id.username_et);
        tv_pass = findViewById(R.id.password1_et);
        if (fAuth.getCurrenteUser() != null ){

            startActivity(new Intent(getApplicationContext(),Question1.class)) ;
            finish();
        }

    }

    public void registerFirebase(View view){
        String email = tv_email.getText().toString();
        String pass = tv_pass.getText().toString();

        if (TextUtils.isEmpty(email)){
            tv_email.setError("Email is Required");
            return;
        }
        if (TextUtils.isEmpty(email)){
            tv_pass.setError("Pass is Required");
            return;
        }

        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListner(new on CompleteListner<AuthResult>)(){
            @Override
            public  vod OnComplete(Task<AuthREsult> task){
            startActivity(new Intent(getApplicationContext(),LoginActivity.class)) ;
            }
        }

    }
}
