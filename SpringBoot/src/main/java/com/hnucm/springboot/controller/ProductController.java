package com.hnucm.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.hnucm.springboot.model.Product;
import com.hnucm.springboot.model.Type;
import com.hnucm.springboot.service.ProductService;
import com.hnucm.springboot.utils.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/productList")
    public Result productList(){
        List<Product> productList = productService.getAllProducts();
        return Result.ok().put("data", productList);
    }

    @RequestMapping("/productListByPage")
    public Result productListByPage(int pageNum, int pageSize){
        PageInfo<Product> productList = productService.getAllProductsByPage(pageNum, pageSize);
        return Result.ok().put("data", productList);
    }

    @RequestMapping("/productListByPageTypeDesc")
    public Result productListByPageTypeDesc(int pageNum, int pageSize,
                                            @RequestParam(required = false) String type,
                                            @RequestParam(required = false) String desc){
        PageInfo<Product> productList = productService.getAllProductsByPageTypeDesc(pageNum, pageSize, type, desc);
        return Result.ok().put("data", productList);
    }

    @RequestMapping("/allTypeList")
    public Result allTypeList(){
        List<Type> typeList = productService.getAllTypes();
        return Result.ok().put("data", typeList);
    }

    @RequestMapping("/productById")
    public Result productById(int id){
        Product product = productService.getProductById(id);
        return Result.ok().put("data", product);
    }

    @RequestMapping("/addProduct")
    public Result addProduct(Product product){
        int result = productService.addProduct(product);
        if (result > 0){
            return Result.ok("添加成功");
        }
        return Result.error(100,"添加失败");
    }
    @RequestMapping("/deleteProduct")
    public Result deleteProduct(int id){
        int result = productService.deleteProduct(id);
        if (result > 0){
            return Result.ok("删除成功");
        }
        return Result.error(100,"删除失败");
    }

    @RequestMapping("/updateProduct")
    public Result updateProduct(Product product){
        int result = productService.updateProduct(product);
        if (result > 0){
            return Result.ok("修改成功");
        }
        return Result.error(100,"修改失败");
    }

    @RequestMapping("/typeListByPage")
    public Result typeListByPage(int pageNum, int pageSize, @RequestParam(required = false) String name){
        PageInfo<Type> typeList = productService.getAllTypesByPageName(pageNum, pageSize, name);
        return Result.ok().put("data", typeList);
    }
    @RequestMapping("/addType")
    public Result addType(Type type){
        int result = productService.addType(type);
        if (result > 0){
            return Result.ok("添加成功");
        }
        return Result.error(100,"添加失败");
    }
    @RequestMapping("/deleteType")
    public Result deleteType(int id){
        int result = productService.deleteType(id);
        if (result > 0){
            return Result.ok("删除成功");
        }
        return Result.error(100,"删除失败");
    }
    @RequestMapping("/updateType")
    public Result updateType(Type type){
        int result = productService.updateType(type);
        if (result > 0){
            return Result.ok("修改成功");
        }
        return Result.error(100,"修改失败");
    }
}
