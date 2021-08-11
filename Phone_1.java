package com.example.dk47.myapp;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Phone_1 extends AppCompatActivity {

    TextView t4,t7,t8;
    Toolbar toolbar;
    EditText e5;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_1);
        toolbar=(Toolbar)findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" My App ");
        getSupportActionBar().setIcon(R.drawable.logo);
        e5=(EditText) findViewById(R.id.editText5);
        t4=(TextView) findViewById(R.id.textView4);
        b1=(Button) findViewById(R.id.button5);
        t7=(TextView) findViewById(R.id.textView7);
        t8=(TextView) findViewById(R.id.textView8);
        t8.setPaintFlags(t8.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Phone_1.this, Email_1.class);
                startActivity(k);
                finish();
            }
        });


        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Phone_1.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Phone_1.this, Continue.class);startActivity(j);
                finish();
            }
        });
    }
}
