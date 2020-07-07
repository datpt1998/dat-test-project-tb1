package com.timebird.scheduleGetData.helper;

public class AuthenObj<T> {
    private boolean isPass;
    private T content;

    public AuthenObj(boolean isPass, T content) {
        this.isPass = isPass;
        this.content = content;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
