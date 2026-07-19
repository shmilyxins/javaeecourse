package com.hnucm.springboot.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductDetail {
    private int id;
    private int pid;
    private String name;
    private int price;
    private int full_price;
    private String image_url;
}
