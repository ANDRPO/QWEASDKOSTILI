package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SQLExampleActivity extends AppCompatActivity {
    final String FIELD_ID = "id";
    final String FIELD_FIRSTNAME = "firstName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlexample);

        Intent i = new
                Intent(SQLExampleActivity.this,
                MyService.class);
        startService(i);

        final SQLiteDatabase db = getBaseContext().
                openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        Button readButton = findViewById(R.id.readButton);
        Button writeButton = findViewById(R.id.writeButton);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor query = db.rawQuery("SELECT * FROM student", null);
                while (query.moveToNext()) {
                    String name = query.getString(query.getColumnIndex("firstName"));
                    Log.d("MYAPP", name);
                }
            }
        });
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("CREATE TABLE IF NOT EXISTS student (id INTEGER, firstName TEXT, lastName TEXT, course INTEGER) ");
                Log.d("MYAPP", "CREATE TABLE DONE");
//                db.execSQL("INSERT INTO student (id, firstName, lastName, course) VALUES (1, 'Emil', 'S', 0)");
//                Log.d("MYAPP", "INSERT DONE");
                ContentValues values = new ContentValues();
                values.put(FIELD_ID, 2);
                values.put(FIELD_FIRSTNAME, "Ivan");
                values.put("lastName", "Ivanov");
                values.put("course", 2);
                db.insert("student", null, values);


            }

        });
    }


}
