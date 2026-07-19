package com.task2.c202301020241.mapper;

import com.task2.c202301020241.model.Physician;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhysicianMapper {
    public int addPhysician(Physician physician);
    public List<Physician> getAllPhysician();
    public List<Physician> getAllPhysicianByName(String name);
    public int deletePhysician(int id);
    public int updatePhysician(Physician physician);
}
