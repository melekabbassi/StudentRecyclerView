package com.example.studentrecyclerview;

import java.util.ArrayList;
public class StudentContent {
    // use for loop to create a list of students (20 students) inscription number and name are random
    public static ArrayList<Student> getStudents() {
        // list of random names
        String[] names = {"John", "Mary", "Peter", "Susan", "Kim", "George", "Alan", "Stacy", "Michelle", "Laura", "Tom", "Jane", "Alex", "Jim", "Steve", "Rachel", "Katherine", "Andrew", "Julie", "Lisa"};

        ArrayList<Student> students = new ArrayList<Student>();
        for (String name : names) {
            // generate random number between 10000 and 99999
            int randomInscriptionNumber = (int) (Math.random() * 900 + 100);
            // create a student object
            Student student = new Student(String.valueOf(randomInscriptionNumber), name);
            //Student student = new Student(String.valueOf(), names[i]);
            // add student object to the list
            students.add(student);
        }
        return students;
    }
}
