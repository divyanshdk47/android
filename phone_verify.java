package com.example.dk47.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.TimeUnit;

public class phone_verify extends AppCompatActivity {

    EditText e1;
    Button b1;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verify);
        firebaseAuth=FirebaseAuth.getInstance();

        e1=(EditText)findViewById(R.id.verify);
        b1=(Button)findViewById(R.id.otp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=e1.getText().toString();






            }
        });

    }
}
