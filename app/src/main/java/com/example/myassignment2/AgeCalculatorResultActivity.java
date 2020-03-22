package com.example.myassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AgeCalculatorResultActivity extends AppCompatActivity {
    private Button backButton;
    private TextView birthDateText;
    private TextView currentDateText;
    private TextView ageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //birthDateText = findViewById(R.id.birthDateTextView);
        //currentDateText = findViewById(R.id.currentDateTextView);
        //ageText = findViewById(R.id.ageTextView);

        //birthDateText.setText("A");
        //currentDateText.setText("B");
        //ageText.setText("C");

        setContentView(R.layout.activity_age_calculator_result);
        backButton = findViewById(R.id.backButtonAgeCalculatorResult);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgeCalculatorResultActivity.this,AgeCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void onStart() {
        super.onStart();
        birthDateText = findViewById(R.id.birthDateTextView);
        currentDateText = findViewById(R.id.currentDateTextView);
        ageText = findViewById(R.id.ageTextView);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            int day = Integer.parseInt(bundle.getString("d"));
            int month = Integer.parseInt(bundle.getString("m"));
            int year = Integer.parseInt(bundle.getString("y"));

            Calendar calendar = Calendar.getInstance();
            int currentDay = calendar.get(Calendar.DATE);
            int currentMonth = calendar.get(Calendar.MONTH)+1;
            int currentYear = calendar.get(Calendar.YEAR);

            int ageDay,ageMonth,ageYear;

            if(currentDay-day<0){
                int temp = currentMonth;
                currentMonth--;
                temp = getMonth(temp,currentYear);
                currentDay+=temp;
            }
            ageDay = currentDay - day+1;
            if(currentMonth<month){
                currentYear--;
                currentMonth+=12;
            }
            ageMonth = currentMonth-month;
            if(currentYear-year<0){
                ageYear = -1;
            }
            else{
                ageYear =currentYear-year;
            }

            //currentYear = getMonth(8);

            birthDateText.setText(Integer.toString(day)+" / "+Integer.toString(month)+" / "+Integer.toString(year));
            currentDateText.setText(Integer.toString(currentDay)+" / "+Integer.toString(currentMonth)+" / "+Integer.toString(currentYear));
            ageText.setText(Integer.toString(ageYear)+" Year , "+Integer.toString(ageMonth)+" Month , "+Integer.toString(ageDay)+" Day");


        }




    }
    public int getMonth(int month,int year){
        if(month == 1 || month == 3|| month == 5|| month == 7|| month == 8|| month == 10|| month == 12){
            return 31;
        }
        else if(month ==2){
            if(leap(year)==1){
                return 29;
            }
            else{
                return 28;
            }
        }
        else {
            return 30;
        }
    }
    public int leap(int year){
        if(year%400==0){
            return 1;
        }
        else if(year%100==0){
            return 0;
        }
        else if(year%4==0){
            return 1;
        }
        else{
            return 0;
        }
    }

}

