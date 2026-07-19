package com.task2.c202301020241.service;


import com.task2.c202301020241.model.User;

public interface UserService {
    public boolean register(User user);
    public User login(String username,String password);
}
