package com.example.vizsga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText Fullname, Age, Address;
    Button plus;
    ListView results;
    ArrayList<String> arrayResult;
    ArrayAdapter<String> arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fullname =(EditText) findViewById(edit_fullname);
        Age = (EditText) findViewById(edit_age);
        Address = (EditText) findViewById(edit_address);

        results = (ListView)findViewById(results);

        plus = (Button) findViewById(plus);

        arrayResult = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.Layout.simple_list_item_1, arrayResult);
        results.setAdapter(arrayAdapter);

    }
}
