package com.example.elhammiandej_comp304_003_test02;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertStudent(Student student);

    @Query("select * from student where studentId = :id")
    LiveData<Student> loadStudent(int id);
}
