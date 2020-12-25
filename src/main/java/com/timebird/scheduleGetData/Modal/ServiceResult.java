package com.timebird.scheduleGetData.Modal;

public class ServiceResult {
    public static final String STATUS_SUCCESS = "SUCCESS";
    public static final String STATUS_FAIL = "FAIL";

    private Object data;
    private String status;
    private String message;

    public ServiceResult(Object data, String status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static String getStatusSuccess() {
        return STATUS_SUCCESS;
    }

    public static String getStatusFail() {
        return STATUS_FAIL;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
