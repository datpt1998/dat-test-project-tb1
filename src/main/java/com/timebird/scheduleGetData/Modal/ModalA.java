package com.timebird.scheduleGetData.Modal;

public class ModalA {
    String name;
    String age;
    String address;

    public ModalA(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public ModalA() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
