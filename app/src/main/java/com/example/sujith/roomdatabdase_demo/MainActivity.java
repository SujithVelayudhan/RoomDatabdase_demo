package com.example.sujith.roomdatabdase_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button AdduserBp,viewUsersBp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdduserBp=findViewById(R.id.addUser);
        viewUsersBp=findViewById(R.id.viewUsersB);

        AdduserBp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent add=new Intent(getApplicationContext(),AddUserActivity.class);
                startActivity(add);

            }
        });

        viewUsersBp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent viewU=new Intent(getApplicationContext(),ViewUsersActivity.class);
                startActivity(viewU);

            }
        });
    }
}
