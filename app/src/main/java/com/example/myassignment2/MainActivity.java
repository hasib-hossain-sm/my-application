package com.example.myassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button ageCalculatorButton,currencyConverterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageCalculatorButton = findViewById(R.id.AgeCalculatorButton);
        currencyConverterButton = findViewById(R.id.CurrencyConverterButton);
        currencyConverterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CurrencyConverterActivity.class);
                startActivity(intent);
            }
        });
        ageCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AgeCalculatorActivity.class);
                startActivity(intent);
            }
        });

    }
}
