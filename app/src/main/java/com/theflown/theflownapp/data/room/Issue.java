package com.theflown.theflownapp.data.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "issue_table")
public class Issue {


    public Issue(String issueName, String issueDescription, long issueDate, String photo, long issuePriority
            , int issueSite, int issueProject, int issueStatus, int issueOwner) {
        this.issueName = issueName;
        this.issueDescription = issueDescription;
        this.issueDate = issueDate;
        this.photo = photo;
        this.issuePriority = issuePriority;
        this.issueSite = issueSite;
        this.issueProject = issueProject;
        this.issueStatus = issueStatus;
        this.issueOwner = issueOwner;
    }

//    public Issue(String issueName, String issueDescription, Date date, String photo, long issuePriority
//            , int issueSite, int issueProject, int issueStatus, int issueOwner) {
//        this.issueName = issueName;
//        this.issueDescription = issueDescription;
//        this.date = date;
//        this.photo = photo;
//        this.issuePriority = issuePriority;
//        this.issueSite = issueSite;
//        this.issueProject = issueProject;
//        this.issueStatus = issueStatus;
//        this.issueOwner = issueOwner;
//    }

    @PrimaryKey(autoGenerate = true)
//    @NonNull
    private int id;

    @ColumnInfo(name = "issueName")
    private String issueName;

    @ColumnInfo(name = "issueDescription")
    private String issueDescription;

    @ColumnInfo(name = "issueDate")
    private Long issueDate;

//    private Date date;

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    @ColumnInfo(name = "issuePhoto")
    //private Bitmap photo;
    private String photo;


    @ColumnInfo(name = "issuePriority")
    private long issuePriority;

    @ColumnInfo(name = "issueOwner")
    private int issueOwner;

    @ColumnInfo(name = "issueSite")
    private int issueSite;

    @ColumnInfo(name = "issueProject")
    private int issueProject;

    @ColumnInfo(name = "issueStatus")
    private int issueStatus;

    @ColumnInfo(name = "issueSolverId")
    private int issueSolverId;

    @ColumnInfo(name = "issueSolveDate")
    private Long issueSolveDate;

    @ColumnInfo(name = "Response")
    private String Response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(@NonNull String issueName) {
        this.issueName = issueName;
    }

    @NonNull
    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(@NonNull String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @NonNull
    public Long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(@NonNull Long issueDate) {
        this.issueDate = issueDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getIssuePriority() {
        return issuePriority;
    }

    public void setIssuePriority(long issuePriority) {
        this.issuePriority = issuePriority;
    }

    public int getIssueOwner() {
        return issueOwner;
    }

    public void setIssueOwner(int issueOwner) {
        this.issueOwner = issueOwner;
    }

    public int getIssueSite() {
        return issueSite;
    }

    public void setIssueSite(int issueSite) {
        this.issueSite = issueSite;
    }

    public int getIssueProject() {
        return issueProject;
    }

    public void setIssueProject(int issueProject) {
        this.issueProject = issueProject;
    }

    public int getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(int issueStatus) {
        this.issueStatus = issueStatus;
    }

    public int getIssueSolverId() {
        return issueSolverId;
    }

    public void setIssueSolverId(int issueSolverId) {
        this.issueSolverId = issueSolverId;
    }

    public Long getIssueSolveDate() {
        return issueSolveDate;
    }

    public void setIssueSolveDate(Long issueSolveDate) {
        this.issueSolveDate = issueSolveDate;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
