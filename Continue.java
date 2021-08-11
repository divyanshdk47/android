package com.example.dk47.myapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Continue extends AppCompatActivity {
    Button b1;
    TextView t1,t2,t3,t4,t5;
    Toolbar toolbar;
    ImageView i1,i2;
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        toolbar=(Toolbar)findViewById(R.id.include2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My App");
        getSupportActionBar().setIcon(R.drawable.logo);
        b1=(Button)findViewById(R.id.conti);
        t1=(TextView)findViewById(R.id.wel);
        t2=(TextView)findViewById(R.id.include3);
        t3=(TextView)findViewById(R.id.include);
        t4=(TextView)findViewById(R.id.by);
        t5=(TextView)findViewById(R.id.success);
        i1=(ImageView)findViewById(R.id.imageView);
        i2=(ImageView)findViewById(R.id.imageView3);
        ib=(ImageButton)findViewById(R.id.imageButton2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Continue.this, Menu.class);
                startActivity(i);
                finish();
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Continue.this, MainActivity.class);
                startActivity(k);
                finish();
            }
        });


    }
}
