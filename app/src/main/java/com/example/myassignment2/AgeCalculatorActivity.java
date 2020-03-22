package com.example.myassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class AgeCalculatorActivity extends AppCompatActivity {

    private Button backButton;
    private Button calculateAgeButton;
    private DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        datePicker = findViewById(R.id.datePickerAgeCalculator);
        backButton = findViewById(R.id.backButtonAgeCalculator);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AgeCalculatorActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        calculateAgeButton=findViewById(R.id.calculateAgeButtonAgeCalculator);
        calculateAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String day = Integer.toString(datePicker.getDayOfMonth());
                 String month = Integer.toString(datePicker.getMonth()+1);
                 String year = Integer.toString(datePicker.getYear());

                 Intent intent =new Intent(AgeCalculatorActivity.this,AgeCalculatorResultActivity.class);
                 intent.putExtra("d",day);
                 intent.putExtra("m",month);
                 intent.putExtra("y",year);
                 startActivity(intent);
            }
        });
    }
}
