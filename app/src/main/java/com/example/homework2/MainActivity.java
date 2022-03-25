package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn =(Button) findViewById(R.id.submit);
        btn.setOnClickListener(calBMI);
    }
    private OnClickListener calBMI = new View.OnClickListener(){
        public void onClick(View v) {
            DecimalFormat jg = new DecimalFormat("0.00");
            EditText yourHeight = (EditText) findViewById(R.id.height);
            EditText yourWeight = (EditText) findViewById(R.id.weight);
            double height = Double.parseDouble(yourHeight.getText().toString() );
            double weight = Double.parseDouble(yourWeight.getText().toString());
            double BMI = weight / (height * height);

            TextView result =(TextView) findViewById(R.id.result);
            result.setText("Your BMI is" + jg.format(BMI));

            TextView mySuggest = (TextView) findViewById(R.id.suggest);
            if (BMI > 25) {
                mySuggest.setText(R.string.advice_tooHeavy);
            } else if (BMI < 25) {
                mySuggest.setText(R.string.advice_tooThin);
            } else {
                mySuggest.setText(R.string.advice_middle);
            }
        }
    };
}