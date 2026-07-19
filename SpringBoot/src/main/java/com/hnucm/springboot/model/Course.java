package com.hnucm.springboot.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Course {
    private int id;
    private String course_name;
    private BigDecimal credits;
    private int credit_hours;
    private String teacher;
    private String semester;
}
