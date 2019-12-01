package com.example.dbtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyPage extends AppCompatActivity {

    TextView ema,ematwo,phonum, stuid;
    DatabaseReference reff;
    FirebaseAuth auth;
    Button btn,back;
    private Button btnlogout;
    private Button center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        center=(Button)findViewById(R.id.center);
        ema=(TextView)findViewById(R.id.email1);
        ematwo=(TextView)findViewById(R.id.email2);
        phonum=(TextView)findViewById(R.id.phonenum1);
        stuid=(TextView)findViewById(R.id.studentid1);
        btn=(Button)findViewById(R.id.checkbtn);
        back=(Button)findViewById(R.id.back);


        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyPage.this, Center.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyPage.this,MainActivity.class));
            }
        });

        btnlogout = (Button) findViewById(R.id.btlogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                finish();
                startActivity(new Intent(MyPage.this, Login.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff= FirebaseDatabase.getInstance().getReference().child("User").child("-LuVhSjB5NJku5u_Ewbi");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String firstemail=dataSnapshot.child("email").getValue().toString();
                        String secondemail=dataSnapshot.child("email").getValue().toString();
                        String firstnumber=dataSnapshot.child("phone_num").getValue().toString();
                        String firstid=dataSnapshot.child("studentid").getValue().toString();

                        ema.setText(firstemail);
                        ematwo.setText(secondemail);
                        phonum.setText(firstnumber);
                        stuid.setText(firstid);

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
