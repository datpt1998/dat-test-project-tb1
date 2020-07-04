package com.timebird.scheduleGetData.helper;

public class AuthenObj {
    private boolean isPass;
    private String content;

    public AuthenObj(boolean isPass, String content) {
        this.isPass = isPass;
        this.content = content;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
