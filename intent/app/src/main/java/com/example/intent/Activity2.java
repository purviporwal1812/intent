package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        TextView resultText = findViewById(R.id.result_text);

        Intent intent = getIntent();
        int counterValue = intent.getIntExtra("counter_value", 0);

        resultText.setText("Counter Value: " + counterValue);
    }
}
