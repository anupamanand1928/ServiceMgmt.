package com.example.anupam.zonaldesk;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class CustomerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public  void signout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(this,MainActivity.class));
    }
    public void newservice(View view)
    {
        Intent intent = new Intent(this,CustomerServiceMainActivity.class);
        startActivity(intent);
    }

    public void feedback(View view)
    {
        Intent intent = new Intent(this,FeedbackActivity.class);
        startActivity(intent);
    }


}
