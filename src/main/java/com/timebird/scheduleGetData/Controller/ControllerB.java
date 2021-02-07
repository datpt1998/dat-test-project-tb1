package com.timebird.scheduleGetData.Controller;

import com.timebird.scheduleGetData.Modal.ModalB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerB {
    @PostMapping("/btest")
    public ResponseEntity test(@RequestBody ModalB body) {
        return new ResponseEntity(body.getName(), HttpStatus.OK);
    }
}
