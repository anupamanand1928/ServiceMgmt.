package com.example.anupam.zonaldesk;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText Username,Password;
    FirebaseAuth firebaseAuth;
    Button Login;
    ProgressBar progressBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = (Button)findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = Username.getEditableText().toString().trim();
                final String password = Password.getEditableText().toString().trim();
                String type = "login";
                boolean result = false;
                if(username.isEmpty()||password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter all the details",Toast.LENGTH_LONG).show();
                }
                else
                {
                    result= true;
                }

        /*BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);*/
                progressBar = (ProgressBar)findViewById(R.id.progress);
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, CustomerActivity.class);
                            startActivity(intent);
                            progressBar.setVisibility(View.GONE);
                            Password.setText("");
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login Failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        /*FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null)
        {
            finish();
            Intent intent = new Intent(this, ManagerActivity.class);
            startActivity(intent);
        }*/

        Username = (EditText) findViewById(R.id.etEmailLayout);
        Password = (EditText) findViewById(R.id.etPasswordLayout);

    }


    public void sign_up(View view)
    {
        /*Toast.makeText(getApplicationContext(), "Sign Up",Toast.LENGTH_LONG).show();*/
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
    public void forgot_password(View view)
    {
        /*Toast.makeText(getApplicationContext(), "Forgot Password",Toast.LENGTH_LONG).show();*/
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }



}
