package com.example.security;

import android.content.Intent;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;

public class LoginActivity extends AppCompatActivity {
    // Déclaration des variable :
    private Button valider_btn;
    private EditText login_et, password_et;
    private TextView creer_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // affectation des objets View :
        valider_btn = (Button) findViewById(R.id.valider_btn);
        login_et = (EditText) findViewById(R.id.login_et);
        password_et = (EditText) findViewById(R.id.password_et);
        creer_tv = (TextView) findViewById(R.id.Creer_tv);
    }

    public void onClickCreateAcount(View view) {
        Intent intent = new Intent(this,Singup.class);
        startActivity(intent);
    }

    public void onClickValider(View view) {
        String pass = password_et.getText().toString();
        String login = login_et.getText().toString();

        if (TextUtils.isEmpty(email)){
            tv_email.setError("Email is Required");
            return;
        }
        if (TextUtils.isEmpty(email)){
            tv_pass.setError("Pass is Required");
            return;
        }

        // authenticate the user

        fAuth.singInWithEmailAndPassword(login, pass).addOnCompleteListner(new OnCompleteListener<AuthResult>(){
            @Override
            public  void onComplete(@NonNull Task<AuthResult> task){

                if(task.isSuccesful()){
                    startActivity(new Intent(getApplicationContext(),Question1.class)) ;

                }
            }
        });

//        if(pass.equals("admin") && login.equals("admin")){
//            Intent intent = new Intent(this, Question1.class);
//            startActivity(intent);
//              }
//        else {
//            Toast.makeText(this, "Password incorrecte !",
//                    Toast.LENGTH_LONG).show();
//            login_et.setText("");
//            password_et.setText("");
//        }
//        System.out.println("login : "+login);
//        System.out.println("Password"+pass);
    }
}
