package com.example.anupam.zonaldesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ServiceViewActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_view);

        img = (ImageView) findViewById(R.id.serviceimage);

        // Recieve data
        Intent intent = getIntent();
        int image = intent.getExtras().getInt("background") ;

        // Setting values
        img.setImageResource(image);
    }
}
