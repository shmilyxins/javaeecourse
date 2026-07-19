package com.hnucm.login.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String phone;
    private int status;
    private Date create_time;
    private Date update_time;
}