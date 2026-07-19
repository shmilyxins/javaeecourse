package com.task2.c202301020241.service.impl;

import com.task2.c202301020241.mapper.UserMapper;
import com.task2.c202301020241.model.User;
import com.task2.c202301020241.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service注解 Spring容器创建对象的实例
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
        else
            return null;
    }

}
