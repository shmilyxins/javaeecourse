package com.hnucm.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnucm.springboot.mapper.ProductMapper;
import com.hnucm.springboot.model.Product;
import com.hnucm.springboot.model.ProductDetail;
import com.hnucm.springboot.model.Type;
import com.hnucm.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public PageInfo<Product> getAllProductsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.getAllProducts();
        return new PageInfo<>(productList);
    }

    @Override
    public PageInfo<Product> getAllProductsByPageTypeDesc(int pageNum, int pageSize, String type, String desc) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.getAllProductsByTypeOrDesc(type, desc);
        return new PageInfo<>(productList);
    }

    @Override
    public List<Type> getAllTypes() {
        return productMapper.getAllTypes();
    }

    @Override
    public Product getProductById(int id) {
        return productMapper.getProductById(id);
    }

    @Override
    public int addProduct(Product product) {
        int result = productMapper.addProduct(product);
//        List<ProductDetail> productDetails = product.getProductDetails();
        boolean flag = true;
//        for (ProductDetail productDetail : productDetails) {
//            productDetail.setPid(product.getId());
//            if (productMapper.addProductDetail(productDetail)!= 1)
//                flag = false;
//        }
        if (result > 0 && flag)
            return 1;
        return 0;
    }

    @Override
    public int deleteProduct(int id) {
//        int result = productMapper.deleteProduct(id);
//        if (result > 0)
//            return productMapper.deleteProductAndDetails(id);
//        return 0;
        return productMapper.deleteProduct(id);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public PageInfo<Type> getAllTypesByPageName(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Type> typeList = productMapper.getAllTypesByName(name);
        return new PageInfo<>(typeList);
    }

    @Override
    public int addType(Type type) {
        return productMapper.addType(type);
    }

    @Override
    public int deleteType(int id) {
        return productMapper.deleteType(id);
    }

    @Override
    public int updateType(Type type) {
        return productMapper.updateType(type);
    }


}
