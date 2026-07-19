package com.hnucm.springboot.service;

import com.github.pagehelper.PageInfo;
import com.hnucm.springboot.model.Product;
import com.hnucm.springboot.model.Type;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public PageInfo<Product> getAllProductsByPage(int pageNum, int pageSize);
    public PageInfo<Product> getAllProductsByPageTypeDesc(int pageNum, int pageSize,
                                                           String type, String desc);
    public List<Type> getAllTypes();
    public Product getProductById(int id);
    public int addProduct(Product product);
    public int deleteProduct(int id);
    public int updateProduct(Product product);
    public PageInfo<Type> getAllTypesByPageName(int pageNum, int pageSize, String type);
    public int addType(Type type);
    public int deleteType(int id);
    public int updateType(Type type);
}
