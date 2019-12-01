package com.example.dbtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Center extends AppCompatActivity {
    private Button inquire;
    private Button inquireboard;
    private Button report;
    private Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        inquire=(Button) findViewById(R.id.inquire);
        inquireboard=(Button)findViewById(R.id.inquireboard);
        report=(Button)findViewById(R.id.report);
        back=(Button)findViewById(R.id.back);

        inquire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=(new Intent(Center.this, WriteActivity.class));
                startActivity(intent);
            }
        });

        inquireboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=(new Intent(Center.this, InquireBoard.class));
                startActivity(intent);
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=(new Intent(Center.this, ReportActivity.class));
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=(new Intent(Center.this, MainActivity.class));
                startActivity(intent);
            }
        });

    }
}
