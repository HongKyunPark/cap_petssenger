package com.example.cap;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText et_id, et_pw;
    private Button btnRegist, btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = (EditText)findViewById(R.id.et_Id);
        et_pw = (EditText)findViewById(R.id.et_pw);
        btnRegist = (Button)findViewById(R.id.btnRegist);
        btnCheck = (Button)findViewById(R.id.btnCheck);

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistActivity.class);
                startActivityForResult(intent, 1000);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("Result", requestCode + "");
        Log.d("Result", resultCode + "");
        Log.d("Result", data + "");

        if(requestCode == 1000 && resultCode == RESULT_OK){
            Toast.makeText(Login.this, "회원가입을 완료했습니다",Toast.LENGTH_SHORT).show();
            et_id.setText(data.getStringExtra("ID"));
        }
    }
}
