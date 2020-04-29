package com.example.elhammiandej_comp304_003_test02;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    private  int studentId;
    private String name;
    private String lastName;



    public  Student()
    {}
    public Student(int id, String n, String lName)
    {
        this.studentId = id;
        this.name = n;
        this.lastName = lName;

    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
       this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
