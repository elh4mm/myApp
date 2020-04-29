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
public interface CourseDao {


    @Query("SELECT * FROM course")
    public LiveData<List<Course>> allCourses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCourse(Course course);

}
