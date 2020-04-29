package com.example.elhammiandej_comp304_003_test02;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {

    private Repository repo;

    private LiveData<List<Course>> courseList;

    public CourseViewModel(@NonNull Application application) {
        super(application);
        repo=  new Repository(application);
        courseList= repo.getCourseList();
    }


    public  void insertCourse(Course course)
    {
        repo.insert(course);
    }

    LiveData<List<Course>> allCourses() { return courseList; }

}
