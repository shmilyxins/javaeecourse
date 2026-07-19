package com.hnucm.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnucm.springboot.mapper.PersonMapper;
import com.hnucm.springboot.model.Person;
import com.hnucm.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Service注解 Spring容器创建对象的实例
@Service
public class PersonServiceImpl implements PersonService {

    //Autowired注解 Spring容器创建对象实例时，将创建好的对象实例注入到当前类中
    @Autowired
    PersonMapper personMapper;
    @Override
    public List<Person> getAllPerson() {
        return personMapper.getAllPerson();
    }
    @Override
    public int addPerson(Person person) {
        return personMapper.addPerson(person);
    }

    @Override
    public int deletePerson(int id) {
        return personMapper.deletePerson(id);
    }

    @Override
    public int updatePerson(Person person) {
        return personMapper.updatePerson(person);
    }

    @Override
    public List<Person> getAllPersonByName(String name) {
        return personMapper.getAllPersonByName(name);
    }

    @Override
    public PageInfo<Person> getAllPersonByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Person> personList = personMapper.getAllPerson();
        return new PageInfo<>(personList);
    }

}
