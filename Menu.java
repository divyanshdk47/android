package com.example.dk47.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Menu extends AppCompatActivity {

    Button torch,wifi,quiz,bt,camera,sos,mp3,calculator;
    TextView menu,back,logout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar=(Toolbar)findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My App");
        getSupportActionBar().setIcon(R.drawable.logo);
        torch=(Button)findViewById(R.id.torch);
        wifi=(Button)findViewById(R.id.wifi);
        quiz=(Button)findViewById(R.id.quiz);
        bt=(Button)findViewById(R.id.bt);
        camera=(Button)findViewById(R.id.camera);
        sos=(Button)findViewById(R.id.sos);
        mp3=(Button)findViewById(R.id.music);
        calculator=(Button)findViewById(R.id.calc);
        menu=(TextView) findViewById(R.id.menutext);
        back=(TextView)findViewById(R.id.back);
        logout=(TextView)findViewById(R.id.include5);

        torch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu.this,torch.class);
                startActivity(i);
                finish();

            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Menu.this,Continue.class);
                startActivity(j);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Menu.this,MainActivity.class);
                startActivity(k);
                finish();
            }
        });
    }
}
