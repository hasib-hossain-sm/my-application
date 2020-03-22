package com.example.myassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CurrencyConverterResultActivity extends AppCompatActivity {

    private Button backButton;
    private TextView amount1,amount2,currency1,currency2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter_result);

        backButton = findViewById(R.id.backButtonCurrencyConverterResult);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CurrencyConverterResultActivity.this,CurrencyConverterActivity.class);
                startActivity(intent);
            }
        });



    }
    protected void onStart() {
        super.onStart();

        amount1 = findViewById(R.id.amount1TextView);
        amount2 = findViewById(R.id.amount2TextView);
        currency1 = findViewById(R.id.currency1TextView);
        currency2 = findViewById(R.id.currency2TextView);

        Bundle bundle =getIntent().getExtras();
        if(bundle !=null){

            amount1.setText(bundle.getString("a1"));
            amount2.setText(bundle.getString("a2"));
            currency1.setText(bundle.getString("c1"));
            currency2.setText(bundle.getString("c2"));
        }



    }
}
