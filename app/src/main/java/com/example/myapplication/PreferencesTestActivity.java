package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PreferencesTestActivity extends AppCompatActivity {

    public SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_test);
        prefs =
                getSharedPreferences("test",
                        Context.MODE_PRIVATE);
        String res =
                prefs.getString("something",
                        "нет данных");
        TextView textView = findViewById(R.id.outputTextView);
        textView.setText(res);
        Button b = findViewById(R.id.saveButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = findViewById(R.id.inputEditText);

                Editor editor = prefs.edit();
                editor.putString("something", text.getText().toString());
                editor.apply();
            }
        });

        ArrayList<String> test = new ArrayList<>();
        ArrayList<Student> test1 = new ArrayList<>();
        ArrayList<Integer> test2 = new ArrayList<>();


        ServerResponse<News> resp = new ServerResponse<>();
        ServerResponse<Team> resp2 = new ServerResponse<>();

        Cat cat = new Cat();
        Beaver beaver = new Beaver();


    }
}




