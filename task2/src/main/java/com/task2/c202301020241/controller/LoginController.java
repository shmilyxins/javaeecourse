package com.task2.c202301020241.controller;

import com.task2.c202301020241.model.User;
import com.task2.c202301020241.service.UserService;
import com.task2.c202301020241.utils.Result;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("loginCommit")
    public Result loginCommit(HttpSession session, String username, String password){
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return Result.ok("登录成功");
        }
        return Result.error("登录失败");
    }

    @RequestMapping("registerCommit")
    public Result registerCommit(User user){
        boolean result = userService.register(user);
        if (result) {
            return Result.ok("注册成功");
        }
        return Result.error("注册失败");
    }
}
