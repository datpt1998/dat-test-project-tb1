package com.timebird.scheduleGetData.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Base64;

@RestController
public class NewController {
    String trueUsername="user";
    String truePassword="pass";
//    Quăng sang service
    private boolean basicProcess(String basicAuth) {
        if(!basicAuth.startsWith("Basic ")) {
            return false; //not basic
        }
        String encodedUserPass = basicAuth.replace("Basic ", "");
        byte[] byteDecodedUserPass = Base64.getDecoder().decode(encodedUserPass);
        String decodedUserPass = new String(byteDecodedUserPass);
        String[] arrayUserPass = decodedUserPass.split(":");
        String username = arrayUserPass[0];
        String password = arrayUserPass[1];
        if(username.trim().equalsIgnoreCase(trueUsername)&&password.trim().equalsIgnoreCase(truePassword)){
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/test-basic")
    public ResponseEntity testBasic(@RequestHeader("Authorization") String basicAuth) {
        if(basicProcess(basicAuth)) {
            return new ResponseEntity("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity("Forbid", HttpStatus.FORBIDDEN);
        }
    }
}
