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


    TextView tvCurrent,tvTarget ;
    Button btn;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCurrent = findViewById(R.id.tvCurrent);
        tvTarget = findViewById(R.id.tvTarget);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Calendar current = Calendar.getInstance();
        int currentYear = current.get(Calendar.YEAR);
        int currentMonth = current.get(Calendar.MONTH);
        int currentDay = current.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {



                tvCurrent.setText(dayOfMonth + "/" + (month + 1) +"/" + year);

                Calendar tar = Calendar.getInstance();
                int tarYear = tar.get(Calendar.YEAR);
                int tarMonth = tar.get(Calendar.MONTH);
                int tarDay = tar.get(Calendar.DAY_OF_MONTH);

            }
        },currentYear,currentMonth,currentDay);
        datePickerDialog.show();




    }
}
