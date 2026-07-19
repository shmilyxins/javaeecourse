package com.hnucm.springboot.service;

import com.hnucm.springboot.model.User;

import java.util.List;

public interface UserService {
    public boolean register(User user);
    public User login(String username,String password);
    public List<User> findAllUserWithInfo();
    public int deleteUserAndUserInfo(int id);
    public int addUser(User user);
    public List<User> findAllUserWithGrade();
    public List<User> findAllUserWithCourse();
    public User findUserByName(String  name);
}
