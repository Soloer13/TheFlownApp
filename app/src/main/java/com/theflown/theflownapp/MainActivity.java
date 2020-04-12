package com.theflown.theflownapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.theflown.theflownapp.login.LoginActivity;
import com.theflown.theflownapp.login.SessionHandler;

import mehdi.sakout.fancybuttons.FancyButton;

import static com.theflown.theflownapp.utils.Utils.mStartActivity;

public class MainActivity extends AppCompatActivity {

    //private Constant fields
    private final String TAG = "MainActivity";
    FancyButton addNewProblem,showHeldProblems,showOldProblems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d(TAG, "will move to addissueActivity ");
//        mStartActivity(MainActivity.this, AddIssueActivity.class); //this line is ignored

        Log.d(TAG, "done with AddIssueActivity");

        SessionHandler session = new SessionHandler(getApplicationContext());

        //there is a user logged in, didn't specify if it's correct or not yet!
        if(session.offLineLoggIn()){
            Log.d(TAG, "there is user logged in, offLineLoggIn");
            Toast.makeText(this, "there is a user logged in", Toast.LENGTH_LONG).show();

            Log.d(TAG, "there is user logged in, offLineLoggIn");
            addNewProblem=findViewById(R.id.newProblemsBtn);
            showOldProblems=findViewById(R.id.oldProblemsBtn);
            showHeldProblems=findViewById(R.id.HeldProblemsBtn);

            addNewProblem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mStartActivity(MainActivity.this, AddIssueActivity.class);
                }
            });

            showHeldProblems.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mStartActivity(MainActivity.this, HeldIssueActivity.class);
                }
            });

            showOldProblems.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mStartActivity(MainActivity.this, LoginActivity.class);
                }
            });

        }
        else{
            Log.d(TAG, "no users logged in");
            mStartActivity(MainActivity.this, LoginActivity.class);
        }


    }
}
