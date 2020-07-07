package com.timebird.scheduleGetData.Controller;

import com.timebird.scheduleGetData.DAO.LDAPAuthenticator;
import com.timebird.scheduleGetData.Modal.LoginModal;
import com.timebird.scheduleGetData.Service.JWTService;
import com.timebird.scheduleGetData.helper.AuthenObj;
import com.timebird.scheduleGetData.helper.CustomResponseEntity;
import com.timebird.scheduleGetData.helper.MyResponseObj;
import com.timebird.scheduleGetData.helper.TokenObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    JWTService jwtService;
    @Autowired
    LDAPAuthenticator authenticator;

    @GetMapping("/test")
    public ResponseEntity myTestHeader(@RequestHeader("Subcription-Key") String subcriptionKey){
        return new CustomResponseEntity<String>(subcriptionKey, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginModal modal){
        AuthenObj<String> authenObj=authenticator.authenticate(modal.username, modal.password);
        if(authenObj.isPass())
        {
            TokenObject tokenObject=jwtService.signToken(modal.username);
            return new CustomResponseEntity<TokenObject>(tokenObject, HttpStatus.OK);
        }
        else{
            return new CustomResponseEntity<String>(authenObj.getContent(),HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/verify")
    public ResponseEntity verifyToken(@RequestHeader("Access-Token") String accessToken){
        AuthenObj<String> authenObj=jwtService.decodeAccess(accessToken);
        if(authenObj.isPass()){
            return new CustomResponseEntity<String>(authenObj.getContent(), HttpStatus.OK);
        }
        else{
            return new CustomResponseEntity<String>(authenObj.getContent(), HttpStatus.CONFLICT);
        }
    }
}
