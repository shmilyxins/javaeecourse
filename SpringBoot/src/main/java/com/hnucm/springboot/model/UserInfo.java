package com.hnucm.springboot.model;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private int userid;
    private String realname;
    private int gender;
    private String avatar;
}
