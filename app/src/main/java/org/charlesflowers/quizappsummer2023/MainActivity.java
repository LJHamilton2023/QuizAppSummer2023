package org.charlesflowers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
//
    private final long startTime = System.currentTimeMillis();
    private SharedPreferences mPreferences;
    private final String sharedPrefFile = "org.codeintheschools.android.unit3_lesson1_a";
    private  final String COLOR_KEY_FBtn = "COLOR_FBtn";
    private final String COLOR_KEY_TBtn = "COLOR_TBtn";
    private  final String COLOR_KEY_NBtn = "COLOR_NBtn";
    private  final String NAME_KEY = "NAME";
    private  final String CHECKBOX_KEY = "CHKBX";
    private final String POINTS_PER_QUESTION = "POINTS";
    private final String PENALTY_PER_QUESTION = "PENALTY_POINTS";
    private final String MUSIC_SWITCH_KEY = "MUSIC";
    TextView questionTV, bannerTV;
    ImageView imgQ1;
    String [] pics = new String []{
            "@drawable/pexels_james_wheeler_1519088",
            "@drawable/pexels_matthew_montrone_1324803",
            "@drawable/pexels_max_andrey_1366630",
            "@drawable/pexels_pixabay_36717",
            "@drawable/pexels_stein_egil_liland_1933239",
            "@drawable/pexels_stephan_seeber_1261728",
            "@drawable/pexels_steve_johnson_1269968"};
    Button falseBTN, trueBTN, nextBTN;
    int score;
    //added 7/25
    Question q1,q2,q3,q4,q5,cQ;
    Question [] questions;
    int curNdx;
    String msg;
//
    int penalty = 0;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate: started.");
//
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
//
        String initClr_FBtn = mPreferences.getString(COLOR_KEY_FBtn,"#D30000" );
        String initClr_TBtn = mPreferences.getString(COLOR_KEY_TBtn,"#3BB143" );
        String initClr_NBtn = mPreferences.getString(COLOR_KEY_NBtn,"#222021" );
        String initName = mPreferences.getString(NAME_KEY,"Player");
        Boolean initChkBx = mPreferences.getBoolean(CHECKBOX_KEY,true);
        Boolean initSwMusic = mPreferences.getBoolean(MUSIC_SWITCH_KEY,false);
//
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.jeopardythemesong);
        if (initSwMusic) mp.start();
//
        bannerTV = findViewById(R.id.bannerTV);
        imgQ1 = findViewById(R.id.imgQ1);
        questionTV = findViewById(R.id.questionTV);
        falseBTN = findViewById(R.id.falseBTN);
        trueBTN = findViewById(R.id.trueBTN);
        nextBTN = findViewById(R.id.nextBTN);
        score = 0;
//
        falseBTN.setBackgroundColor(Color.parseColor(initClr_FBtn));
        trueBTN.setBackgroundColor(Color.parseColor(initClr_TBtn));
        nextBTN.setBackgroundColor(Color.parseColor(initClr_NBtn));
//
        String msg1 = getString(R.string.greet1) + initName + "!";
        if (initChkBx) {
            msg1 += getString(R.string.ansAll);
            //enables and disables specific buttons in order to control answering of questions
            setBtns(true,true,false);
        } else {
            msg1 += getString(R.string.canSkip);
            //enables and disables specific buttons in order to control answering of questions
            setBtns(true,true,true);
        }
        bannerTV.setText(msg1);

//
        int initPoints = mPreferences.getInt(POINTS_PER_QUESTION,5);
        penalty = mPreferences.getInt(PENALTY_PER_QUESTION,2);
//
        q1 = new Question(getString(R.string.q1),false);
        q2 = new Question(getString(R.string.q2),false);
        q3 = new Question(getString(R.string.q3),false);
        q4 = new Question(getString(R.string.q4),true);
        q5 = new Question(getString(R.string.q5), false);
        cQ = q1;
        questions = new Question[] {q1,q2,q3,q4,q5};
        msg = "";
//
        //int [] imgRes = new int [pics.length]; decided not to use this added an int the class instead
        for (int i=0; i<questions.length; i++){
            questions[i].setPic(getResources().getIdentifier(pics[i],null,
                    this.getPackageName()));
        }
        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cQ.getCorrectAnswer() && !cQ.isAnswered())
                {
                    msg = getString(R.string.urgtGJ);
                    score+=initPoints;
                }
                else if (cQ.isAnswered())
                {
                    msg = getString(R.string.moMsg);

                }
                else
                {
                    msg = getString(R.string.bMsg);

                }
                cQ.setAnswered(true);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                toast.show();
                setBtns(false, false, true);
            }

        });
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cQ.getCorrectAnswer() && !cQ.isAnswered() )
                {
                    msg = getString(R.string.gMsg);
                    score+=initPoints;
                }
                else if (cQ.isAnswered())
                {
                    msg = getString(R.string.moMsg);

                }
                else
                {
                    msg = getString(R.string.bMsg);

                }
                cQ.setAnswered(true);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                toast.show();
                setBtns(false,false,true);
            }
        });
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curNdx++;
                if(curNdx < 5)
                {
                    cQ = questions[curNdx];
                    imgQ1.setImageResource(cQ.getPic());
                    questionTV.setText(cQ.getqPrompt());
                    if (!cQ.isAnswered()) {
                        setBtns(true, true, !initChkBx);
                    }
                    else
                    {
                        setBtns(false, false, true);
                        msg = getString(R.string.moMsg);
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                        toast.show();
                    }
                }
                else
                {
                    //calculate total time of quiz
                    double totalTime = (System.currentTimeMillis() - startTime)/1000.0;
                    Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    scoreIntent.putExtra("name",initName);
                    scoreIntent.putExtra("score",(int) score);
                    scoreIntent.putExtra("ttlTime",totalTime);
                    if (initSwMusic) mp.stop();
                    startActivity(scoreIntent);
                }
            }
        });

    }
    //enables and disables specific buttons in order to control answering of questions
    private void setBtns(boolean fBtn,boolean tBtn, boolean nBtn){
        falseBTN.setEnabled(fBtn);
        trueBTN.setEnabled(tBtn);
        nextBTN.setEnabled(nBtn);
    }
    @Override
    public void onBackPressed() {
        if (curNdx > 0){
            cQ = questions[--curNdx];
            imgQ1.setImageResource(cQ.getPic());//change image
            questionTV.setText(cQ.getqPrompt());
            if(!cQ.isAnswered()) {
                setBtns(true, true, true);
                score -= penalty;//penalty levied for pressing the backbtn
            }
            else
            {
                setBtns(false, false, true);
                msg = getString(R.string.moMsg);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
                toast.show();
            }
        }
    }
}