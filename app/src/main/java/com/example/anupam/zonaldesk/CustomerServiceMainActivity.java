package com.example.anupam.zonaldesk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        recyclerView.setNestedScrollingEnabled(false);
        List<item> mlist = new ArrayList<>();
        mlist.add(new item(R.drawable.socialservice,"Social care",R.drawable.logo,20));
        mlist.add(new item(R.drawable.educationandtraining,"Education and training",R.drawable.logo,200));
        mlist.add(new item(R.drawable.retail,"Retail service",R.drawable.logo,2));
        mlist.add(new item(R.drawable.healthcare,"Health care",R.drawable.logo,40));
        mlist.add(new item(R.drawable.postal,"Postal and delivery services",R.drawable.logo,50));
        mlist.add(new item(R.drawable.transportation,"Passenger transportation",R.drawable.logo,20));
        mlist.add(new item(R.drawable.emergencyservice,"Emergency services",R.drawable.logo,200));
        mlist.add(new item(R.drawable.businessadvisory,"Business advisory services",R.drawable.logo,2));
        mlist.add(new item(R.drawable.leisureandrecreation,"Leisure and recreation facilities",R.drawable.logo,40));
        mlist.add(new item(R.drawable.financialservice,"Financial services",R.drawable.logo,50));
        Adapter adapter = new Adapter(this,mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}



