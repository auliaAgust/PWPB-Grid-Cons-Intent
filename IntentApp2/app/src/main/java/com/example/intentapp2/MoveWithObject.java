package com.example.intentapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObject extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    public TextView tvObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = (TextView)findViewById(R.id.tv_obj_diterima);
        Person mPers = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+mPers.getName()+", Email :"+mPers.getEmail()+", Age : "+mPers.getAge()+", Location :"+mPers.getCity();

        tvObject.setText(text);

    }
}