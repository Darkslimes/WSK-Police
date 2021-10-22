package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class login extends AppCompatActivity implements View.OnClickListener {
public static ArrayList<User> Users;

    @Override
    protected void onCreate(Bundle savedInsanceState){
        super.onCreate(savedInsanceState);
        setContentView(R.layout.activity_login);

        Users = new ArrayList<>();

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (login TEXT, password TEXT)");
        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        while(query.moveToNext())
        {
            String login = query.getString(0);
            String password = query.getString(1);
            Users.add(new User(login, password));
        }
        query.close();
        db.close();

        Button act_change;
        act_change =(Button) findViewById(R.id.act_change);
        act_change.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        i = new Intent(this,Registration.class);
        startActivity(i);
    }

    private Button Login;
    private EditText username;
    private EditText password;


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void Login(View view){
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        String Log = username.getText().toString();
        String Pass = password.getText().toString();

        boolean found = false;

        for (User item: login.Users){
            if (Log.equals(item.login))
            {
                found = true;
                Toast.makeText(getApplicationContext(),"Успешно вошёл!", Toast.LENGTH_SHORT).show();
                login.this.finish();
                Intent intent = new Intent(login.this,Main.class);
                startActivity(intent);
                }
            else
            {
                Toast.makeText(getApplicationContext(),"Неверные данные",Toast.LENGTH_SHORT).show();
            }



        };

    }

    public void Guest(View view) {
        login.this.finish();
        Intent intent = new Intent(login.this,MainGuest.class);
        startActivity(intent);
    }
}
