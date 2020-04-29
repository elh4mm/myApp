package com.example.elhammiandej_comp304_003_test02;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "coStudent", foreignKeys = {
        @ForeignKey(entity = Student.class,
                parentColumns = "studentId",
                childColumns = "studentId",
                onDelete = ForeignKey.CASCADE)},
        indices = {@Index(value = "studentId")}
        )


public class CoStudent {
    @PrimaryKey(autoGenerate = true)
    private  int Id;
    private  int courseid;
    private int studentId;


    public CoStudent()
    {}

    public  CoStudent( int course, int studentId)
    {

        this.courseid = course;
      this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseid() {
        return courseid;
    }

    public int getId() {
        return Id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public void setId(int id) {
        Id = id;
    }
}
