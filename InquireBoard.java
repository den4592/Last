package com.example.dbtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InquireBoard extends AppCompatActivity {

    private Button back;
    private Button inquireboard;
    private Button reportboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire_board);

        inquireboard=(Button)findViewById(R.id.inquireboardd);
        reportboard=(Button)findViewById(R.id.reportboard);

        inquireboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InquireBoard.this,InquireBoard2.class));

            }
        });

        reportboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InquireBoard.this,InquireBoard3.class));
            }
        });

        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InquireBoard.this,Center.class));
            }
        });




    }


}
