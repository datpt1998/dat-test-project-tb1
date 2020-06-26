package com.timebird.scheduleGetData.entity;

import java.util.Date;

public class Log {

    private String logID;
    private Date checkIn;
    private Date checkOut;
    private double workHours;
    private boolean isAttend;
    private double penalty;
    private Date logDate;
    private String userID;

    public Log() {
    }

    public Log(String logID, Date checkIn, Date checkOut, double workHours,
               boolean isAttend, double penalty, Date logDate, String userID) {
        this.logID = logID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.workHours = workHours;
        this.isAttend = isAttend;
        this.penalty = penalty;
        this.logDate = logDate;
        this.userID = userID;
    }

    public String getLogID() {
        return logID;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public double getWorkHours() {
        return workHours;
    }

    public boolean isAttend() {
        return isAttend;
    }

    public double getPenalty() {
        return penalty;
    }

    public Date getLogDate() {
        return logDate;
    }

    public String getUserID() {
        return userID;
    }
}
