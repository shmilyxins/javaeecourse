package com.task2.c202301020241.service;

import com.github.pagehelper.PageInfo;
import com.task2.c202301020241.model.Physician;

import java.util.List;

public interface PhysicianService {
    List<Physician> getAllPhysician();
    PageInfo<Physician> getAllPhysicianByPage(int pageNum, int pageSize);
    List<Physician> getAllPhysicianByName(String name);
    int addPhysician(Physician physician);
    int deletePhysician(int id);
    int updatePhysician(Physician physician);
}
