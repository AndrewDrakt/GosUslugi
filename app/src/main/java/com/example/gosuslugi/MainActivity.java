package com.example.gosuslugi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
public class MainActivity extends AppCompatActivity {
EditText date_txt, time_txt;
ImageButton date_btn, time_btn;
Button apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date_txt = findViewById(R.id.date_pick);
        time_txt = findViewById(R.id.time_pick);
        date_btn = findViewById(R.id.date_pick_btn);
        time_btn= findViewById(R.id.time_pick_btn);
        apply = findViewById(R.id.apply_btn);

        date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
int year = 1984;
int month =11;
int day = 13;
                DatePickerDialog.OnDateSetListener date_picker=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date_txt.setText(""+i2+"/"+(i1+1)+"/"+i);
                    }
                };
DatePickerDialog datePickerDialog=  new DatePickerDialog(MainActivity.this, date_picker, year, month, day);
datePickerDialog.show();
            }
        });
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hours = 14;
                int minutes=48;
                boolean is24format = true;
                TimePickerDialog.OnTimeSetListener time_picker = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        time_txt.setText(i+":"+i1);
                    }
                };
                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this,time_picker,hours,minutes,is24format);
                timePickerDialog.show();
            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.alertdialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(dialoglayout);
                builder.setTitle("Подтверждение записи").setMessage("Записаться на это время?").setIcon(R.drawable.ic_check).setPositiveButton("Записаться", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(MainActivity.this, "Вы записаны", Toast.LENGTH_SHORT).show();
                        date_txt.setText(" ");
                        time_txt.setText(" ");
                    }
                })
                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create();
                builder.show();
            }
        });
    }
}