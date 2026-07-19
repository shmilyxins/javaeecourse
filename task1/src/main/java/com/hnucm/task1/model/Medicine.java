package com.hnucm.task1.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Medicine {
    private int id;
    private String title;
    private String imgurl;
    private String introduction;
    private Timestamp created_at;
    private Timestamp updated_at;
}
