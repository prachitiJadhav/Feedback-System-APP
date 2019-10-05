package com.prachiti.studentsfeedback;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    TextView tvRegister,tvMember,tvWelcome;
    EditText etUsername,etPassword;
    FirebaseUser user;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPassword=(EditText)findViewById(R.id.etPassword);
        tvMember=(TextView)findViewById(R.id.tvMember);
        etUsername=(EditText)findViewById(R.id.etUsername);
        tvRegister=(TextView) findViewById(R.id.tvRegister);
        tvWelcome=(TextView) findViewById(R.id.tvWelcome);
        btnLogin=(Button)findViewById(R.id.btnLogin);


        firebaseAuth= FirebaseAuth.getInstance();
       // database= FirebaseDatabase.getInstance();
        user=firebaseAuth.getCurrentUser();

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(i);

            }
        });

        if(user!=null){
            Intent i=new Intent(MainActivity.this,WelcomeDrawNavActivity.class);
            startActivity(i);
            finish();



    }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e= etUsername.getText().toString();
                String p=etPassword.getText().toString();


                firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(

                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){


                                    Toast.makeText(MainActivity.this,
                                            "success", Toast.LENGTH_SHORT).show();
                                    Intent i =new Intent(MainActivity.this,WelcomeDrawNavActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "login issue"+
                                            task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
            }
        });


    }
}
