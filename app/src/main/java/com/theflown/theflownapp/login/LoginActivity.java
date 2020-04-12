package com.theflown.theflownapp.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.theflown.theflownapp.MainActivity;
import com.theflown.theflownapp.R;
import com.theflown.theflownapp.data.web.ApiInterface;
import com.theflown.theflownapp.data.web.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.theflown.theflownapp.data.web.ApiClient.getClient;
import static com.theflown.theflownapp.utils.Utils.mStartActivity;

public class LoginActivity extends AppCompatActivity {

    private final String TAG = "LoginActivity";
    EditText username, password;
    Button login, logout, toMain;
    private  static SessionHandler session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionHandler(getApplicationContext());
        final UserModel user = new UserModel();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        logout = findViewById(R.id.logout);
        toMain = findViewById(R.id.toMainActivity);


//        if (session.isLoggedIn()) {
        if(session.getUserDetails() != null){
            Log.d(TAG, "is logged in");
            session.getUserDetails();
            Log.d(TAG, user.getUserId() + "");
            Log.d(TAG, user.getUserName());
            Log.d(TAG, user.getUserPassword());

            if (user.getUserPrivilege() == 1) {
                logout.setVisibility(View.VISIBLE);
                toMain.setVisibility(View.VISIBLE);
            } else {
                logout.setVisibility(View.GONE);
                toMain.setVisibility(View.GONE);
            }

            mStartActivity(LoginActivity.this, MainActivity.class);
        } else {

            Log.d(TAG, "new login");


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginUser(username.getText().toString(), password.getText().toString());
                    Log.d(TAG, "got back from sessionHandler class");
                    if (session.isLoggedIn()) {
                        Log.d(TAG,"Log is was success");
                        //if there is user logged in get this user's details
                        UserModel userModel= session.getUserDetails();
                        String userName = userModel.getUserName();
                        String password = userModel.getUserPassword();

                        Log.d(TAG, "userName " + userName);
                        Log.d(TAG, "password " + password);

                        mStartActivity(LoginActivity.this, MainActivity.class);
                    }
                    else
                        Log.d(TAG, "Login Failed, try again");
                        Toast.makeText(getApplicationContext(), "Login Failed, try again", Toast.LENGTH_LONG).show();

                }
            });
        }
    }


    /**
     * Logs in the user by saving user details and setting session
     *
     * @param username
     * @param userpassword
     */
    public void loginUser(final String username, final String userpassword) {
        //Creating an object of our api interface
        ApiInterface apiInterface = getClient().create(ApiInterface.class);

        final KProgressHUD kProgressHUD=KProgressHUD.create(LoginActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("logging in")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);
                //.show();

//        final ProgressDialog dialog;
//        /**
//         * Progress Dialog for User Interaction
//         */
//        dialog = new ProgressDialog(SessionHandler.this);
//        dialog.setTitle("Login");
//        dialog.setMessage("Please Wait...");
//        dialog.show();

        Call<UserModel> call = apiInterface.loginUser(new User(username, userpassword));
        kProgressHUD.show();
        Log.d("retrofit call", call.toString());

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

        call.enqueue(new Callback<UserModel>() {

            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                UserModel userClass = response.body();
                Log.d(TAG, userClass.toString());

                Log.d(TAG, "UserId " + userClass.getUserId() + "");
                Toast.makeText(LoginActivity.this, "Login sucessfully "+userClass.getUserId(), Toast.LENGTH_LONG).show();
                session.setUserDetails(userClass, userpassword);
                Log.d(TAG, "done with privateStorage");

                finish();
                kProgressHUD.dismiss();
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                finish();
                kProgressHUD.dismiss();
                //Toast.makeText(SessionHandler.this, "onFailure", Toast.LENGTH_SHORT).show();
                Log.e("hhhhhhhhhhhh1", call.request().toString());
                Log.e("hhhhhhhhhhhh2", t.getLocalizedMessage());
                Log.e("hhhhhhhhhhhh3", t.toString());
            }
        });
    }

}
