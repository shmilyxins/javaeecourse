package com.hnucm.springboot.model;

import lombok.Data;

import java.util.Date;

@Data
public class Type {
    private int id;
    private String name;
    private Date create_time;
    private Date update_time;
}
