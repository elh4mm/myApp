package com.example.elhammiandej_comp304_003_test02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    CourseViewModel courseViewModel;
    StudentViewModel studentViewModel;
    ListView listView;
    private CustomAdaptor aAdapter;
    Button btn;
    SharedPreferences pref;
    List<Course>  studentCourses;
    int username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        listView = (ListView)findViewById(R.id.listView);
        btn = (Button) findViewById(R.id.btnSubmit);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        username = pref.getInt("username", 1);
        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);


        courseViewModel.allCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(@Nullable final List<Course> courses) {

                aAdapter = new CustomAdaptor(getBaseContext(), android.R.layout.simple_list_item_1,courses,username);
                listView.setAdapter(aAdapter);

            }

        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String msg =  "Hi,\n Your course registration has been successfully done ";

                try {
                   /*Intent it = new Intent(Intent.ACTION_SEND);
                    it.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
                    it.putExtra(Intent.EXTRA_SUBJECT,"Confirmation");
                    it.putExtra(Intent.EXTRA_TEXT,msg);
                    it.setType("message/rfc822");*/

                    for(CoStudent  cs: TempRepository.list)
                    {
                      if(studentViewModel.hasCourse(username, cs.getCourseid()).getValue()==null)
                        studentViewModel.insertCourse(cs);
                    }

                   TempRepository.list.clear();
                   //startActivity(Intent.createChooser(it,"Choose Mail App"));
                 //  Toast.makeText(RegistrationActivity.this, "Confirmation Email sent", Toast.LENGTH_SHORT).show();
                   Intent  intent= new Intent(RegistrationActivity.this, CourseListActivity.class);
                   startActivity(intent);
                }
                catch (Exception e) {
                    Toast.makeText(RegistrationActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                } }
        });
    }
}