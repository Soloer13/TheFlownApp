package com.theflown.theflownapp.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.theflown.theflownapp.data.web.ApiClient;
import com.theflown.theflownapp.data.web.ApiInterface;
import com.theflown.theflownapp.data.web.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.theflown.theflownapp.data.web.ApiClient.*;

public class SessionHandler {

    private final String TAG = "SessionHandler";

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "userpassword";
    private static final String KEY_ID = "userid";
    private static final String KEY_SITE = "usersite";
    private static final String KEY_PROJECT = "userproject";
    private static final String KEY_PRIVILEGE = "userprivilege";
    private static final String PREF_NAME = "UserSession";
    private static final String KEY_EXPIRES = "expires";
    private static final String KEY_EMPTY = "";

    private static boolean isLoggedIn = false;

//    private static final String KEY_FULL_NAME = "full_name";

    private Context mContext;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;

    public SessionHandler(Context mContext) {
        this.mContext = mContext;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mPreferences.edit();
    }

//    /**
//     * Logs in the user by saving user details and setting session
//     *
//     * @param username
//     * @param userpassword
//     */
//    public void loginUser(final String username, final String userpassword) {
//        //Creating an object of our api interface
//        ApiInterface apiInterface = getClient().create(ApiInterface.class);
//
//        final KProgressHUD kProgressHUD=KProgressHUD.create(SessionHandler.this)
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                .setLabel("Please wait")
//                .setDetailsLabel("Uploading data")
//                .setCancellable(true)
//                .setAnimationSpeed(2)
//                .setDimAmount(0.5f)
//                .show();
//
////        final ProgressDialog dialog;
////        /**
////         * Progress Dialog for User Interaction
////         */
////        dialog = new ProgressDialog(SessionHandler.this);
////        dialog.setTitle("Login");
////        dialog.setMessage("Please Wait...");
////        dialog.show();
//
//        Call<UserModel> call = apiInterface.loginUser(new User(username, userpassword));
//        Log.d("retrofit call", call.toString());
//
//        try {
//
//            Response<UserModel> response = call.execute();
//            UserModel loginResponse = response.body();
//            Log.d(TAG, "Login success, welcome " + loginResponse.getUserId());
//
//        } catch (Exception ex) {
//            Log.d(TAG, "login failed ");
//            ex.printStackTrace();
//
//            Log.e("hhhhhhhhhhhh1", call.request().toString());
//            Log.e("hhhhhhhhhhhh2", ex.getLocalizedMessage());
//            Log.e("hhhhhhhhhhhh3", ex.toString());
//        }
//
////        call.enqueue(new Callback<UserModel>() {
////
////            @Override
////            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
////                UserModel userClass = response.body();
////                Log.d(TAG, userClass.toString());
////                mEditor.putString(KEY_USERNAME, username);
////                mEditor.putString(KEY_PASSWORD, userpassword);
////                Log.d(TAG, userClass.getUserName());
////                mEditor.putInt(KEY_ID, userClass.getUserId());
////                mEditor.putInt(KEY_SITE, userClass.getUserSite());
////                mEditor.putInt(KEY_PROJECT, userClass.getUserProject());
////                mEditor.putInt(KEY_PRIVILEGE, userClass.getUserPrivilege());
////
////                mEditor.commit();
////                Log.d(TAG, "UserId " + userClass.getUserId() + "");
//////                Toast.makeText(SessionHandler.this, "Login sucessfully "+userClass.getUserId(), Toast.LENGTH_LONG).show();
////            }
////
////            @Override
////            public void onFailure(Call<UserModel> call, Throwable t) {
////                //Toast.makeText(SessionHandler.this, "onFailure", Toast.LENGTH_SHORT).show();
////                Log.e("hhhhhhhhhhhh1", call.request().toString());
////                Log.e("hhhhhhhhhhhh2", t.getLocalizedMessage());
////                Log.e("hhhhhhhhhhhh3", t.toString());
////            }
////        });
//    }

    /**
     * For offline Login just checking if there is a used assigned
     */
    public boolean offLineLoggIn() {
        if (mPreferences.getInt(KEY_ID, -1) != -1) {
            Log.d(TAG, "ID " + mPreferences.getInt(KEY_ID, -1) + "");
            Log.d(TAG, "User " + mPreferences.getString(KEY_USERNAME, KEY_EMPTY) + "");
            Log.d(TAG, "Password " + mPreferences.getString(KEY_PASSWORD, KEY_PASSWORD) + "");
            Log.d(TAG, "Site " + mPreferences.getInt(KEY_SITE, -1) + "");
            Log.d(TAG, "Project " + mPreferences.getInt(KEY_PROJECT, -1) + "");
            Log.d(TAG, "Privilege " + mPreferences.getInt(KEY_PRIVILEGE, -1) + "");
            return true;
        } else
            return false;
    }


