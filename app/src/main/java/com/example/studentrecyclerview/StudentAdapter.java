package com.example.studentrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Alert Dialog to confirm delete
                if (position != RecyclerView.NO_POSITION && position < students.size()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(context)
                            .setTitle("Delete Student")
                            .setMessage("Are you sure you want to delete + " + students.get(position).getInscriptionNumber() + " from students list ?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    students.remove(position);
                                    notifyItemRemoved(position);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create();
                    alertDialog.show();
                }
                return true;
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
