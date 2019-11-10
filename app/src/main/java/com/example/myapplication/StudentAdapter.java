package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentAdapter extends ArrayAdapter<Student> {

    private List<Student> students;
    private int listItemID ;
    private LayoutInflater inflater;
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.listItemID = resource;
        this.students = objects;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = inflater.inflate(listItemID, parent,false);

        TextView courseTW = v.findViewById(R.id.courseTextView);
        TextView firstNameTW = v.findViewById(R.id.firstNameTextView);

        Student student = this.students.get(position);
        courseTW.setText(student.getCourse() + "");
        firstNameTW.setText(student.getFirstName());

        return v;
    }
}
