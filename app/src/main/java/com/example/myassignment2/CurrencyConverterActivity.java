package com.example.myassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CurrencyConverterActivity extends AppCompatActivity {


    private int from,to;
    private double inTaka,inChoose;
    private EditText editText;
    private Spinner currencyNamesFrom,currencyNamesTo;
    private Button backButton,convertButton;
    String[] names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        currencyNamesFrom = findViewById(R.id.fromSpinner);
        names = getResources().getStringArray(R.array.currencyNames);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencyNamesFrom.setAdapter(adapter);

        currencyNamesTo = findViewById(R.id.toSpinner);
        //names = getResources().getStringArray(R.array.currencyNames);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,names);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencyNamesTo.setAdapter(adapter2);



        editText = findViewById(R.id.editTextCurrencyConverterActivity);
        backButton = findViewById(R.id.backButtonCurrencyConverter);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CurrencyConverterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        currencyNamesFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(CurrencyConverterActivity.this,names[position],Toast.LENGTH_SHORT).show();
                from = position;
                Double data = Double.parseDouble(editText.getText().toString());

                inTaka=dataToFrom(data,from);
                inChoose = fromToTo(inTaka,to);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        currencyNamesTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(CurrencyConverterActivity.this,names[position],Toast.LENGTH_SHORT).show();
                to = position;
                Double data = Double.parseDouble(editText.getText().toString());

                inTaka=dataToFrom(data,from);
                inChoose = fromToTo(inTaka,to);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        convertButton = findViewById(R.id.convertButtonCurrencyConverterActivity);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                //String convertFrom = Integer.toString(from);
                //String convertTo = Integer.toString(to);
                String data = editText.getText().toString();
                String inChooseString= Double.toString(inChoose);
                Intent intent = new Intent(CurrencyConverterActivity.this,CurrencyConverterResultActivity.class);
                intent.putExtra("a1",data);
                intent.putExtra("a2",inChooseString);
                intent.putExtra("c1",names[from]);
                intent.putExtra("c2",names[to]);
                startActivity(intent);
            }
        });


    }
    public double dataToFrom(double data,int position){
        if(position ==0){
            return data;
        }
        else if(position ==1){
            return data*1.12;
        }
        else{
            return data*91.14;
        }
    }
    public double fromToTo(double data,int position){
        if(position ==0){
            return data;
        }
        else if(position ==1){
            return data*0.88717;
        }
        else{
            return data*0.011;
        }
    }
}
