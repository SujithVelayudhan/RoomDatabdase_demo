package com.example.sujith.roomdatabdase_demo;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity
{
    EditText idp,namep,emailp;
    Button addBp;

    MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        idp=findViewById(R.id.add_userid);
        namep=findViewById(R.id.add_username);
        emailp=findViewById(R.id.add_useremail);
        addBp=findViewById(R.id.addB);

        myAppDatabase=Room.databaseBuilder(getApplicationContext()
                ,MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

        addBp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int id=Integer.parseInt(idp.getText().toString());
                String username=namep.getText().toString();
                String useremail=emailp.getText().toString();

                User user=new User();
                user.setId(id);
                user.setName(username);
                user.setEmail(useremail);

                myAppDatabase.myDao().addUser(user);
                Toast.makeText(AddUserActivity.this, "User Added", Toast.LENGTH_SHORT).show();

                idp.setText("");
                namep.setText("");
                emailp.setText("");


            }
        });




    }
}
