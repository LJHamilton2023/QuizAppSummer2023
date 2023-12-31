package org.charlesflowers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    //private final String sharedPrefFile = "org.codeintheschools.android.unit3_lesson1_a";
    private final String sharedPrefFile = "org.codeintheschools.android.QuizAppMilestone4";
    TextView scoreTV;
    Button sendBTN;
    int score;
    //
    private final String TOP_SCORE = "SCORE_1";
    private final String MID_TOP_SCORE = "SCORE_2";
    private final String LOW_TOP_SCORE = "SCORE_3";
    //
    private final String TOP_SCORE_NAME = "NAME_1";
    private final String MID_TOP_SCORE_NAME = "NAME_2";
    private final String LOW_TOP_SCORE_NAME = "NAME_3";
    //
    private final String TOP_SCORE_TIME = "TIME_1";
    private final String MID_TOP_SCORE_TIME = "TIME_2";
    private final String LOW_TOP_SCORE_TIME = "TIME_3";
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
//
        scoreTV = findViewById(R.id.scoreTV);
        sendBTN = findViewById(R.id.sendBTN);
//
        Intent incomingIntent = getIntent();
        String name = incomingIntent.getStringExtra("name");
        score = incomingIntent.getIntExtra("score",(int) 0);
        double ttl = incomingIntent.getDoubleExtra("ttlTime",0);
        float ttlTm = (float) ttl; //used to comparing stored sharePreferences

        scoreTV.setText(name +  " your score is: "  + score + " and time = " + ttl + " secs");
//
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        int tmp1=0, tmp2=0, tmp3=0;

        int initTopScore =  mPreferences.getInt(TOP_SCORE,(int) tmp1 );
        int initMidTopScore =  mPreferences.getInt(MID_TOP_SCORE,(int) tmp2 );
        int initLowTopScore =  mPreferences.getInt(LOW_TOP_SCORE,(int) tmp3 );
        String initTopScoreName = mPreferences.getString(TOP_SCORE_NAME,"Player1" );
        String initMidTopScoreName = mPreferences.getString(MID_TOP_SCORE_NAME,"Player2" );
        String initLowTopScoreName = mPreferences.getString(LOW_TOP_SCORE_NAME,"Player3" );
        float initTopScoreTime = mPreferences.getFloat(TOP_SCORE_TIME,(float) 0.0 );
        float initMidTopScoreTime = mPreferences.getFloat(MID_TOP_SCORE_TIME,(float)0.0 );
        float initLowTopScoreTime = mPreferences.getFloat(LOW_TOP_SCORE_TIME,(float) 0.0 );
//
        //Created SharedPreferences editor object
        SharedPreferences.Editor prefEdit = mPreferences.edit();

        if(score > initTopScore){
            prefEdit.putInt(TOP_SCORE,(int) score);
            prefEdit.putString(TOP_SCORE_NAME,name);
            prefEdit.putFloat(TOP_SCORE_TIME,ttlTm);
        }
        else if (score == initTopScore && Float.compare(initTopScoreTime,0)==0) {
            prefEdit.putInt(TOP_SCORE,(int) score);
            prefEdit.putString(TOP_SCORE_NAME,name);
            prefEdit.putFloat(TOP_SCORE_TIME,ttlTm);
        }
        else if (score == initTopScore && Float.compare(ttlTm,initTopScoreTime) < 0) {
            prefEdit.putInt(TOP_SCORE,(int) score);
            prefEdit.putString(TOP_SCORE_NAME,name);
            prefEdit.putFloat(TOP_SCORE_TIME,ttlTm);
        }
