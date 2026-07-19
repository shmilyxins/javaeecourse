package com.hnucm.springboot.service.impl;

import com.hnucm.springboot.mapper.UserMapper;
import com.hnucm.springboot.model.User;
import com.hnucm.springboot.model.UserInfo;
import com.hnucm.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Service注解 Spring容器创建对象的实例
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Transactional
    @Override
    public boolean register(User user) {
        user.setStatus(1);
        int result = userMapper.addUser(user);
        UserInfo userInfo = user.getUserInfo();
        userInfo.setUserid(user.getId());
        if (result > 0)
            return userMapper.addUserInfo(userInfo) > 0;
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

    @Transactional//事务管理，保证方法中的数据源操作全部成功或者失败
    @Override
    public List<User> findAllUserWithInfo() {
        return userMapper.findAllUserWithInfo();
    }

    @Override
    public int deleteUserAndUserInfo(int id) {
        int result = userMapper.deleteUserById(id);
        if (result > 0 && userMapper.deleteUserInfoById(id) > 0)
            return result;
        return 0;
    }

    @Override
    public int addUser(User user) {
        int result = userMapper.addUser(user);
        if (result > 0 && userMapper.addUserInfo(user.getUserInfo()) > 0)
            return result;
        return 0;
    }

    @Override
    public List<User> findAllUserWithGrade() {
        return userMapper.findAllUserWithGrade();
    }

    @Override
    public List<User> findAllUserWithCourse() {
        return userMapper.findAllUserWithCourse();
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

}
