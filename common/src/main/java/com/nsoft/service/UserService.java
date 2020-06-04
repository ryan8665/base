package com.nsoft.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails retrieveUserDetails();
}
