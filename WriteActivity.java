package com.example.dbtest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WriteActivity extends AppCompatActivity {
    private EditText texttitle;
    private EditText editdetail;
    private EditText usertextreason;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private Button checkbtn;
    private Button back;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);


        texttitle=(EditText)findViewById(R.id.texttitle);
        usertextreason=(EditText)findViewById(R.id.usertextreason);
        editdetail=(EditText)findViewById(R.id.editdetail);

        checkbtn=(Button)findViewById(R.id.checkbtn);
        back=(Button)findViewById(R.id.back);





        databaseReference= FirebaseDatabase.getInstance().getReference("Center");


        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewWrite();
                startActivity(new Intent(WriteActivity.this, Center.class));

            }
        });

        //클릭 시 이번트 처리
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WriteActivity.this,Center.class));
            }
        });
    }

    private void NewWrite(){
        String texttitle1=texttitle.getText().toString().trim();
        String editdetail1=editdetail.getText().toString().trim();
        String usertextreason1=usertextreason.getText().toString().trim();


        if(!TextUtils.isEmpty(texttitle1)){
            String id =databaseReference.push().getKey();
            Write write=new Write(texttitle1,editdetail1,usertextreason1);
            databaseReference.child(id).setValue(write);

            Toast.makeText(this,"문의 해주셔서 감사합니다. 문의에 대한 답변은 빠른 시간내에 본인 이메일로 보내드립니다.",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"이메일을 입력해주세요",Toast.LENGTH_SHORT).show();
        }
    }


}





