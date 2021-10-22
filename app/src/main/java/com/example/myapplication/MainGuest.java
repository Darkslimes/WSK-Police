package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainGuest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_guest);
    }
    public void AboutUs(View view)
    {
    Intent i = new Intent(MainGuest.this, AboutUs.class);
    startActivity(i);
    }

    public void Paint(View view)
    {
        Intent i = new Intent(MainGuest.this, Paint.class);
        startActivity(i);
    }

    public void Photorobot(View view)
    {
        Intent i = new Intent(MainGuest.this, PhotoRobot.class);
        startActivity(i);
    }

    public void NewPhotorobot(View view)
    {
        Intent i = new Intent(MainGuest.this, NewPhotoRobot.class);
        startActivity(i);
    }

    public void Departament(View view)
    {
        Intent i = new Intent(MainGuest.this, NewPhotoRobot.class);
        startActivity(i);
    }
}