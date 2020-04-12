package com.theflown.theflownapp.data.web;


import com.theflown.theflownapp.login.User;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


    /* Issues ... IssueModel class */
    @FormUrlEncoded
    //@Headers("Content-Type: application/json")
    @POST("Issues.php")
    Call<IssueModel> AddProblem(@Field("issueType") String Type,
                                //Call<ProblemModel> AddProblem(
                                @Field("issueName") String Name,
                                @Field("issueDescription") String Desc,
                                @Field("issueStatus") int Status,
                                @Field("issuePhoto") String Photo,
                                @Field("issueSite") int Site,
                                @Field("issueProject") int Project,
                                @Field("issueOwner") int Owner,
                                @Field("issuePriority") int Priority);

    @FormUrlEncoded
    @POST("add_issue.php")
    Call<IssueModel> AddIssue(@Field("issueName") String Name,
                              @Field("issueDescription") String Desc,
                              @Field("issuePhoto") String Photo,
                              @Field("issueDate") long date, //this is changed
                              @Field("issuePriority") long Priority,
                              @Field("issueOwner") int Owner,
                              @Field("issueSite") int Site,
                              @Field("issueProject") int Project,
                              @Field("issueStatus") int Status);

    //@FormUrlEncoded
    @GET("get_all_issues.php")
    //Call<List<IssueModel>> GetAllProblems(@Query("issueType") String Type);
    Call<List<IssueModel>> GetAllProblems();


    @GET("get_issue.php")
    Call<IssueModel> GetIssue(@Query("issue_id") int Id);

    @FormUrlEncoded
    @POST("Problems.php")
    Call<List<IssueModel>> getAllProblems(@Field("problemType") String Type);
    //this one from problem model which is?


    /* Users ... UserModel class */
    @Headers("Content-Type: application/json")
    @POST("login.php")
    Call<UserModel> loginUser(@Body User user); //not completed yet!
}
