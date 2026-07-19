package com.hnucm.task1.service;

import com.hnucm.task1.model.User;

public interface UserService {
    public boolean register(User user);
    public User login(String username, String password);
}
