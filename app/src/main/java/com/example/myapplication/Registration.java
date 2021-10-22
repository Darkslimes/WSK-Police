package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Registration extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
    public void Save(String login, String password)
    {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db",MODE_PRIVATE,null);
        ContentValues cv = new ContentValues();
        cv.put("login", login);
        cv.put("password", password);

        db.insert("users",null, cv);
        db.close();
        com.example.myapplication.login.Users.add(new User(login,password));
    }

 public void Registration(View view){
     EditText log = findViewById(R.id.reg_username);
     EditText pass = findViewById(R.id.reg_password);
     Save(log.getText().toString(), pass.getText().toString());
     Intent i = new Intent(Registration.this, login.class);
     startActivity(i);
    }
}