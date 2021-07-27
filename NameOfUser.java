package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameOfUser extends AppCompatActivity {
    private EditText name;
    private Button button4;
    public static final String Bundle_Msg = "com.example.myapplication.extra.Bundle_Msg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_of_user);
        name=findViewById(R.id.url);
        button4=findViewById(R.id.button3);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NameOfUser.this, MainActivity2.class);
                String Message = name.getText().toString();


                intent.putExtra(Bundle_Msg, Message);
                startActivity(intent);
            }
        });
}}