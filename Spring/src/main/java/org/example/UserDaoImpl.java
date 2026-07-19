package org.example;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{
    @Override
    public void findUser() {
        System.out.println("查询用户");
    }
}
