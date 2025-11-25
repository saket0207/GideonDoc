package com.document.gideon.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService{

    void register(String username, String rawPassword);

    boolean userExists(String username);
}
