package com.nsoft.service.impl;

import com.nsoft.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService {
    final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    public UserDetails retrieveUserDetails() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object myUser = (auth != null) ? auth.getPrincipal() : null;

            if (myUser instanceof UserDetails) {
                UserDetails user = (UserDetails) myUser;
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }

    }
}
