package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        Intent i = getIntent();
        String name= i.getStringExtra("studentName");
        String studentJson = i.getStringExtra("student");
        Gson gson = new Gson();
        Student s = gson.fromJson(studentJson, Student.class);
        TextView tv = findViewById(R.id.studentTextView);
        tv.setText(s.getFirstName());
    }
}






