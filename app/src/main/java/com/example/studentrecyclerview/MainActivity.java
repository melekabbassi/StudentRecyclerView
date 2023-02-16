package com.example.studentrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView StudentRecyclerView;
    RecyclerView.LayoutManager StudentLayoutManager;
    StudentAdapter StudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentRecyclerView = findViewById(R.id.StudentRecyclerView);
        StudentLayoutManager = new LinearLayoutManager(this);
        StudentRecyclerView.setLayoutManager(StudentLayoutManager);

        List<Student> students = StudentAdapter.getStudents();
        StudentAdapter = new StudentAdapter(this, students);
        StudentRecyclerView.setAdapter(StudentAdapter);
    }
}