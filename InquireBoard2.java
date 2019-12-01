package com.example.dbtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InquireBoard2 extends AppCompatActivity {

    private EditText Editdetail2, Usertextreason2,Texttitle2;
    private DatabaseReference getDataReference;
    private FirebaseAuth auth;
    private Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire_board2);

        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InquireBoard2.this,InquireBoard.class));
            }
        });

        Editdetail2=findViewById(R.id.editdetail);
        Usertextreason2=findViewById(R.id.usertextreason);
        Texttitle2=findViewById(R.id.texttitle);
        getData();


    }


    private void getData() {
        auth=FirebaseAuth.getInstance();
        String userid=auth.getCurrentUser().getUid();
        getDataReference= FirebaseDatabase.getInstance().getReference().child("Center").child("-Lv0jKyoSjp3NSlrj1GQ");

        getDataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    String editdetail = dataSnapshot.child("editdetail").getValue().toString();
                    String texttitle = dataSnapshot.child("texttitle").getValue().toString();
                    String usertextreason = dataSnapshot.child("usertextreason").getValue().toString();


                    Editdetail2.setText(editdetail);
                    Texttitle2.setText(texttitle);
                    Usertextreason2.setText(usertextreason);


                }
                else
                    Toast.makeText(InquireBoard2.this,"데이터가 존재하지 않습니다.",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
