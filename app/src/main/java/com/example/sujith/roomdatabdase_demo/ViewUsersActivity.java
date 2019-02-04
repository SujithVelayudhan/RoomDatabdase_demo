package com.example.sujith.roomdatabdase_demo;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ViewUsersActivity extends AppCompatActivity
{
    TextView viewUserstvp;
    MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        viewUserstvp=findViewById(R.id.viewUserstv);

        myAppDatabase=Room.databaseBuilder(getApplicationContext()
                ,MyAppDatabase.class,"userdb").allowMainThreadQueries().build();


        List<User> users=myAppDatabase.myDao().getUsers();

        String info="";

        for (User usr:users)
        {
            int id=usr.getId();
            String name=usr.getName();
            String email=usr.getEmail();

            info=info+"\n\n Id: "+id+"\n Name: "+name+"\n Email: "+email;


        }

        viewUserstvp.setText(info);




    }
}
