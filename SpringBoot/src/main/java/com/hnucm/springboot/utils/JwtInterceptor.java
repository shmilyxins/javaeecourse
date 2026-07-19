package com.hnucm.springboot.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

/**
 * JWT拦截器：自动验证请求中的token
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行 OPTIONS 预检请求
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 更健壮的 token 获取方式
        String token = getTokenFromRequest(request);

        if (token == null || token.trim().isEmpty()) {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter out = response.getWriter();
            out.write("{\"code\":401,\"message\":\"缺少token\"}");
            out.flush();
            out.close();
            return false;
        }

        // 验证token
        String username = jwtUtils.getUsernameFromToken(token);
        request.setAttribute("username", username);

        return true; // 允许请求继续处理
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        // 尝试多种可能的 header 名称
        String token = request.getHeader("Authorization");
        if (token == null) token = request.getHeader("authorization");
        if (token == null) token = request.getHeader("Authorizaion"); // 容错拼写错误
        if (token == null) token = request.getHeader("token");

        // 如果包含 Bearer 前缀，去除它
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        return token;
    }
}
