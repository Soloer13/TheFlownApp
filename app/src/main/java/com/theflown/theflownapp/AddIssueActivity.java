package com.theflown.theflownapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.theflown.theflownapp.data.room.Issue;
import com.theflown.theflownapp.data.room.IssueViewModel;
import com.theflown.theflownapp.login.SessionHandler;
import com.theflown.theflownapp.utils.Utils;
import com.theflown.theflownapp.workers.IssueWorker;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import mehdi.sakout.fancybuttons.FancyButton;

import static com.theflown.theflownapp.utils.Converters.dateToTimestamp;
import static com.theflown.theflownapp.utils.Utils.imageToString;
import static com.theflown.theflownapp.utils.Utils.mStartActivity;
import static com.theflown.theflownapp.utils.Utils.startSelectImageIntent;

public class AddIssueActivity extends AppCompatActivity {


    private static final String TAG = "AddIssueActivity";
    public static final int ADD_ISSUE_REQUEST = 1;


    EditText nameTxt, descTxt, siteTxt, projectTxt;
    Spinner prioritySpnr;
    FancyButton chooseImageBtn, submitBtn;
    ImageView imageView;
    private int IMAGEREQ = 99;
    private Bitmap bitmap = null;
    private IssueViewModel issueViewModel;

    private static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private static final String EXTRA_ID = "com.theflown.theflown.EXTRA_ID";
    private static final String EXTRA_TITLE = "com.theflown.theflown.EXTRA_TITLE";
    private static final String EXTRA_DESCRIPTION = "com.theflown.theflown.EXTRA_DESCRIPTION";
    private static final String EXTRA_PRIORITY = "com.theflown.theflown.EXTRA_PRIORITY";
    private static final String EXTRA_SITE = "com.theflown.theflown.EXTRA_SITE";
    private static final String EXTRA_PROJECT = "com.theflown.theflown.EXTRA_PROJECT";
    private static final String EXTRA_PHOTO = "com.theflown.theflown.EXTRA_PHOTO";
    private static final String EXTRA_STATUS = "com.theflown.theflown.EXTRA_STATUS";
    private static final String EXTRA_DATE = "com.theflown.theflown.EXTRA_DATE";
    private static final String EXTRA_OWNER = "com.theflown.theflown.EXTRA_OWNER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_issue);

        Log.d(TAG, "got into AddIssueActivity");

        nameTxt = findViewById(R.id.problemNameTxt);
        descTxt = findViewById(R.id.problemDescTxt);
        prioritySpnr = findViewById(R.id.problemPrioritySpnr);
        siteTxt = findViewById(R.id.problemSiteTxt);
        projectTxt = findViewById(R.id.problemProjectTxt);

        imageView = findViewById(R.id.problemImgView);


        chooseImageBtn = findViewById(R.id.problemChooseImgBtn);
        submitBtn = findViewById(R.id.problemSubmitBtn);

        chooseImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "chooseImageBtn was clicked");
                startSelectImageIntent(AddIssueActivity.this, IMAGEREQ); //what is IMAGEREQ?
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final KProgressHUD kProgressHUD = KProgressHUD.create(AddIssueActivity.this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setLabel("Please wait")
                        .setDetailsLabel("Uploading data")
                        .setCancellable(true)
                        .setAnimationSpeed(2)
                        .setDimAmount(0.5f)
                        .show();
                kProgressHUD.dismiss();

                Log.d(TAG, "submitBtn was clicked");

                Log.d(TAG, "problemsumitbtn");
                Intent replyIntent = new Intent();

                String name = nameTxt.getText().toString();
                replyIntent.putExtra(EXTRA_TITLE, name);

                String desc = descTxt.getText().toString();
                replyIntent.putExtra(EXTRA_DESCRIPTION, desc);


                long priority = prioritySpnr.getSelectedItemId();
                replyIntent.putExtra(EXTRA_PRIORITY, priority);
                Log.d(TAG, priority + " priority");

                String site = siteTxt.getText().toString();
                int siteValue = 0;
                if (!"".equals(site)) {
                    siteValue = Integer.parseInt(site);
                    Log.d(TAG, "site Value: " + siteValue);
                }
                replyIntent.putExtra(EXTRA_SITE, siteValue);

                String project = projectTxt.getText().toString();
                int projectValue = 0;
                if (!"".equals(project)) {
                    projectValue = Integer.parseInt(project);
                    Log.d(TAG, "project value: " + projectValue);
                }
                replyIntent.putExtra(EXTRA_PROJECT, projectValue);


                replyIntent.putExtra(EXTRA_STATUS, "1"); //this is the default status

                //the following should get the current owner id
                SessionHandler session = new SessionHandler(getApplicationContext());

                if (session.getUserDetails() == null)
                    Log.d(TAG, "the issue in the get object");

                Log.d(TAG, "the user logged in " + session.offLineLoggIn());
                int owner = session.getUserDetails().getUserId();
                Log.d(TAG, "owner " + session.getUserDetails() /*.getUserId() */);
                replyIntent.putExtra(EXTRA_OWNER, owner);

                //Date gets the current date of creating new record
                Long currentDate = dateToTimestamp(Calendar.getInstance().getTime());

                //suppose to get the current date, watch it not tested yet!
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                //Long issueDate = dateToTimestamp(sdf); //not working due to simpledateformat
                Date currentdate = Calendar.getInstance().getTime();
                Long issueDate = dateToTimestamp(currentdate);
                Log.d(TAG, issueDate.toString()); //this is not tested yet
                Log.d(TAG, currentDate.toString());
                replyIntent.putExtra(EXTRA_DATE, issueDate);


                setResult(RESULT_OK, replyIntent);

                Log.d(TAG, "finished ");

//                startActivityForResult(ADD_ISSUE_REQUEST, replyIntent);
//                mStartActivity(AddIssueActivity.this, MainActivity.class);


//                try {
//                    Issue newIssue = new Issue(name, desc, issueDate, "none", priority,
//                            siteValue, projectValue, 1, owner);
//
////                    Issue newIssue = new Issue("name", "desc", 1, "none", 1,
////                            2,3,4,5);
//                    Log.d(TAG, "newIssue name "+ newIssue.getIssueName());
//                    Log.d(TAG, "object " + newIssue);
//                    issueViewModel.insert(newIssue);
//
//
//                    /*this part for workmanager */
//                    Data data1 = new Data.Builder()
//                            .putString(EXTRA_TITLE, name)
//                            .putString(EXTRA_DESCRIPTION, desc)
//                            .putLong(EXTRA_DATE, issueDate)
//                            .putInt(EXTRA_SITE, siteValue)
//                            .putInt(EXTRA_PROJECT, projectValue)
//                            .putInt(EXTRA_OWNER, owner)
//                            .putLong(EXTRA_PRIORITY, priority)
//                            .putInt(EXTRA_STATUS, 1)
//                            .build();
//
//                    //creating constraints
//                    Constraints constraints = new Constraints.Builder()
//                            //.setRequiresCharging(true) // you can add as many constraints as you want
//                            .setRequiredNetworkType(NetworkType.CONNECTED)
//                            .build();
//
//                    //This is the subclass of our WorkRequest
//                    //final OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
//                    final OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(IssueWorker.class)
//                            .setInputData(data1)
//                            .setConstraints(constraints)
//                            .build();
//
//                    //Enqueuing the work request
//                    Log.d(TAG, "clicked");
//                    //WorkManager.getInstance().enqueue(workRequest);
//                    Log.d("MainActivity ", "enqueued");
//                    /* end of work manager */
//
//                    Log.d(TAG, "going to MainActivity from AddIssueActivity");
//                    mStartActivity(AddIssueActivity.this, MainActivity.class);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                    Log.e(TAG, ex.getMessage());
//
//                }
//
//
//                String Image = "none"; //this refers to no image
//                if (bitmap != null) Image = imageToString(bitmap);
//
//
//                //Issue(String issueName, String issueDescription, Long issueDate, String photo, long issuePriority, int issueSite, int issueProject, int issueStatus, int issueOwner)
//                //Toast.makeText(AddIssueActivity.this, priority + "  " + prioritySpnr.getSelectedItemId(), Toast.LENGTH_LONG).show();
//
//                //Get the current date
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//                String currentDateTime = sdf.format(new Date());


//                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//                //Call<List<IssueModel>> call = apiInterface.AddProblem("NewIssue", name, desc, 1, Image,1,2,1,1);
//
//                Call<IssueModel> call = apiInterface.AddIssue(name, desc, Image, currentDateTime,1,2,1,1, 1);
//
//                Log.d("retrofit call", call.toString());
//                //call.enqueue(new Callback<List<IssueModel>>() {
//                call.enqueue(new Callback<IssueModel>() {
//                    @Override
//                    public void onResponse(Call<IssueModel> call, Response<IssueModel> response) {
//                        IssueModel imageClass = response.body();
//                        Toast.makeText(AddIssueActivity.this, imageClass.getResponse() //come from php
//                                , Toast.LENGTH_LONG).show();
//                        kProgressHUD.dismiss();
//                        Log.d(TAG, "added successfully");
//                        mStartActivity(AddIssueActivity.this,MainActivity.class);
//                        finish();
//                    }
//
//                    @Override
//                    public void onFailure(Call<IssueModel> call, Throwable t) {
//                        Toast.makeText(AddIssueActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
//                        Log.e("hhhhhhhhhhhh1",call.request().toString());
//                        Log.e("hhhhhhhhhhhh2",t.getLocalizedMessage());
//                        Log.e("hhhhhhhhhhhh3",t.toString());
//                        kProgressHUD.dismiss();
//                    }
//                });


//                    @Override
//                    public void onResponse(Call<List<IssueModel>> call, Response<List<IssueModel>> response) {
//                        List<IssueModel> imageClass = response.body();
////                        Toast.makeText(AddIssueActivity.this, imageClass.getResponse() //come from php
////                                , Toast.LENGTH_LONG).show();
//                        kProgressHUD.dismiss();
//
//                        mStartActivity(AddIssueActivity.this,MainActivity.class);
//                        finish();
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<IssueModel>> call, Throwable t) {
//                        Toast.makeText(AddIssueActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
//                        Log.e("hhhhhhhhhhhh1",call.request().toString());
//                        Log.e("hhhhhhhhhhhh2",t.getLocalizedMessage());
//                        Log.e("hhhhhhhhhhhh3",t.toString());
//                        kProgressHUD.dismiss();
//                    }

//                    @Override
//                    public void onFailure(Call<IssueModel> call, Throwable t) {
//
//                    }
//                });

                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGEREQ && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
                //submitBtn.setEnabled(true); //this is for set submit Button Enabled when there is image!!
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //this function for saving image as a string into internalStorage and save the file name and path to room DB
    private void saveImage(Issue issue, String count) {

//        if (Utils.saveImageToInternalStorage(getApplicationContext(), bitmap, placename.getSelectedItem().toString() + count)) {
//            user.setThumbnail(String.valueOf(getFileStreamPath(placename.getSelectedItem().toString() + count)));
//            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show();
//            AppDatabase.getAppDatabase(getApplicationContext()).userDao().insertAll(user);
//            Toast.makeText(getApplicationContext(), "" + AppDatabase.getAppDatabase(getApplicationContext()).userDao().countusers(), Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
//        }

    }
}
