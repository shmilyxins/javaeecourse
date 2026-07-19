package com.hnucm.login.service;

import com.hnucm.login.model.Medicine;

import java.util.List;

public interface MedicineService {
    public List<Medicine> getAllMedicine();
    public int addMedicine(Medicine medicine);
    public int deleteMedicine(int id);
    public int updateMedicine(Medicine medicine);
    public List<Medicine> getAllMedicineByName(String title);
    public Medicine getMedicineById(int id);
}