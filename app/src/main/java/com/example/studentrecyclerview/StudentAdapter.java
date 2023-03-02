package com.example.studentrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private Context context;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Student student = students.get(position);
        holder.textViewInscriptionNumber.setText(student.getInscriptionNumber());
        holder.textViewName.setText(student.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Inscription number: " + student.getInscriptionNumber() + " Name: " + student.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewInscriptionNumber;
        TextView textViewName;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewInscriptionNumber = (TextView) itemView.findViewById(R.id.TextViewInscriptionNumber);
            textViewName = (TextView) itemView.findViewById(R.id.TextViewName);
        }

        public TextView getTextViewInscriptionNumber() {
            return textViewInscriptionNumber;
        }
    }
}