//
        else if(score > initMidTopScore){
            prefEdit.putInt(MID_TOP_SCORE,(int) score);
            prefEdit.putString(MID_TOP_SCORE_NAME,name);
            prefEdit.putFloat(MID_TOP_SCORE_TIME,ttlTm);
        }
        else if (score == initMidTopScore && Float.compare(initMidTopScoreTime,0)==0) {
            prefEdit.putInt(MID_TOP_SCORE,(int) score);
            prefEdit.putString(MID_TOP_SCORE_NAME,name);
            prefEdit.putFloat(MID_TOP_SCORE_TIME,ttlTm);
        }
        else if (score == initMidTopScore && Float.compare(ttlTm,initMidTopScoreTime) < 0) {
            prefEdit.putInt(MID_TOP_SCORE,(int) score);
            prefEdit.putString(MID_TOP_SCORE_NAME,name);
            prefEdit.putFloat(MID_TOP_SCORE_TIME,ttlTm);
        }
//
        else if(score > initLowTopScore){
            prefEdit.putInt(LOW_TOP_SCORE,(int) score);
            prefEdit.putString(LOW_TOP_SCORE_NAME,name);
            prefEdit.putFloat(LOW_TOP_SCORE_TIME,ttlTm);
        }
        else if (score == initLowTopScore && Float.compare(initLowTopScoreTime,0)==0) {
            prefEdit.putInt(LOW_TOP_SCORE,(int) score);
            prefEdit.putString(LOW_TOP_SCORE_NAME,name);
            prefEdit.putFloat(LOW_TOP_SCORE_TIME,ttlTm);
        }
        else if (score == initLowTopScore && Float.compare(ttlTm,initLowTopScoreTime) < 0) {
            prefEdit.putInt(LOW_TOP_SCORE,(int) score);
            prefEdit.putString(LOW_TOP_SCORE_NAME,name);
            prefEdit.putFloat(LOW_TOP_SCORE_TIME,ttlTm);
        }
        prefEdit.apply();

        //      update stored info
        initTopScore =   mPreferences.getInt(TOP_SCORE,(int) tmp1 );
        initMidTopScore =  mPreferences.getInt(MID_TOP_SCORE,(int) tmp2 );
        initLowTopScore =  mPreferences.getInt(LOW_TOP_SCORE,(int) tmp3 );
        initTopScoreName = mPreferences.getString(TOP_SCORE_NAME,"Player1" );
        initMidTopScoreName = mPreferences.getString(MID_TOP_SCORE_NAME,"Player2" );
        initLowTopScoreName = mPreferences.getString(LOW_TOP_SCORE_NAME,"Player3" );
        initTopScoreTime = mPreferences.getFloat(TOP_SCORE_TIME,(float) 0.0 );
        initMidTopScoreTime = mPreferences.getFloat(MID_TOP_SCORE_TIME,(float) 0.0 );
        initLowTopScoreTime = mPreferences.getFloat(LOW_TOP_SCORE_TIME,(float) 0.0 );
//
        TextView name1TV = findViewById(R.id.name1TV);
        TextView name2TV = findViewById(R.id.name2TV);
        TextView name3TV = findViewById(R.id.name3TV);
        TextView score1TV = findViewById(R.id.score1TV);
        TextView score2TV = findViewById(R.id.score2TV);
        TextView score3TV = findViewById(R.id.score3TV);
        TextView time1TV = findViewById(R.id.time1TV);
        TextView time2TV = findViewById(R.id.time2TV);
        TextView time3TV = findViewById(R.id.time3TV);
//
         name1TV.setText(initTopScoreName);
         name2TV.setText(initMidTopScoreName);
         name3TV.setText(initLowTopScoreName);
         //
         score1TV.setText(Integer.toString(initTopScore) + " points");
         score2TV.setText(Integer.toString(initMidTopScore) + " points");
         score3TV.setText(Integer.toString(initLowTopScore) + " points");
         //
         time1TV.setText(Float.toString(initTopScoreTime) + " secs");
         time2TV.setText(Float.toString(initMidTopScoreTime) + " secs");
         time3TV.setText(Float.toString(initLowTopScoreTime) + " secs");
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