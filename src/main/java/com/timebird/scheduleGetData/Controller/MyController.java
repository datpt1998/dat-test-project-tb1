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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    JWTService jwtService;

    @PostMapping("/login")
    public ResponseEntity lalala(@RequestBody LoginModal modal){
        LDAPAuthenticator authenticator=new LDAPAuthenticator();
        AuthenObj authenObj=authenticator.authenticate(modal.username, modal.password);
        if(authenObj.isPass())
        {
            TokenObject tokenObject=jwtService.signToken(modal.username);
            return new CustomResponseEntity<TokenObject>(tokenObject, HttpStatus.OK);
        }
        else{
            return new CustomResponseEntity<String>(authenObj.getContent(),HttpStatus.CONFLICT);
        }
    }
}
