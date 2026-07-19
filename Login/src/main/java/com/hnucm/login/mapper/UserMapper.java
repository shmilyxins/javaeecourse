package com.hnucm.login.mapper;

import com.hnucm.login.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int addUser(User user);
    public User findUserByName(String  username);
}