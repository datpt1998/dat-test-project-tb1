package com.timebird.scheduleGetData.Modal;

public class TheChild extends TheParent{
    String phone;
    String cmt;

    public TheChild(String name, String address, String phone, String cmt) {
        super(name, address);
        this.phone = phone;
        this.cmt = cmt;
    }

    public TheChild() {
        super();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }
}
