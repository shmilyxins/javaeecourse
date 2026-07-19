package com.hnucm.task1.service.Impl;

import com.hnucm.task1.mapper.MedicineMapper;
import com.hnucm.task1.model.Medicine;
import com.hnucm.task1.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    MedicineMapper medicineMapper;
    @Override
    public List<Medicine> getAllMedicine() {
        return medicineMapper.getAllMedicine();
    }

    @Override
    public int addMedicine(Medicine medicine) {
        return medicineMapper.addMedicine(medicine);
    }

    @Override
    public int deleteMedicine(int id) {
        return medicineMapper.deleteMedicine(id);
    }

    @Override
    public int updateMedicine(Medicine medicine) {
        return medicineMapper.updateMedicine(medicine);
    }

    @Override
    public List<Medicine> getAllMedicineByName(String title) {
        return medicineMapper.getAllMedicineByName(title);
    }

    @Override
    public Medicine getMedicineById(int id) {
        return medicineMapper.getMedicineById(id);
    }

}