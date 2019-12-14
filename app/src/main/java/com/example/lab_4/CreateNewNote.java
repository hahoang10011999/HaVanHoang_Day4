package com.example.lab_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class CreateNewNote extends AppCompatActivity implements TimePicker.TimePickerListener, DatePicker.DatePickerListener{
    Button btnTime,btnDate;
    Button btnTags,btnWeek,btnTune;
    Spinner spType;
    ArrayList<String> workType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_note);
        btnDate = findViewById(R.id.btnDate);
        btnTime =findViewById(R.id.btnTime);
        btnTags = findViewById(R.id.btnTags);
        btnWeek = findViewById(R.id.btnWeek);
        btnTune = findViewById(R.id.btnTune);
        spType = findViewById(R.id.spType);

        workType = new ArrayList<>();
        workType.add("Phone");
        workType.add("Word");
        workType.add("Home");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1,workType);
        spType.setAdapter(arrayAdapter);
        btnTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] tags = {"Family","Game","Android","VTC","Friend"};
                boolean[] isChecks = {false, true, false, true,false};
                AlertDialog alertDialog = new AlertDialog.Builder(CreateNewNote.this)
                        .setTitle("Choose tags")
                        .setMultiChoiceItems(tags, isChecks, new OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
        btnWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] day ={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
                boolean[] isChecks = {true,false,true,false,true,false,true};
                AlertDialog alertDialog = new AlertDialog.Builder(CreateNewNote.this)
                        .setTitle("choose tags:")
                        .setMultiChoiceItems(day, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
        btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.menu2,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mnItemFile:
                                Toast.makeText(getBaseContext(),"File",Toast.LENGTH_SHORT).show();
                            case R.id.mnItemDefaults:
                                final String[] tune = {"liệu giờ","Simple love","Hãy trao cho anh"};
                                AlertDialog alertDialog = new AlertDialog.Builder(CreateNewNote.this)
                                        .setTitle("Choose Tune")
                                        .setSingleChoiceItems(tune, 1, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(getBaseContext(),"OK",Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(getBaseContext(),"Cancel",Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .create();
                                alertDialog.show();

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePickerFragment = new com.example.lab_4.TimePicker();
                timePickerFragment.setCancelable(false);
                timePickerFragment.show(getSupportFragmentManager(),"time picker");
            }
        });
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePickerFragment = new DatePicker();
                datePickerFragment.setCancelable(false);
                datePickerFragment.show(getSupportFragmentManager(),"date picker");

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cancel:
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onTimeset(android.widget.TimePicker view, int hour, int min) {
        btnTime.setText(hour +" : "+min);
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year1, int month1, int dayOfMonth1) {
        btnDate.setText(dayOfMonth1+"/"+month1+"/"+year1);
    }
}
