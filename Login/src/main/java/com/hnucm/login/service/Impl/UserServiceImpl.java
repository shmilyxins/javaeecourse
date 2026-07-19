package com.hnucm.login.service.Impl;

import com.hnucm.login.mapper.UserMapper;
import com.hnucm.login.model.User;
import com.hnucm.login.service.UserService;
import com.hnucm.login.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public boolean register(User user) {
        // 生成盐值
        String salt = PasswordUtils.generateSalt();
        
        // 使用盐值对密码进行哈希
        String hashedPassword = PasswordUtils.hashPassword(user.getPassword(), salt);
        
        // 设置用户对象的密码和盐值
        user.setPassword(hashedPassword);
        user.setSalt(salt);
        user.setStatus(1);
        
        if (userMapper.addUser(user) > 0)
            return true;
        return false;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findUserByName(username);
        if (user != null && PasswordUtils.verifyPassword(password, user.getPassword(), user.getSalt()))
            return user;
        return null;
    }
}