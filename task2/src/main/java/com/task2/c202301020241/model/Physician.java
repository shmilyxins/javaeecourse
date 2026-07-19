package com.task2.c202301020241.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Physician {
    int id;
    String name;
    String courtesy_name;
    String other_name;
    String birth_date;
    String death_date;
    String dynasty;
    String birth_place;
    String achievements;
    String works;
    String speciality;
    String publications;
    String thumbnail;
    Timestamp created_at;
    Timestamp updated_at;
}
