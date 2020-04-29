package com.example.elhammiandej_comp304_003_test02;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseId;
    private String name;
    private String department;
    private String duration;
    private String teacherName;


    public  Course(int courseId, String name, String department, String duration, String teacherName)
    {

        this.courseId = courseId;
       this.name = name;
       this.department = department;
       this.duration = duration;
       this.teacherName = teacherName;
    }
    public int getCourseId() {
        return courseId;
    }

    public String getDepartment() {
        return department;
    }

    public String getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setCourseId(int courseId) {
        courseId = courseId;
    }

    public void setDepartment(String department) {
        department = department;
    }

    public void setDuration(String duration) {
        duration = duration;
    }

    public void setName(String name) {
        name = name;
    }

    public void setTeacherName(String teacherName) {
        teacherName = teacherName;
    }


    @NonNull
    @Override
    public String toString() {
        return String.format ( "%s\nDuration:%s\nDepartmant:%s\nTeacher:%s",getName(), getDuration(),getDepartment(),getTeacherName());
    }
}
