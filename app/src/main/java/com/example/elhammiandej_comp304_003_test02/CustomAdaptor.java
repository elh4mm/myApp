package com.example.elhammiandej_comp304_003_test02;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomAdaptor extends ArrayAdapter<Course> {

    private Context mContext;
    private List<Course> cList;

    int studentId;


    public CustomAdaptor(@NonNull Context context, int resource , List<Course> list,int userid) {
        super(context, resource, list);
        mContext = context;
        cList= list;
        studentId = userid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(this.getContext()).inflate(R.layout.list_item,parent,false);


        final Course current= cList.get(position);
        final CoStudent cs= new CoStudent(current.getCourseId(),studentId);


        final CheckBox check = (CheckBox) listItem.findViewById(R.id.checkBox);
        check.setText(current.toString());
        check.setOnClickListener(
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(check.isChecked()) {
                            TempRepository.add(cs);
                        }
                        else
                            TempRepository.list.remove(cs);
                    }
                }));



        return listItem;
    }
}
