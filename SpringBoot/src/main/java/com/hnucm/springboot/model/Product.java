package com.hnucm.springboot.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private int id;
    private int type_id;
    private String desc;
    private String image_url;
    private String inventory;
    private int status;
    private Type type;
    private List<ProductDetail> productDetails;
}
