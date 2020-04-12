package com.theflown.theflownapp.data.web;

import java.util.Date;
import java.util.Date;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class IssueModel {

    @SerializedName("issueId")
    @Expose
    private int issueId;
    @SerializedName("issueName")
    @Expose
    private String issueName;

    @SerializedName("issueDescription")
    @Expose
    private String issueDescription;

    @SerializedName("issuePhoto")
    @Expose
    private String issuePhoto;

    @SerializedName("issueDate")
    @Expose
//    private Date issueDate;
    private String issueDate;


    @SerializedName("issuePriority")
    @Expose
    private int issuePriority;

    @SerializedName("issueOwner")
    @Expose
    private String issueOwner;

    @SerializedName("issueSite")
    @Expose
    private String issueSite;

    @SerializedName("issueProject")
    @Expose
    private String issueProject;

    @SerializedName("issueStatus")
    @Expose
    private int issueStatus;

    @SerializedName("issueSolverId")
    @Expose
    private int issueSolverId;

    @SerializedName("issueSolveDate")
    @Expose
    private Date issueSolveDate;

    @SerializedName("Response")
    private String Response;


    public int getIssueId() {
        return issueId;
    }
    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getIssueName() {
        return issueName;
    }
    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getIssuePhoto() {
        return issuePhoto;
    }
    public void setIssuePhoto(String issuePhoto) {
        this.issuePhoto = issuePhoto;
    }

    public String getIssueDate(){ return issueDate;}
//    public Date getIssueDate() {
//        return issueDate;
//    }
//    public void setIssueDate(Date issueDate) {
//        this.issueDate = issueDate;
//    }

    public int getIssuePriority() {
        return issuePriority;
    }
    public void setIssuePriority(int issuePriority) {
        this.issuePriority = issuePriority;
    }

    public String getIssueOwner() {
        return issueOwner;
    }
    public void setIssueOwner(String issueOwner) {
        this.issueOwner = issueOwner;
    }

    public String getIssueSite() {
        return issueSite;
    }
    public void setIssueSite(String issueSite) {
        this.issueSite = issueSite;
    }

    public String getIssueProject() {
        return issueProject;
    }
    public void setIssueProject(String issueProject) {
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

    public Date getIssueSolveDate() {
        return issueSolveDate;
    }
    public void setIssueSolveDate(Date issueSolveDate) {
        this.issueSolveDate = issueSolveDate;
    }

    public String getResponse() { return Response;  }
    public void setResponse(String response) { Response = response;  }

//    @Override
//    public String toString() {
//        return "IssueModel{" +
//                "ID=" + issueId +
//                ", Status=" + issueStatus +
//                ", Name='" + issueName + '\'' +
//                ", Desc='" + issueDescription + '\'' +
//                ", Photo='" + issuePhoto + '\'' +
//                ", Site= '" + issueSite + '\'' +
//                ", Project'" + issueProject + '\'' +
//                ", Owner'" + issueOwner + '\'' +
//                ",Priority'" + issuePriority + '\'' +
//                '}';
//    }


}
