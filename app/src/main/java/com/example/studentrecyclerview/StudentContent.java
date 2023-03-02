package com.example.studentrecyclerview;

import java.util.ArrayList;
public class StudentContent {
    // use for loop to create a list of students (20 students) inscription number and name are random
    public static ArrayList<Student> getStudents() {
        // list of random names
        String[] names = {"John", "Mary", "Peter", "Susan", "Kim", "George", "Alan", "Stacy", "Michelle", "Laura", "Tom", "Jane", "Alex", "Jim", "Steve", "Rachel", "Katherine", "Andrew", "Julie", "Lisa"};

        ArrayList<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 20; i++) {
            // generate random number between 0 and 19
            int random = (int) (Math.random() * 20);
            // generate random number between 1000000 and 9999999
            int randomInscriptionNumber = (int) (Math.random() * 9000000 + 1000000);
            // create a student object
            Student student = new Student(String.valueOf(randomInscriptionNumber), names[random]);
            // add student object to the list
            students.add(student);
        }
        return students;
    }
}
