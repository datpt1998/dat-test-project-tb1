package com.timebird.scheduleGetData.entity;

public class Report {
    private String reportID;
    private String userID;
    private String title;
    private String content;

    public Report() {
    }

    public Report(String reportID, String userID, String title, String content) {
        this.reportID = reportID;
        this.userID = userID;
        this.title = title;
        this.content = content;
    }

    public String getReportID() {
        return reportID;
    }

    public String getUserID() {
        return userID;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
