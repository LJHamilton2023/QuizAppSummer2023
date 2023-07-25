package org.charlesflowers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView questionTV;
    Button falseBTN, trueBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = (TextView) findViewById(R.id.questionTV);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        trueBTN = (Button) findViewById(R.id.trueBTN);

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CharSequence text = "Hello toast!";
                String msg = "You are correct! /Good Job!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                toast.show();
            }
        });
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CharSequence text = "Hello toast!";
                String msg = "You are wrong! Try again!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                toast.show();
            }
        });

    }
}