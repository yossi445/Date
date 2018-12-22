package com.example.yossi.date;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tvCurrent,tvTest;
    Button btn;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCurrent = findViewById(R.id.tvCurrent);
        tvTest = findViewById(R.id.tvTest);

        btn= findViewById(R.id.btn);
        btn.setOnClickListener(this);


        //Calendar currentDate = Calendar.getInstance();

        /*int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth= currentDate.get(Calendar.MONTH);
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
        String currentDateStr = currentDay + "/" + (currentMonth  + 1) + "/" + currentYear;*/

        //tvCurrent.setText(currentDateStr);


    }


    @Override
    public void onClick(View v) {

        final Calendar currentDate = Calendar.getInstance();

        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth= currentDate.get(Calendar.MONTH);
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String selectedDateStr = dayOfMonth + "/" + (month  + 1) + "/" + year;
                tvCurrent.setText(selectedDateStr);

                Calendar selectedCal = Calendar.getInstance();
                selectedCal.set(Calendar.YEAR,year);
                selectedCal.set(Calendar.MONTH,month);
                selectedCal.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                tvTest.setText(String.valueOf(selectedCal.compareTo(currentDate)));


            }
        },currentYear,currentMonth,currentDay);

        datePickerDialog.show();


    }
}
