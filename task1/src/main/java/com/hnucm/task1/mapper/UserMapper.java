package com.hnucm.task1.mapper;

import com.hnucm.task1.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int addUser(User user);
    public User findUserByName(String  username);
}
