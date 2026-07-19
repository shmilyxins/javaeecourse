package com.hnucm.task1.service.Impl;

import com.hnucm.task1.mapper.UserMapper;
import com.hnucm.task1.model.User;
import com.hnucm.task1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public boolean register(User user) {
        user.setStatus(1);
        if (userMapper.addUser(user) > 0)
            return true;
        return false;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findUserByName(username);
        if (user != null && user.getPassword().equals(password))
            return user;
        return null;
    }
}
