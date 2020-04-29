package com.example.elhammiandej_comp304_003_test02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class CourseListActivity extends AppCompatActivity {

    StudentViewModel studentViewModel;
    ListView listView;
    private ArrayAdapter<Course> aAdapter;
    SharedPreferences pref;
    int username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        listView = (ListView)findViewById(R.id.coListView);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        username = pref.getInt("username", 1);
        studentViewModel.getCourses(username ).observe(this, new Observer<List<Course>>() {
                @Override
                public void onChanged(@Nullable final List<Course> courses) {

                    aAdapter = new ArrayAdapter<Course>(getBaseContext(), android.R.layout.simple_list_item_1, courses);
                    listView.setAdapter(aAdapter);

                }

        });
    }


}
