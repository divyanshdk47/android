package com.example.dk47.myapp;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class torch extends AppCompatActivity {

    ImageButton ib,ib2;
    TextView t1,t2;
    CameraManager cm;
    Toolbar toolbar;
    private boolean flash = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        toolbar=(Toolbar)findViewById(R.id.myToolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My App");
        getSupportActionBar().setIcon(R.drawable.logo);
        ib2 = (ImageButton) findViewById(R.id.torchpic);
        ib = (ImageButton) findViewById(R.id.imageButton2);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        t1 = (TextView) findViewById(R.id.back);
        t2 = (TextView) findViewById(R.id.include4);

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flash == false) {
                    try {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, true);
                        flash = true;
                        ib2.setImageResource(R.drawable.g4);


                    } catch (CameraAccessException e) {
                    }
                }
                else {
                    try {

                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, false);
                        flash = false;
                        ib2.setImageResource(R.drawable.g2);


                    } catch (CameraAccessException e) {
                    }
                }

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(torch.this, Menu.class );
                startActivity(i);
                finish();
            }
        });

    }
}
