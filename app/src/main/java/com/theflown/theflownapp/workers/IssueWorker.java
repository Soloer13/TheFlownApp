package com.theflown.theflownapp.workers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.theflown.theflownapp.R;
import com.theflown.theflownapp.data.web.ApiClient;
import com.theflown.theflownapp.data.web.ApiInterface;
import com.theflown.theflownapp.data.web.IssueModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.theflown.theflownapp.utils.Converters.fromTimestamp;

public class IssueWorker extends Worker {

    //a public static string that will be used as the key
    //for sending and receiving data
    public static final String TASK_DESC = "task_desc";
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

    private static final String TAG = "IssueWorker";


    public IssueWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }


    /*
     * This method is responsible for doing the work
     * so whatever work that is needed to be performed
     * we will put it here
     *
     * For example, here I am calling the method displayNotification()
     * It will display a notification
     * So that we will understand the work is executed
     * */

    @NonNull
    @Override
    public Result doWork() {

        //getting the input data
        String name = getInputData().getString(EXTRA_TITLE);
        String desc = getInputData().getString(EXTRA_DESCRIPTION);
        long issueDate = getInputData().getLong(EXTRA_DATE, -1);
        int site = getInputData().getInt(EXTRA_SITE, -1);
        int project = getInputData().getInt(EXTRA_PROJECT, -1);
        int owner = getInputData().getInt(EXTRA_OWNER, -1);
        long priority = getInputData().getLong(EXTRA_PRIORITY, -1);
        int status = getInputData().getInt(EXTRA_STATUS, -1);


        displayNotification("My Worker", "Hey I finished my work");

        //createOutputData(data);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //Call<List<IssueModel>> call = apiInterface.AddProblem("NewIssue", name, desc, 1, Image,1,2,1,1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateTime = sdf.format(new Date());
//        Call<IssueModel> call = apiInterface.AddIssue(name, desc, "none", fromTimestamp(issueDate), priority, owner, site, project, status);
        Call<IssueModel> call = apiInterface.AddIssue(name, desc, "none", issueDate, priority, owner, site, project, status);

        Log.d("retrofit call", call.toString());
        //call.enqueue(new Callback<List<IssueModel>>() {
        call.enqueue(new Callback<IssueModel>() {
            @Override
            public void onResponse(Call<IssueModel> call, Response<IssueModel> response) {
                IssueModel imageClass = response.body();
                Log.d(TAG, response.isSuccessful() + "");
//                Toast.makeText(IssueWorker.this, imageClass.getResponse()  //come from php
//                        , Toast.LENGTH_LONG).show();
                //kProgressHUD.dismiss();
                Log.d(TAG, "added successfully");
                //mStartActivity(IssueWorker.this, MainActivity.class);
                //(this, MainActivity.class);
                //finish();
            }

            @Override
            public void onFailure(Call<IssueModel> call, Throwable t) {
                //Toast.makeText(IssueWorker.this, "onFailure", Toast.LENGTH_SHORT).show();
                Log.e("hhhhhhhhhhhh1", call.request().toString());
                Log.e("hhhhhhhhhhhh2", t.getLocalizedMessage());
                Log.e("hhhhhhhhhhhh3", t.toString());
                //kProgressHUD.dismiss();
            }
        });


        //return null;
        return Result.success();

    }


    /*
     * The method is doing nothing but only generating
     * a simple notification
     * If you are confused about it
     * you should check the Android Notification Tutorial
     * */
    private void displayNotification(String title, String task) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("simplifiedcoding", "simplifiedcoding", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "simplifiedcoding")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(1, notification.build());
    }
}
