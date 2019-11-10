package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ListExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //SQLite
        //SharedPreferences     Settings    UserDefaults
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);

        final ArrayList<String> people = new ArrayList<>();
        people.add("Emil");
        people.add("Ivan");
        people.add("Petr");
        people.add("Roma");
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<>(getApplicationContext(),
//                        R.layout.list_item,
//                        people);
        final ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Emil", "S", 1));
        students.add(new Student("Emil1", "S", 1));
        students.add(new Student("Emil2", "S", 1));
        students.add(new Student("Emil3", "S", 1));
        students.add(new Student("Emil4", "S", 1));
        students.add(new Student("Emil5", "S", 1));

        ListView lw = findViewById(R.id.myListView);
        StudentAdapter adapter =
                new StudentAdapter(ListExampleActivity.this,
                        R.layout.list_item, students);

        lw.setAdapter(adapter);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = students.get(position);
                Intent in = new Intent(getApplicationContext(), StudentActivity.class);

                Gson gson = new Gson();
                String studentJson = gson.toJson(student);
                Log.d("MYAPP", studentJson);

                in.putExtra("studentName", student.getFirstName());
                in.putExtra("student", studentJson);
                startActivity(in);
            }
        });


    }
}
