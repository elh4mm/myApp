package com.example.elhammiandej_comp304_003_test02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Course c;
    Button btnlog, btnReg, btnList,btnWeb,btnlogout, btnMap,btnInit;
    TextView txtWelcome;
    Intent intent,intentMap;
    SharedPreferences pref;
    int username;
    int count = 0;
    StudentViewModel studentViewModel;
    CourseViewModel courseViewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        username = pref.getInt("username", 3);

        btnlog = (Button)findViewById(R.id.btnLogin);
        btnReg= (Button)findViewById(R.id.btnReg);
        btnList = (Button)findViewById(R.id.btnList);
        btnWeb = (Button) findViewById(R.id.btnWebsite);
        btnInit = (Button) findViewById(R.id.btnInit);
        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        btnMap = (Button) findViewById(R.id.btnMap);
          btnlogout = (Button) findViewById(R.id.btnLogout);

        intentMap= new Intent(MainActivity.this, MapsActivity.class);
        //startActivity(intentMap);
        studentViewModel= ViewModelProviders.of(this).get(StudentViewModel.class);
        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);
        studentViewModel.findById(username).observe ( this, new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                txtWelcome.setText( "\t\t"+student.getName() +"\t"+student.getLastName());
            }

            } );


        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pref.contains("username")&& pref.contains("password")) {
                    intent = new Intent(MainActivity.this, RegistrationActivity.class);

                }


             else
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pref.contains("username")&& pref.contains("password"))
                    intent= new Intent(MainActivity.this, CourseListActivity.class);
                else

                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.centennialcollege.ca"));
                startActivity(intent);

            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent= new Intent(MainActivity.this, MapsActivity.class);

                startActivity(intent);

            }
        });
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student s = new Student(1, "Elham", "Miandej");
                studentViewModel.insert(s);
                s = new Student(2, "User", "2");
                studentViewModel.insert(s);
                  s = new Student(3, "", "");
                studentViewModel.insert(s);


                c = new Course(1, "Java", "IT", "100 Hours", "Katan");
                courseViewModel.insertCourse(c);
                c = new Course(2, "Android", "IT", "120 Hours", "Sujeet Luhan");
                courseViewModel.insertCourse(c);
                c = new Course(3, "Programming3", "IT", "120 Hours", "Sujeet Luhan");
                courseViewModel.insertCourse(c);
                c = new Course(4, "Data Structure", "IT", "120 Hours", "Salima Alim");
                courseViewModel.insertCourse(c);
                c = new Course(5, "Object oriented", "IT", "120 Hours", "Haki");
                courseViewModel.insertCourse(c);
                count =1;

            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            intent = new Intent(MainActivity.this, LoginActivity.class);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                txtWelcome.setText("");
                startActivity(intent);

            }
        });
    }
}
