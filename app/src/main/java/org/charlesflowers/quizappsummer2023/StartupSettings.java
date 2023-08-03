package org.charlesflowers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TintableCompoundButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class StartupSettings extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private final String sharedPrefFile = "org.codeintheschools.android.unit3_lesson1_a";
    private  final String COLOR_KEY_FBtn = "COLOR_FBtn";
    private final String COLOR_KEY_TBtn = "COLOR_TBtn";
    private  final String COLOR_KEY_NBtn = "COLOR_NBtn";
    private  final String NAME_KEY = "NAME";
    private  final String CHECKBOX_KEY = "CHKBX";
    private final String POINTS_PER_QUESTION = "POINTS";
    private final String PENALTY_PER_QUESTION = "PENALTY_POINTS";
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_settings);
//
        EditText nameET, pointsET, penaltyET;
//
        RadioButton rbR_FB,rbGrn_FB,rbBlu_FB,rbBlk_FB;
        RadioButton rbR_TB,rbGrn_TB,rbBlu_TB,rbBlk_TB;
        RadioButton rbR_NB,rbGrn_NB,rbBlu_NB,rbBlk_NB;
//
        CheckBox checkBox;
//
        Button saveBtn;
//
        nameET = findViewById(R.id.nameET);
        pointsET = findViewById(R.id.pointsET);
        penaltyET = findViewById(R.id.penaltyET);
//
        rbR_FB = findViewById(R.id.rbR_FB);
        rbGrn_FB = findViewById(R.id.rbGrn_FB);
        rbBlu_FB = findViewById(R.id.rbBlu_FB);
        rbBlk_FB = findViewById(R.id.rbBlk_FB);
//
        rbR_TB = findViewById(R.id.rbR_TB);
        rbGrn_TB = findViewById(R.id.rbGrn_TB);
        rbBlu_TB = findViewById(R.id.rbBlu_TB);
        rbBlk_TB = findViewById(R.id.rbBlk_TB);
//
        rbR_NB = findViewById(R.id.rbR_NB);
        rbGrn_NB = findViewById(R.id.rbGrn_NB);
        rbBlu_NB = findViewById(R.id.rbBlu_NB);
        rbBlk_NB = findViewById(R.id.rbBlk_NB);
//

        checkBox = findViewById(R.id.checkBox);
//
        saveBtn = findViewById(R.id.saveBTN);
//
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
//
        String initClr_FBtn = mPreferences.getString(COLOR_KEY_FBtn,"D30000" );
        String initClr_TBtn = mPreferences.getString(COLOR_KEY_TBtn,"#3BB143" );
        String initClr_NBtn = mPreferences.getString(COLOR_KEY_NBtn,"#222021" );
        String initName = mPreferences.getString(NAME_KEY,"");
        Boolean initChkBx = mPreferences.getBoolean(CHECKBOX_KEY,true);
        int initPoints = mPreferences.getInt(POINTS_PER_QUESTION,5);
        int initPenalty = mPreferences.getInt(PENALTY_PER_QUESTION,2);

//
        nameET.setText(initName);
//.
        checkBox.setChecked(initChkBx);
//
        pointsET.setText(Integer.toString(initPoints));
        penaltyET.setText(Integer.toString(initPenalty));

        //Set radio buttons to saved mPreference or default values
        switch (initClr_FBtn) {
            case "#D30000":
                rbR_FB.setChecked(true);
                //Log.d(null,"Red");
                break;
            case "#3BB143":
                rbGrn_FB.setChecked(true);
                break;
            case "#0018F9":
                rbBlu_FB.setChecked(true);
                break;
            case "#222021":
                rbBlk_FB.setChecked(true);
                break;
        }
//
        switch (initClr_TBtn) {
            case "#D30000":
                rbR_TB.setChecked(true);
                //Log.d(null,"Red");
                break;
            case "#3BB143":
                rbGrn_TB.setChecked(true);
                break;
            case "#0018F9":
                rbBlu_TB.setChecked(true);
                break;
            case "#222021":
                rbBlk_TB.setChecked(true);
                break;
        }

        switch (initClr_NBtn) {
                case "#D30000":
                    rbR_NB.setChecked(true);
                    //Log.d(null,"Red");
                    break;
                case "#3BB143":
                    rbGrn_NB.setChecked(true);
                    break;
                case "#0018F9":
                    rbBlu_NB.setChecked(true);
                    break;
                case "#222021":
                    rbBlk_NB.setChecked(true);
                    break;
        }

        //Created SharedPreferences editor object
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        //if (rbR_FB)

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                if (rbR_FB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_FBtn,"@color/red" );
                    preferencesEditor.putString(COLOR_KEY_FBtn,"#D30000" );
                }
                else if (rbGrn_FB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_FBtn,"@color/green" );
                    preferencesEditor.putString(COLOR_KEY_FBtn,"#3BB143" );
                }
                else if (rbBlu_FB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_FBtn,"@color/blue" );
                    preferencesEditor.putString(COLOR_KEY_FBtn,"#0018F9" );
                }
                else if (rbBlk_FB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_FBtn,"@color/dark_gray" );
                    preferencesEditor.putString(COLOR_KEY_FBtn,"#222021" );
                }
//
                if (rbR_TB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_TBtn,"@color/red" );
                    preferencesEditor.putString(COLOR_KEY_TBtn,"#D30000" );
                }
                else if (rbGrn_TB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_TBtn,"@color/green" );
                    preferencesEditor.putString(COLOR_KEY_TBtn,"#3BB143" );
                }
                else if (rbBlu_TB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_TBtn,"@color/blue" );
                    preferencesEditor.putString(COLOR_KEY_TBtn,"#0018F9" );
                }
                else if (rbBlk_TB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_TBtn,"@color/dark_gray" );
                    preferencesEditor.putString(COLOR_KEY_TBtn,"#222021" );
                }
//
                if (rbR_NB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_NBtn,"@color/red" );
                    preferencesEditor.putString(COLOR_KEY_NBtn,"#D30000" );
                }
                else if (rbGrn_NB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_NBtn,"@color/green" );
                    preferencesEditor.putString(COLOR_KEY_NBtn,"#3BB143" );
                }
                else if (rbBlu_NB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_NBtn,"@color/blue" );
                    preferencesEditor.putString(COLOR_KEY_NBtn,"#0018F9" );

                }
                else if (rbBlk_NB.isChecked()) {
                    //preferencesEditor.putString(COLOR_KEY_NBtn,"@color/dark_gray" );
                    preferencesEditor.putString(COLOR_KEY_NBtn,"#222021" );
                }
                //if (!initName.equals(nameET.getText())){
                preferencesEditor.putString(NAME_KEY,nameET.getText().toString());
                //}
                preferencesEditor.putBoolean(CHECKBOX_KEY,checkBox.isChecked());
                //
                preferencesEditor.putInt(POINTS_PER_QUESTION,Integer.parseInt(pointsET.getText().toString()));
                //}
                preferencesEditor.putInt(PENALTY_PER_QUESTION,Integer.parseInt(penaltyET.getText().toString()));
                //Commit the value and save the file.
                preferencesEditor.apply();
                //
                Intent intent = new Intent(StartupSettings.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}