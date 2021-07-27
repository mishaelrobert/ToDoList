package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private EditText editTextPhone,editText3,url;
    private Button button2,button3,button4;
    private View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent incomingIntent=getIntent();
        String todo1=incomingIntent.getStringExtra(MainActivity2.Bundle_Msg) ;
        TextView todo = findViewById(R.id.todo);
        todo.setText("Your top priority is:" + todo1);

        editTextPhone=findViewById(R.id.url);
        button2=findViewById(R.id.button2);
        editText3=findViewById(R.id.editText3);
        url=findViewById(R.id.url);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber= editTextPhone.getText().toString();
                Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse("Tel:"+phoneNumber));
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlAdd= url.getText().toString();
                Uri Ad=Uri.parse(urlAdd);
                Intent intent3= new Intent(Intent.ACTION_VIEW,Ad);
                startActivity(intent3);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber= editTextPhone.getText().toString();
                String message= editText3.getText().toString();
                Intent sendIntent= new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,message);
                sendIntent.setType("text");
                Intent shareIntent=Intent.createChooser(sendIntent,"Clock");

                startActivity(sendIntent);
            }
        });



    }
    public void Send_Message(View v){
        String phoneNumber= editTextPhone.getText().toString();
        String message= editText3.getText().toString();
        Intent sendIntent= new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,message);
        sendIntent.setType("text");
        Intent shareIntent=Intent.createChooser(sendIntent,"Clock");

        startActivity(sendIntent);
    }
    public void Website(View v){
        String urlAdd= url.getText().toString();
        Uri Ad=Uri.parse(urlAdd);
        Intent intent3= new Intent(Intent.ACTION_VIEW,Ad);
        startActivity(intent3);

    }

}