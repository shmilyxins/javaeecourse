package com.hnucm.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.hnucm.springboot.model.Person;
import com.hnucm.springboot.service.PersonService;
import com.hnucm.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@Controller返回的是html页面 @RestController返回的是json数据
@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @RequestMapping("personList")
    public Result index(){
        List<Person> personList = personService.getAllPerson();

        return Result.ok().put("data", personList);
    }

    @RequestMapping("personListByPage")
    public Result personListByPage(int pageNum, int pageSize){
        PageInfo<Person> personList = personService.getAllPersonByPage(pageNum, pageSize);

        return Result.ok().put("data", personList);
    }

    @RequestMapping("personListByName")
    public Result personListByName(String name){
        List<Person> personList = personService.getAllPersonByName(name);

        return Result.ok().put("data", personList);
    }

    @RequestMapping("addpersoncommit1")
    public Result addPersonCommit(Person person){
        int result = personService.addPerson(person);
        if (result > 0){
            return Result.ok("添加成功");
        }
        return Result.error(100,"添加失败");
    }

    @RequestMapping("deleteperson1")
    public Result deletePerson(int id){
        int result = personService.deletePerson(id);
        if (result > 0){
            return Result.ok("删除成功");
        }
        return Result.error(100,"删除失败");
    }
    @RequestMapping("updatepersoncommit1")
    public Result updatePersonCommit(Person person){
        int result = personService.updatePerson(person);
        if (result > 0){
            return Result.ok("修改成功");
        }
        return Result.error(100,"修改失败");
    }
}
