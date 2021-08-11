package com.example.dk47.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

import java.util.concurrent.TimeUnit;

public class Register_1 extends AppCompatActivity {
    Toolbar toolbar;
    EditText e3,e4,e5,e6;
    Button b1;
    ImageButton i1;
    ImageView iv1;
    TextView t4,t7;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_1);
        toolbar=(Toolbar)findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" My App ");
        getSupportActionBar().setIcon(R.drawable.logo);
        firebaseAuth=FirebaseAuth.getInstance();
        e3=(EditText)findViewById(R.id.name);
        e4=(EditText)findViewById(R.id.email);
        e5=(EditText)findViewById(R.id.phone);
        e6=(EditText)findViewById(R.id.pass);
        b1=(Button) findViewById(R.id.button4);
        i1=(ImageButton) findViewById(R.id.imageButton2);
        iv1=(ImageView) findViewById(R.id.imageView);
        t7=(TextView)findViewById(R.id.textView7);
        t4=(TextView)findViewById(R.id.textView4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e3.getText().toString();
                String s2=e4.getText().toString();
                String s3=e5.getText().toString();
                String s4=e6.getText().toString();
                if (TextUtils.isEmpty(s1)){
                    e3.setError("Fill all");
                    return;

                }
                else{
                    if (TextUtils.isEmpty(s2)){
                        e4.setError("Fill all");
                        return;
                    }
                    else{
                        if (TextUtils.isEmpty(s3)){
                            e5.setError("Fill all");
                            return;
                        }
                        if (s3.length()<10||s3.length()>10){
                            e5.setError("Enter valid format");
                            return;
                        }

                        else{
                            if (TextUtils.isEmpty(s4)){
                                e6.setError("Fill all");
                                return;
                            }
                        }
                    }
                }


                final ProgressDialog progressDialog=ProgressDialog.show(Register_1.this,"Registering","Please Wait",true);
                firebaseAuth.createUserWithEmailAndPassword(s2,s4).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Toast.makeText(Register_1.this, "Registered", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Register_1.this,MainActivity.class);
                            startActivity(i);
                            finish();

                        }
                        else
                        {
                            Toast.makeText(Register_1.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });

            }

        });

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Register_1.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });




    }


}
