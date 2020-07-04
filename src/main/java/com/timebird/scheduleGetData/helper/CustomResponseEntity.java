package com.timebird.scheduleGetData.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponseEntity<T> extends ResponseEntity<MyResponseObj<T>> {

    public CustomResponseEntity(T content, HttpStatus status) {
        super(new MyResponseObj<T>(content, status.value()+""), status);
    }
}
