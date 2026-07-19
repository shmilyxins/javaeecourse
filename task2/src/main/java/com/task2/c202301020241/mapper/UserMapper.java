package com.task2.c202301020241.mapper;

import com.task2.c202301020241.model.User;
import org.apache.ibatis.annotations.Mapper;

//Mapper 注解将xml文件翻译成Java文件
@Mapper
public interface UserMapper {
    public int addUser(User user);
    public User findUserByName(String  name);
}