    /**
     * Checks whether user is logged in
     *
     * @return
     */
    public boolean isLoggedIn() {
        if (mPreferences.getInt(KEY_ID, -1) != -1) {
            Log.d(TAG, "there is a user's data saved in shared memory");
            ApiInterface apiInterface = getClient().create(ApiInterface.class);

            String username = mPreferences.getString(KEY_USERNAME, KEY_EMPTY);
            String password = mPreferences.getString(KEY_PASSWORD, KEY_EMPTY);

            Call<UserModel> call = apiInterface.loginUser(new User(username, password));

            Log.d("retrofit call", call.toString());

            call.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    UserModel userClass = response.body();
                    setLoggedIn(true);
                    Log.d(TAG, "the user is logged in..");
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    setLoggedIn(false);
                    mEditor.remove(KEY_ID); // will delete key KEY_ID
                    mEditor.remove(KEY_USERNAME); // will delete key KEY_USERNAME
                    mEditor.remove(KEY_PASSWORD); // will delete key KEY_PASSWORD
                    mEditor.remove(KEY_SITE); // will delete key KEY_SITE
                    mEditor.remove(KEY_PROJECT); // will delete key KEY_PROJECT
                    mEditor.remove(KEY_PRIVILEGE); // will delete key KEY_PRIVILEGE

                    mEditor.commit();

                    Log.d(TAG, "the user is not logged in!");
                    Log.e("hhhhhhhhhhhh1", call.request().toString());
                    Log.e("hhhhhhhhhhhh2", t.getLocalizedMessage());
                    Log.e("hhhhhhhhhhhh3", t.toString());
                }
            });
        }
        Log.d(TAG, "isLoggedIn: " + isLoggedIn);
        return isLoggedIn;
    }

//    //this is following the below answer on StackOverFlow
//    //https://stackoverflow.com/questions/51914757/retrofit-return-boolean-value/51914912
//    public boolean isLoggedIn(){
//        Boolean logged;
//        isLoggedIn(new ApiCallback() {
//
//            @Override
//            public void onResponse(boolean success) {
//                if(success){
//                    logged = true;
//                }
//                else{
//                    logged = false;
//                }
//            }
//        });
//        Log.d(TAG, )
//        return logged;
//    }

    /**
     * Fetches and returns user details
     *
     * @return user details
     */
    public UserModel getUserDetails() {
        //Check if user is logged in first
        if (offLineLoggIn() == false) { //this is called everytime getting getUserDetails
            return null;
        }

        UserModel user = new UserModel();
        user.setUserId(mPreferences.getInt(KEY_ID, -1));
        user.setUserName(mPreferences.getString(KEY_USERNAME, KEY_EMPTY));
        user.setUserPassword(mPreferences.getString(KEY_PASSWORD, KEY_EMPTY));
        user.setUserSite(mPreferences.getInt(KEY_SITE, -1));
        user.setUserProject(mPreferences.getInt(KEY_PROJECT, -1));
        user.setUserPrivilege(mPreferences.getInt(KEY_PRIVILEGE, -1));

        return user;
    }

    public void setUserDetails(UserModel userClass, String password){
        mEditor.putString(KEY_USERNAME, userClass.getUserName());
        Log.d(TAG, userClass.getUserName());
        mEditor.putString(KEY_PASSWORD, password);
        Log.d(TAG, password);
        mEditor.putInt(KEY_ID, userClass.getUserId());
        Log.d(TAG, userClass.getUserId() +" id");
        mEditor.putInt(KEY_SITE, userClass.getUserSite());
        Log.d(TAG, userClass.getUserSite() + " site");
        mEditor.putInt(KEY_PROJECT, userClass.getUserProject());
        Log.d(TAG, userClass.getUserProject() + " project");
        mEditor.putInt(KEY_PRIVILEGE, userClass.getUserPrivilege());
        Log.d(TAG, userClass.getUserPrivilege() + " privilege");

        mEditor.commit();
    }

    /**
     * Logs out user by clearing the session
     */
    public void logoutUser() {
        //this will clear all saved data no matter its login or other data keep this in mind!
        mEditor.clear();
        mEditor.commit();
    }

    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
    }

    public boolean getLoggedIn() {
        return this.isLoggedIn;
    }
}
