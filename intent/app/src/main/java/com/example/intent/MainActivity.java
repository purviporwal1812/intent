package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView ans;


    private final ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    counter = result.getData().getIntExtra("counter_value", counter);
                    ans.setText(String.valueOf(counter));
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton inc = findViewById(R.id.inc);
        ImageButton dec = findViewById(R.id.dec);
        Button reset = findViewById(R.id.reset);
        ans = findViewById(R.id.ans);

        inc.setOnClickListener(v -> {
            counter++;
            ans.setText(String.valueOf(counter));
            openActivity2(counter);
        });

        dec.setOnClickListener(v -> {
            counter--;
            ans.setText(String.valueOf(counter));
            openActivity3(counter);
        });

        reset.setOnClickListener(v -> {
            counter = 0;
            ans.setText(String.valueOf(counter));
        });
    }

    private void openActivity2(int value) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("counter_value", value+1);
    }
    private void openActivity3(int value){
        Intent intent = new Intent(MainActivity.this,Activity3.class);
        intent.putExtra("counter_value" , value-1);

    }
}
