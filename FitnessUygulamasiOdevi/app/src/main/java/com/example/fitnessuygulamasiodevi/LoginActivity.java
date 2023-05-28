package com.example.fitnessuygulamasiodevi;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail,edSifre;
    private Button btngiris;

    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail=findViewById(R.id.edgirisEmail);
        edSifre=findViewById(R.id.edgirisSifre);
        btngiris=findViewById(R.id.btngirisYap);
        mAuth=FirebaseAuth.getInstance();

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=edEmail.getText().toString();
                String sifre =edSifre.getText().toString();

                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(sifre)){
                    mAuth.signInWithEmailAndPassword(email,sifre)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    Toast.makeText(LoginActivity.this, "Giriş Yapıldı!", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(LoginActivity.this,AnaActivity.class);
                                    startActivity(intent);
                                }
                            });

                }else {
                    Toast.makeText(LoginActivity.this, "Email veya Şifre boş bırakılamaz!", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}