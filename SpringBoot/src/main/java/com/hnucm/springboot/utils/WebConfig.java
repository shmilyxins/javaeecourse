package com.hnucm.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置类：注册拦截器、配置跨域等
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    /**
     * 注册拦截器并配置拦截规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/productListByPageTypeDesc","/getUserByToken") // 需要拦截的路径
                .addPathPatterns("/admin/**") // 管理员接口
                .excludePathPatterns("/logincommit", "/registercommit") // 排除登录接口
                .excludePathPatterns("/home/**"); // 排除首页等公开接口
    }

    /**
     * 配置跨域（前后端分离项目必备）
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 前端实际域名// 生产环境建议指定具体域名（如 "http://localhost:8081"）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("Authorization", "Content-Type") // 明确允许Authorization和Content-Type头
                .exposedHeaders("Authorization") // 允许前端读取响应头中的Authorization（可选）
                .allowCredentials(true)
                .maxAge(3600);
    }
}
