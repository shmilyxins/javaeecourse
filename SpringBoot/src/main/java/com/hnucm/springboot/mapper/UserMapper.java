package com.hnucm.springboot.mapper;

import com.hnucm.springboot.model.User;
import com.hnucm.springboot.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//Mapper 注解将xml文件翻译成Java文件
@Mapper
public interface UserMapper {
    public int addUser(User user);
    public int addUserInfo(UserInfo userInfo);
    public User findUserByName(String name);
    public List<User> findAllUserWithInfo();
    public int deleteUserById(int id);
    public int deleteUserInfoById(int id);
    public List<User> findAllUserWithGrade();
    public List<User> findAllUserWithCourse();
}
