package com.hnucm.login.controller;

import com.hnucm.login.model.User;
import com.hnucm.login.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("login")
    public String login(){
        return "login.html";
    }
    @RequestMapping("logincommit")
    public String logincommit(HttpSession session, String username, String password){
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/index";
        }
        return "fail.html";
    }

    @RequestMapping("register")
    public String register(){
        return "register.html";
    }
    @RequestMapping("registercommit")
    public String registercommit(User user, RedirectAttributes redirectAttributes){
        boolean result = userService.register(user);
        if (result) {
            redirectAttributes.addFlashAttribute("message", "注册成功，请登录！");
            return "redirect:/login";
        }
        return "register.html";
    }
}