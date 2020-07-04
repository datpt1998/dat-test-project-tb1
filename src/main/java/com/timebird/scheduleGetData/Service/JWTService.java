package com.timebird.scheduleGetData.Service;

import com.timebird.scheduleGetData.helper.TokenObject;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Service
@PropertySource("classpath:application.properties")
public class JWTService {
    @Autowired
    Environment environment;
    public TokenObject signToken(String username){
        String accessToken=createToken(username,
                Long.parseLong(environment.getProperty("access.expire")),
                environment.getProperty("access.secret"));
        String refreshToken=createToken(username,
                Long.parseLong(environment.getProperty("refresh.expire")),
                environment.getProperty("refresh.secret"));
        return new TokenObject(accessToken,refreshToken,username);
    }

    private String createToken(String username, long expireTime, String secretKey){
        SignatureAlgorithm algorithm=SignatureAlgorithm.HS256;
        Key key=new SecretKeySpec(secretKey.getBytes(), algorithm.getJcaName());
        long now=System.currentTimeMillis();
        Date expiredDate=new Date(now+expireTime);
        JwtBuilder builder= Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(expiredDate)
                .signWith(key);
        return builder.compact();
    }
}
