package com.example.elhammiandej_comp304_003_test02;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Student.class, Course.class, CoStudent.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;
    public abstract StudentDao studentDao();
    public abstract CourseDao courseDao();
    public abstract CoStudentDao coStudentDao();

    public static synchronized AppDataBase getInstance(Context context) {
        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "app_database").fallbackToDestructiveMigration().build();
        }

        return  instance;
    }

    private static  RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            //  new PopulateDbAsync(INSTANCE).execute();
        }
    };
}
