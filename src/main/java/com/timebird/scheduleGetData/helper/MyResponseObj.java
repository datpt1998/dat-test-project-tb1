package com.timebird.scheduleGetData.helper;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class MyResponseObj<T> {
    private T content;
    private String statusCode;

    public MyResponseObj(T content, String statusCode) {
        this.content = content;
        this.statusCode = statusCode;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
