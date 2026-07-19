package com.hnucm.login.service.Impl;

import com.hnucm.login.mapper.MedicineMapper;
import com.hnucm.login.model.Medicine;
import com.hnucm.login.service.MedicineService;
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