package com.hnucm.login.mapper;

import com.hnucm.login.model.Medicine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicineMapper {
    public List<Medicine> getAllMedicine();
    public int addMedicine(Medicine medicine);
    public int deleteMedicine(int id);
    public int updateMedicine(Medicine medicine);
    public List<Medicine> getAllMedicineByName(String title);
    public Medicine getMedicineById(int id);
}