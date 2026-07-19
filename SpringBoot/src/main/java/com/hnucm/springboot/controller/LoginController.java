package com.hnucm.springboot.controller;

import com.hnucm.springboot.model.User;
import com.hnucm.springboot.model.UserInfo;
import com.hnucm.springboot.service.UserService;
import com.hnucm.springboot.utils.JwtUtils;
import com.hnucm.springboot.utils.Result;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("userInfoList")
    public Result userInfoList(){
        List<User> userList = userService.findAllUserWithInfo();
        return Result.ok().put("data", userList);
    }

    @RequestMapping("userGradeList")
    public Result userGradeList(){
        List<User> userList = userService.findAllUserWithGrade();
        return Result.ok().put("data", userList);
    }
    @RequestMapping("userCourseList")
    public Result userCourseList(){
        List<User> userList = userService.findAllUserWithCourse();
        return Result.ok().put("data", userList);
    }

    @RequestMapping("deleteUserById")
    public Result deleteUserById(int id){
        int result = userService.deleteUserAndUserInfo(id);
        if (result > 0) {
            return Result.ok("删除成功");
        }
        return Result.error("删除失败");
    }

    @RequestMapping("uploadCommit")
    public Result uploadCommit(MultipartFile  file){
        File file1 = new File("d:/upload/");
        if (!file1.exists()) {
            file1.mkdirs();
        }
        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
        try {
            file.transferTo(new File(file1, fileName));
            return Result.ok("上传成功").put("data", fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("上传失败");
        }
    }


    @RequestMapping("logincommit")
    public Result logincommit(String username, String password){
        User user = userService.login(username, password);
        if (user != null) {
            String token = JwtUtils.generateToken(username);
            return Result.ok(token).put("data", user);
        }
        return Result.error("登录失败");
    }

    @RequestMapping("registercommit")
    public Result registercommit(String username, String password, String email, String phone, String realname,String avatar){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        UserInfo userInfo = new UserInfo();
        userInfo.setRealname(realname);
        userInfo.setAvatar(avatar);
        user.setUserInfo(userInfo);
        boolean result = userService.register(user);
        if (result) {
            return Result.ok("注册成功");
        }
        return Result.error("注册失败");
    }

    @RequestMapping("getUserByToken")
    public Result getUserByToken(@RequestAttribute("username") String username){
        User user = userService.findUserByName(username);
        return Result.ok().put("data", user);
    }
}
