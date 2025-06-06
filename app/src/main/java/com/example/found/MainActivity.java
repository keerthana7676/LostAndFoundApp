package com.example.found;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnReportLost, btnReportFound, btnViewPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReportLost = findViewById(R.id.btnReportLost);
        btnReportFound = findViewById(R.id.btnReportFound);
        btnViewPosts = findViewById(R.id.btnViewPosts);

        // Open ReportLostActivity
        btnReportLost.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReportLostActivity.class);
            startActivity(intent);
        });

        // Open ReportFoundActivity (Create this just like ReportLostActivity)
        btnReportFound.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReportFoundActivity.class);
            startActivity(intent);
        });

        // Open ViewPostsActivity (to see all lost/found items later)
        btnViewPosts.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewPostsActivity.class);
            startActivity(intent);
        });
    }
}
