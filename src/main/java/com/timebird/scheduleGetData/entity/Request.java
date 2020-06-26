package com.timebird.scheduleGetData.entity;

public class Request {
    private String requestID;
    private String userID;
    private String title;
    private String content;
    private String status;

    public Request() {
    }

    public Request(String requestID, String userID, String title, String content, String status) {
        this.requestID = requestID;
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public String getRequestID() {
        return requestID;
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

    public String getStatus() {
        return status;
    }
}
