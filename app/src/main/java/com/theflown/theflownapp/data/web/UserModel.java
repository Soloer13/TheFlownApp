package com.theflown.theflownapp.data.web;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("userId")
    @Expose
    private int userId;

    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("userSite")
    @Expose
    private int userSite;

    @SerializedName("userPassword")
    @Expose
    private String userPassword;

    @SerializedName("userProject")
    @Expose
    private int userProject;

    @SerializedName("userPrivilege")
    @Expose
    private int userPrivilege;

    @SerializedName("createdOn")
    @Expose
    private String createdOn;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getUserProject() {
        return userProject;
    }

    public void setUserProject(int userProject) {
        this.userProject = userProject;
    }

    public int getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(int userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    public int getUserSite() {
        return userSite;
    }

    public void setUserSite(int userSite) {
        this.userSite = userSite;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
