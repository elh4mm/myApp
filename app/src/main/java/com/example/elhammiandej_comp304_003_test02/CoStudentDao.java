package com.example.elhammiandej_comp304_003_test02;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CoStudentDao {

    @Query("select distinct c.* from coStudent cs inner join course c on c.courseId = cs.courseId where studentId = :id ")
    public LiveData<List<Course>> allCourses(int id);

    @Query("select   c.* from coStudent cs inner join course c on c.courseId = cs.courseId where studentId = :id  and c.courseId=:courseId")
    public LiveData<Course> hasCourse(int id, int courseId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(CoStudent coStudent);
}
