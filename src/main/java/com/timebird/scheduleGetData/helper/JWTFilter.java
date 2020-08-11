package com.timebird.scheduleGetData.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timebird.scheduleGetData.Service.JWTService;
import com.timebird.scheduleGetData.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter extends HttpFilter {
    private JWTService service;
    private UserDetailsService UserDetailsService;

    public JWTFilter(JWTService service, UserDetailsService userDetailsService) {
        this.service = service;
        this.UserDetailsService=userDetailsService;
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request.getHeader("access-token")==null){
            SecurityContextHolder.getContext().setAuthentication(null);
            chain.doFilter(request,response);
            return;
        }
        AuthenObj authenObj=service.decodeAccess(request.getHeader("access-token"));
        if(authenObj.isPass()){
            UserDetails userDetails=UserDetailsService.loadUserByUsername(authenObj.getContent().toString());
            System.out.println(userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities()));
            chain.doFilter(request,response);
        }
        else {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(new ObjectMapper().writeValueAsString(authenObj));
            response.getWriter().flush();
        }
    }
}
