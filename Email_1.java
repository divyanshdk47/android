package com.example.dk47.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class Email_1 extends AppCompatActivity {

    Toolbar toolbar;
    Button b1;
    TextView t7,t6,t5,t4;
    ImageButton i1;
    EditText e1,e2;
    ImageView iv1;
    FirebaseAuth firebaseAuth;
    TextToSpeech t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_1);
        toolbar=(Toolbar)findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" My App ");
        getSupportActionBar().setIcon(R.drawable.logo);
        firebaseAuth=FirebaseAuth.getInstance();
        b1=(Button)findViewById(R.id.button3);
        t4=(TextView) findViewById(R.id.textView4);
        t5=(TextView) findViewById(R.id.textView5);
        t6=(TextView) findViewById(R.id.textView6);
        t7=(TextView) findViewById(R.id.textView7);
        t5.setPaintFlags(t5.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        t6.setPaintFlags(t6.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText2);
        i1=(ImageButton) findViewById(R.id.imageButton2);
        iv1=(ImageView) findViewById(R.id.imageView);

        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t1.setLanguage(Locale.ENGLISH);
                t1.setSpeechRate(0.8f);

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString();
                if (TextUtils.isEmpty(s1)) {
                    e1.setError("fill all");
                    return;

                } else {
                    if (TextUtils.isEmpty(s2)) {
                        e2.setError("fill all");
                        return;
                    }
                }
                final ProgressDialog progressDialog = ProgressDialog.show(Email_1.this, "Logging In", "please wait...", true);
                firebaseAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent j = new Intent(Email_1.this, Continue.class);
                            startActivity(j);
                            finish();
                            Toast.makeText(Email_1.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                            t1.speak("Hello      Welcome", TextToSpeech.QUEUE_FLUSH, null);
                        } else {
                            Toast.makeText(Email_1.this, "Mismatch", Toast.LENGTH_SHORT).show();
                                                  progressDialog.dismiss();
                        }
                    }

                });
            }
        });

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Email_1.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Email_1.this, Phone_1.class);
                startActivity(k);
                finish();
            }
        });
    }
}
