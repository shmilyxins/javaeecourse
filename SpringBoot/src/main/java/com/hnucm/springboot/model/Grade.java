package com.hnucm.springboot.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Grade {
    private int id;
    private int student_id;
    private String course_name;
    private BigDecimal score;
    private int credit_hours;
    private BigDecimal credits;
}
