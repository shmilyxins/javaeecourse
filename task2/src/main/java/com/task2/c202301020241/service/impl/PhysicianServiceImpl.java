package com.task2.c202301020241.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.task2.c202301020241.mapper.PhysicianMapper;
import com.task2.c202301020241.model.Physician;
import com.task2.c202301020241.service.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicianServiceImpl implements PhysicianService {
    @Autowired
    PhysicianMapper physicianMapper;

    @Override
    public List<Physician> getAllPhysician() {
        return physicianMapper.getAllPhysician();
    }

    @Override
    public PageInfo<Physician> getAllPhysicianByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Physician> physicianList = physicianMapper.getAllPhysician();
        return new PageInfo<>(physicianList);
    }

    @Override
    public List<Physician> getAllPhysicianByName(String name) {
        return physicianMapper.getAllPhysicianByName(name);
    }

    @Override
    public int addPhysician(Physician physician) {
        return physicianMapper.addPhysician(physician);
    }

    @Override
    public int deletePhysician(int id) {
        return physicianMapper.deletePhysician(id);
    }

    @Override
    public int updatePhysician(Physician physician) {
        return physicianMapper.updatePhysician(physician);
    }
}
