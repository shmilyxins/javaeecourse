package com.hnucm.springboot.service;

import com.github.pagehelper.PageInfo;
import com.hnucm.springboot.model.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAllPerson();
    public int addPerson(Person person);
    public int deletePerson(int id);
    public int updatePerson(Person person);
    public List<Person> getAllPersonByName(String name);
    public PageInfo<Person> getAllPersonByPage(int pageNum , int pageSize);
}
