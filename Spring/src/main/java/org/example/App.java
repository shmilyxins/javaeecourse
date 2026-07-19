package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDaoImpl userDao = new UserDaoImpl();
        //userDao.findUser();

        //创建Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserDao userDao1 = (UserDao) ac.getBean("userDaoImpl");
        userDao1.findUser();

        //UserService userService = (UserService) ac.getBean("userService");
        //userService.setUserDao(userDao1);
        //userService.getUserDao().findUser();
    }
}
