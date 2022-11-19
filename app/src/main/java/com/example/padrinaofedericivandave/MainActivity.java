package com.example.padrinaofedericivandave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SD_SharedPref = (Button)findViewById(R.id.SD_SharedPref);
        Button SD_INTStorage = (Button)findViewById(R.id.SD_INTStorage);
        Button SD_EXTStorage = (Button)findViewById(R.id.SD_EXTStorage);
        Button CD_INTCache = (Button)findViewById(R.id.CD_INTCache);
        SD_SharedPref.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                SD_toSharedPref();
            }
        });

        SD_INTStorage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                SD_toINTStorage();
            }
        });



    }
    public void SD_toSharedPref(){
        SharedPreferences sharedPreferences = getSharedPreferences("SD_SharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor create = sharedPreferences.edit();
        create.putString("task:", "Saving Data");
        create.putString("location:", "SharedPreferences");
        create.commit();

    }


    public void SD_toINTStorage(){
        String task = "task: ";
        String task1 = "Saving Data";
        String location ="location: ";
        String location1="Internal Storage";

        String details = task + " " + task1;
        String details1 = location + " " + location1;

        FileOutputStream s = null;

        try{
            s = openFileOutput("SD_InternalStorage", Context.MODE_PRIVATE);
            s.write(details.getBytes());
            s.write(details1.getBytes());
        }
        catch (Exception e){

        }

    }










}


