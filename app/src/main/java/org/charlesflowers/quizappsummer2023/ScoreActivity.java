package org.charlesflowers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.security.auth.Subject;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    Button sendBTN;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        sendBTN = (Button) findViewById(R.id.sendBTN);



        scoreTV = (TextView) findViewById(R.id.scoreTV);

        Intent incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score",0);
        scoreTV.setText(getString(R.string.lblScr) + score);
        //
        sendBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = getString(R.string.email_app);
                String body = getString(R.string.bMsg1) + score + getString(R.string.bMsg2);
                composeEmail(subject,body);
            }
        });
    }

    private void composeEmail(String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}