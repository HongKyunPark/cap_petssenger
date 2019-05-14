package com.example.cap;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity {

    private EditText et_id,et_pw,et_pwch;
    private Button btnAgree, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        et_id = (EditText)findViewById(R.id.et_Id);
        et_pw = (EditText)findViewById(R.id.et_pw);
        et_pwch = (EditText)findViewById(R.id.et_pwch);

        btnAgree = (Button)findViewById(R.id.btnAgree);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        et_pwch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = et_pw.getText().toString();
                String confirm = et_pwch.getText().toString();

                if(password.equals(confirm)){
                    et_pw.setTextColor(Color.GREEN);
                    et_pwch.setTextColor(Color.GREEN);
                }else{
                    et_pw.setTextColor(Color.RED);
                    et_pwch.setTextColor(Color.RED);
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et_id.getText().toString().length() == 0){
                    Toast.makeText(RegistActivity.this, "Email을 입력하세요",Toast.LENGTH_SHORT).show();
                    et_id.requestFocus();
                    return;
                }

                if(et_pw.getText().toString().length() == 0){
                    Toast.makeText(RegistActivity.this, "비밀번호를 입력하세요",Toast.LENGTH_SHORT).show();
                    et_id.requestFocus();
                    return;
                }

                if(et_pwch.getText().toString().length() == 0){
                    Toast.makeText(RegistActivity.this, "비밀번호 확인을 입력하세요",Toast.LENGTH_SHORT).show();
                    et_id.requestFocus();
                    return;
                }

                if(!et_pw.getText().toString().equals(et_pwch.getText().toString())){
                    Toast.makeText(RegistActivity.this, "비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
                    et_id.requestFocus();
                    return;
                }

                Intent result = new Intent();
                result.putExtra("ID",et_id.getText().toString());

                setResult(RESULT_OK, result);
                finish();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
            }
        });
    }
}
