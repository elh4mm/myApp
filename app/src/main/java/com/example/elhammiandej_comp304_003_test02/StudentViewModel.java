package com.example.elhammiandej_comp304_003_test02;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private Repository repo;

    public  StudentViewModel(@NonNull Application application) {
        super (application);
        repo=  new Repository(application);
    }

    public  LiveData<Student>  findById(int id)
    {
        return  repo.loadStudent ( id );
    }
    public  LiveData<List<Course>>  getCourses(int id)
    {
        return  repo.allStudentCourses( id );
    }
    public  void insert(Student student)
    {
        repo.insertStudent(student);
    }
    public  void insertCourse(CoStudent coStudent)
    {
        repo.insertCoStudent(coStudent);
    }
    public LiveData<Course> hasCourse(int id, int courseId) {
      return repo.hasCourse(id, courseId);


    }

}


