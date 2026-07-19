package com.hnucm.springboot.controller;

import com.hnucm.springboot.model.Person;
import com.hnucm.springboot.model.User;
import com.hnucm.springboot.service.PersonService;
import com.hnucm.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    PersonService personService;
    @RequestMapping("index")
    public String index(Model model,String name){
        List<Person> personList;
//        for (int i = 0; i < 10; i++){
//            Person person = new Person();
//            person.setId(i);
//            person.setName("张三" + i);
//            person.setAge(20+i);
//            personList.add(person);
//        }
//        String name = "张三";
//        //把后端的数据传递给前端页面
//        model.addAttribute("name",name);
        if (name != null){
            personList = personService.getAllPersonByName(name);
        } else {
            personList = personService.getAllPerson();
        }
        model.addAttribute("personList",personList);
        return "index.html";
    }
    @RequestMapping("addperson")
    public String addPerson(){
        return "addperson.html";
    }
    @RequestMapping("addpersoncommit")
    public String addPersonCommit(Person person){
        int result = personService.addPerson(person);
        if (result > 0){
            return "redirect:/index";
        } else {
            return "redirect:/addperson";
        }
    }

    @RequestMapping("deleteperson")
    public String deletePerson(int id){
        int result = personService.deletePerson(id);
        return "redirect:/index";
    }


    @RequestMapping("updateperson")
    public String updatePerson(Person person,Model model){
        model.addAttribute("person",person);
        return "updateperson.html";
    }

    @RequestMapping("updatepersoncommit")
    public String updatePersonCommit(Person person){
        int result = personService.updatePerson(person);
        if (result > 0){
            return "redirect:/index";
        }
        return "redirect:/updateperson";
    }
}
