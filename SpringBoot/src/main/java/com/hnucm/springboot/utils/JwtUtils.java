package com.hnucm.springboot.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类（适配JJWT 0.11.5+版本）
 */
@Component
public class JwtUtils {

    // 从配置文件注入密钥（新版要求密钥长度至少32位）
    private static String secret ="defaultSecret1234567890abcdef1234567890abcdef";

    // 从配置文件注入过期时间（毫秒），默认2小时
    private static long expiration =7200000;

    // 生成密钥对象（新版要求使用SecretKey而非字符串直接签名）
    private static SecretKey getSecretKey() {
        // 确保secret长度足够（HS256至少需要32位），否则会抛出InvalidKeyException
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    /**
     * 生成token（新版签名方式调整）
     */
    public static  String generateToken(String username) {
        Date issuedAt = new Date();
        Date expirationDate = new Date(issuedAt.getTime() + expiration);

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);

        return Jwts.builder()
        .setClaims(claims)          // 注入自定义数据
        .setSubject(username)       // 设置主题
        .setIssuedAt(issuedAt)      // 签发时间
        .setExpiration(expirationDate) // 过期时间
        .signWith(getSecretKey(), SignatureAlgorithm.HS256) // 新版签名方式：传入SecretKey和算法
        .compact();
    }

    /**
     * 验证token并返回错误信息
     */
    public static String validateToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            return "token不能为空";
        }

        try {
            // 新版解析方式：使用密钥对象验证
            Jwts.parserBuilder()
            .setSigningKey(getSecretKey()) // 设置签名密钥
            .build()
            .parseClaimsJws(token);
            return null; // 验证通过
        } catch (ExpiredJwtException e) {
            return "token已过期，请重新登录";
        } catch (JwtException e) {
            // 包含签名错误、格式错误等所有JWT相关异常
            return "token无效：" + e.getMessage();
        }
    }

    /**
     * 从token提取用户名
     */
    public static String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
            .setSigningKey(getSecretKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
            return claims.get("username", String.class);
        } catch (Exception e) {
            return null; // 提取失败返回null
        }
    }

    /**
     * 获取token剩余过期时间（毫秒）
     */
    public static long getRemainingTime(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
            .setSigningKey(getSecretKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
            return claims.getExpiration().getTime() - System.currentTimeMillis();
        } catch (Exception e) {
            return -1; // 已过期或无效
        }
    }
}
