package com.example.elhammiandej_comp304_003_test02;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private final CourseDao courseDao;
    private final StudentDao studentDao;
    private final CoStudentDao coStudentDao;
    private LiveData<List<Course>> courseList;

    public Repository(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        courseDao = db.courseDao();
        courseList = courseDao.allCourses();
        studentDao = db.studentDao();
        coStudentDao = db.coStudentDao();
    }


    public LiveData<Student> loadStudent(final int studentId) {
        return studentDao.loadStudent (studentId);
    }

    public void insertStudent(Student student) {
        new insertStudentAsyncTask(studentDao).execute(student);

    }

    private static class insertStudentAsyncTask extends AsyncTask<Student, Void, Void> {

        private StudentDao tAsyncTaskDao;

        insertStudentAsyncTask(StudentDao dao) {
            tAsyncTaskDao = dao;
        }

        protected Void doInBackground(final Student... params) {
            tAsyncTaskDao.insertStudent(params[0]);
            return null;
        }
    }

    LiveData<List<Course>> allStudentCourses(int id) {
        return coStudentDao.allCourses (id) ;}

    LiveData<Course> hasCourse(int id, int courseId) {
        return coStudentDao.hasCourse (id,courseId) ;}

    public void insertCoStudent(CoStudent coStudent) {
        new insertCoStudentAsyncTask(coStudentDao).execute(coStudent);

    }

    private static class insertCoStudentAsyncTask extends AsyncTask<CoStudent, Void, Void> {

        private CoStudentDao tAsyncTaskDao;

        insertCoStudentAsyncTask(CoStudentDao dao) {
            tAsyncTaskDao = dao;
        }

        protected Void doInBackground(final CoStudent... params) {
            tAsyncTaskDao.insert(params[0]);
            return null;
        }
    }



    LiveData<List<Course>> getCourseList() { return courseList; }


    public void insert(Course course) {
        new insertAsyncTask(courseDao).execute(course);

    }

    private static class insertAsyncTask extends AsyncTask<Course, Void, Void> {

        private CourseDao mAsyncTaskDao;

        insertAsyncTask(CourseDao dao) {
            mAsyncTaskDao = dao;
        }


        protected Void doInBackground(final Course... params) {
            mAsyncTaskDao.insertCourse(params[0]);
            return null;
        }
    }












}
