package org.charlesflowers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView questionTV;
    Button falseBTN, trueBTN, nextBTN;
    int score;
    //added 7/25
    Question q1,q2,q3,q4,q5,cQ;
    Question [] questions;
    int curNdx;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = (TextView) findViewById(R.id.questionTV);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        nextBTN = (Button) findViewById(R.id.nextBTN);
        score = 0;

        q1 = new Question("Pi equals 3.0",false);
        q2 = new Question("Computer hardware is a collection of " +
                "programs that provide instructions a computer carries out.",false);
        q3 = new Question("An abstraction is a physical model that removes or hides " +
                "unnecessary details.");
        q4 = new Question("A vacuum tube was used in the first generation of computers.",false);
        q5 = new Question("Magnetic disks were introduced in the third generation of " +
                "computer hardware.", true);
        cQ = q1;
        questions = new Question[] {q1,q2,q3,q4,q5};
        msg = "";

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (false == cQ.getCorrectAnswer())
                {
                    msg = "You are correct! Good Job!";
                    score++;
                }
                else
                {
                    msg = "You are Wrong. Try again.";
                }

                //CharSequence text = "Hello toast!";

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                toast.show();
            }
        });
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (true == cQ.getCorrectAnswer())
                {
                    msg = "You are correct! Good Job!";
                    score++;
                }
                else
                {
                    msg = "You are Wrong. Try again.";

                }

                //CharSequence text = "Hello toast!";

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                toast.show();
            }
        });
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curNdx++;
                if(curNdx < 5)
                {
                    cQ = questions[curNdx];
                    questionTV.setText(cQ.getqPrompt());
                }
                else
                {
                    Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    scoreIntent.putExtra("score",score);
                    startActivity(scoreIntent);
                }

            }
        });
    }
}