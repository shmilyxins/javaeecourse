package com.hnucm.login.service;

import com.hnucm.login.model.User;

public interface UserService {
    public boolean register(User user);
    public User login(String username, String password);
}
