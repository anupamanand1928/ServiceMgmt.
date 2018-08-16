package com.example.anupam.zonaldesk;

import android.content.Intent;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        getSupportActionBar().hide();
    }

    public void call_record(View view)
    {
        Toast.makeText(getApplicationContext(), "Call Record",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CallRecordActivity.class);
        startActivity(intent);
    }
    public void performance(View view)
    {
        Toast.makeText(getApplicationContext(), "Performance",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, PerformanceActivity.class);
        startActivity(intent);
    }
    public void call_history(View view)
    {
        Toast.makeText(getApplicationContext(), "Call History",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CallHistoryActivity.class);
        startActivity(intent);
    }
    public void key_area(View view)
    {
        Toast.makeText(getApplicationContext(), "Key Area",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, KeyAreaActivity.class);
        startActivity(intent);
    }
    public void feedback(View view)
    {
        Toast.makeText(getApplicationContext(), "Feedback",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }
    public void rating(View view)
    {
        Toast.makeText(getApplicationContext(), "Rating",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }
    public  void signout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(this,MainActivity.class));
    }
}

