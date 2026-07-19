package com.hnucm.springboot.mapper;

import com.hnucm.springboot.model.Person;
import com.hnucm.springboot.model.Product;
import com.hnucm.springboot.model.ProductDetail;
import com.hnucm.springboot.model.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<Product> getAllProducts();
    public List<Product> getAllProductsByTypeOrDesc(@Param("type") String type,
                                                   @Param("desc") String desc);
    public List<Type> getAllTypes();
    public Product getProductById(int id);
    public int addProduct(Product product);
    public int addProductDetail(ProductDetail productDetail);
    public int deleteProduct(int id);
    public int deleteProductAndDetails(int id);
    public int updateProduct(Product product);
    public List<Type> getAllTypesByName(@Param("name") String name);
    public int addType(Type type);
    public int deleteType(int id);
    public int updateType(Type type);
}
