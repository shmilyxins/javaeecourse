package com.hnucm.springboot.mapper;

import com.hnucm.springboot.model.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//Mapper 注解将xml文件翻译成Java文件
@Mapper
public interface PersonMapper {
    public List<Person> getAllPerson();
    public int addPerson(Person person);
    public int deletePerson(int id);
    public int updatePerson(Person person);
    public List<Person> getAllPersonByName(String name);
}
