package com.example.cap;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
  //  TextView txtResult;
    ListView list;
    List<ProfileDTO> items;
    Uri number;
    private int img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
      //  txtResult = (TextView)findViewById(R.id.txtResult);
        list = (ListView) findViewById(R.id.list);
        items = new ArrayList<>();
        img = R.drawable.dog;
        items.add(new ProfileDTO(ContextCompat.getDrawable(this, R.drawable.dog),"2019/04/16", "오늘은 댕댕이와 일본에 갔다."));
        items.add(new ProfileDTO(ContextCompat.getDrawable(this, R.drawable.dog1),"2019/04/21", "산책했음"));
        items.add(new ProfileDTO(ContextCompat.getDrawable(this, R.drawable.sakura),"2019/05/18", "병원갔음"));
        items.add(new ProfileDTO(ContextCompat.getDrawable(this, R.drawable.dog),"2019/05/20", "같이 놀음"));

        MyAdapter adapter = new MyAdapter(this, R.layout.profile, items);
        list.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<ProfileDTO>{

        public MyAdapter(Context context, int resource, List<ProfileDTO> objects) {
            super(context, resource, objects);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView; //직전에 출력된 뷰
            if (v == null) { //처음에만 뷰를 생성
                LayoutInflater li = (LayoutInflater) getLayoutInflater(); //뷰 생성기
                v = li.inflate(R.layout.profile, null); //phonebook.xml 읽어서 뷰 생성
            }
            ProfileDTO dto = items.get(position); //position에 해당하는 레코드
            TextView txtDate = (TextView) v.findViewById(R.id.txtDate);
            TextView txtContent = (TextView) v.findViewById(R.id.txtContent);
            ImageView image = (ImageView) v.findViewById(R.id.image);
            txtDate.setText(dto.getDate());
            txtContent.setText(dto.getContent());
            image.setImageDrawable(dto.getImage());

            return v;
        }
    }



}
