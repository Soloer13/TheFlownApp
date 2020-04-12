package com.theflown.theflownapp;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.theflown.theflownapp.adapter.IssueAdapter;
import com.theflown.theflownapp.data.room.Issue;
import com.theflown.theflownapp.data.room.IssueViewModel;
import com.theflown.theflownapp.workers.IssueWorker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.theflown.theflownapp.utils.Utils.mStartActivity;

public class HeldIssueActivity extends AppCompatActivity {

    public static final int ADD_ISSUE_REQUEST = 1;
    public static final int EDIT_ISSUE_REQUEST = 2;
    public static List<String> priority = new ArrayList<String>();
    public static List<String> status = new ArrayList<String>();

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    public static final String EXTRA_ID = "com.theflown.theflown.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.theflown.theflown.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.theflown.theflown.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.theflown.theflown.EXTRA_PRIORITY";
    public static final String EXTRA_SITE = "com.theflown.theflown.EXTRA_SITE";
    public static final String EXTRA_PROJECT = "com.theflown.theflown.EXTRA_PROJECT";
    public static final String EXTRA_PHOTO = "com.theflown.theflown.EXTRA_PHOTO";
    public static final String EXTRA_STATUS = "com.theflown.theflown.EXTRA_STATUS";
    public static final String EXTRA_DATE = "com.theflown.theflown.EXTRA_DATE";
    public static final String EXTRA_OWNER = "com.theflown.theflown.EXTRA_OWNER";

    //private static final int TAKE_PICTURE = 1;
    //private Uri imageUri;
    private IssueViewModel issueViewModel;
    List<Issue> mIssuesList;
    private final String TAG = "HeldIssueActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_held_issue);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG, "OnCreate");


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final IssueAdapter adapter = new IssueAdapter(this, mIssuesList);
        recyclerView.setAdapter(adapter);

        issueViewModel = new ViewModelProvider(this).get(IssueViewModel.class);
        issueViewModel.getAllIssues().observe(this, new Observer<List<Issue>>() {
            @Override
            public void onChanged(List<Issue> issues) {
                Log.d(TAG, "onChanged");
                adapter.setIssues(issues);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                Log.d(TAG, "ButtonAddIssue");
                Intent intent = new Intent(HeldIssueActivity.this, AddIssueActivity.class);
                startActivityForResult(intent, ADD_ISSUE_REQUEST);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        issueViewModel = new ViewModelProvider(this).get(IssueViewModel.class);
        Log.d(TAG, "requestCode: " + requestCode + " resultCode: " + RESULT_OK);
        if (requestCode == ADD_ISSUE_REQUEST && resultCode == RESULT_OK) {
            try {
                Log.d(TAG, "adding record to room database");
                Issue issue = new Issue(data.getStringExtra(EXTRA_TITLE), data.getStringExtra(EXTRA_DESCRIPTION),
                        data.getLongExtra(EXTRA_DATE, 0), data.getStringExtra(EXTRA_PHOTO),
                        data.getLongExtra(EXTRA_PRIORITY, 0), data.getIntExtra(EXTRA_SITE, 0),
                        data.getIntExtra(EXTRA_PROJECT, 0), data.getIntExtra(EXTRA_STATUS, 0),
                        data.getIntExtra(EXTRA_OWNER, 0));
                issueViewModel.insert(issue);

                Log.d(TAG, "done with adding record");

                /*this part for workmanager */
                Data data1 = new Data.Builder()
                        .putString(EXTRA_TITLE, data.getStringExtra(EXTRA_TITLE))
                        .putString(EXTRA_DESCRIPTION, data.getStringExtra(EXTRA_DESCRIPTION))
                        .putLong(EXTRA_DATE, data.getLongExtra(EXTRA_DATE, 0))
                        .putInt(EXTRA_SITE, data.getIntExtra(EXTRA_SITE, 0))
                        .putInt(EXTRA_PROJECT, data.getIntExtra(EXTRA_PROJECT, 0))
                        .putInt(EXTRA_OWNER, data.getIntExtra(EXTRA_OWNER, 0))
                        .putLong(EXTRA_PRIORITY, 1)
                        .putInt(EXTRA_STATUS, 1)
                        .build();

                //creating constraints
                Constraints constraints = new Constraints.Builder()
                        //.setRequiresCharging(true) // you can add as many constraints as you want
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .build();

                //This is the subclass of our WorkRequest
                //final OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
                final OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(IssueWorker.class)
                        .setInputData(data1)
                        .setConstraints(constraints)
                        .build();

                //Enqueuing the work request
                Log.d(TAG, "clicked");
                WorkManager.getInstance().enqueue(workRequest);
                Log.d("MainActivity ", "enqueued");
                /* end of work manager */

                Log.d(TAG, "done adding record and creating workmanager");

            } catch (Exception ex) {
                ex.printStackTrace();
                Log.e(TAG, ex.getMessage());

            }

        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
