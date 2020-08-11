package com.timebird.scheduleGetData.Service;

import com.timebird.scheduleGetData.DAO.UserDAO;
import com.timebird.scheduleGetData.Modal.UserDetailDTO;
import com.timebird.scheduleGetData.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserdetailService implements UserDetailsService {
    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userDAO.getUserByMail(s);
        UserDetailDTO userDetailDTO=new UserDetailDTO(user);
        return userDetailDTO;
    }
}
