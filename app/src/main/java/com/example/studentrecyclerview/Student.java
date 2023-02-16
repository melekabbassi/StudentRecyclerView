package com.example.studentrecyclerview;

public class Student {
    private String InscriptionNumber;
    private String Name;

    public Student(String inscriptionNumber, String name) {
        this.InscriptionNumber = inscriptionNumber;
        this.Name = name;
    }

    public String getInscriptionNumber() {
        return InscriptionNumber;
    }

    public void setInscriptionNumber(String inscriptionNumber) {
        this.InscriptionNumber = inscriptionNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
