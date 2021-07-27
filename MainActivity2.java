package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;
    private TextView display;
    private String itemText;
    public static final String Bundle_Msg = "com.example.myapplication.extra.Bundle_Msg";
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        button = findViewById(R.id.button);
        Intent incomingIntent=getIntent();
        String name=incomingIntent.getStringExtra(NameOfUser.Bundle_Msg) ;
        TextView nick = findViewById(R.id.todo);
        nick.setText("Hello:" + name+ "please write your top priority for today:");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                addItem(view);
                Intent intent = new Intent(MainActivity2.this, SecondActivity.class);
                String Message = itemText;


                intent.putExtra(Bundle_Msg, Message);
                startActivity(intent);

            }



        });
        items= new ArrayList<>();
        itemsAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();







    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                                @Override
                                                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Context context = getApplicationContext();
                                                    Toast.makeText(context, "Item removed", Toast.LENGTH_LONG).show();
                                                    items.remove(position);
                                                    itemsAdapter.notifyDataSetChanged();
                                                    return true;
                                                }
                                            }
        ) ;}

    private void addItem(View view) {
        EditText input= findViewById(R.id.ediText2);
        itemText=input.getText().toString();


        if (!(itemText.equals(""))) {
            itemsAdapter.add(itemText);
            input.setText("");

        }
        else {
            Toast.makeText(getApplicationContext(),"Please enter text",Toast.LENGTH_LONG).show();
        }
    }
}