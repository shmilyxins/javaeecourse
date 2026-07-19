package com.hnucm.springboot.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
    private int status;
    private Date create_time;
    private Date update_time;
    private UserInfo userInfo;
    private List<Grade> gradeList;
    private List<Course> courseList;
}
