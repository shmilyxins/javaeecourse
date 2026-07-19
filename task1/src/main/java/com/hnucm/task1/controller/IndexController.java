package com.hnucm.task1.controller;

import com.hnucm.task1.model.Medicine;
import com.hnucm.task1.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    MedicineService medicineService;
    
    @RequestMapping("index")
    public String index(Model model, String title){
        List<Medicine> medicineList;
        if(title != null && !title.isEmpty()){
            medicineList = medicineService.getAllMedicineByName(title);
        }else{
            medicineList = medicineService.getAllMedicine();
        }
        model.addAttribute("medicineList", medicineList);
        return "index.html";
    }
    
    @RequestMapping("addmedicine")
    public String addmedicine(){
        return "addmedicine.html";
    }
    
    @RequestMapping("addmedicinecommit")
    public String addmedicinecommit(Medicine medicine){
        int result = medicineService.addMedicine(medicine);
        return "redirect:/index";
    }
    
    @RequestMapping("deletemedicine")
    public String deletemedicine(int id){
        int result = medicineService.deleteMedicine(id);
        return "redirect:/index";
    }
    
    @RequestMapping("updatemedicine")
    public String updatemedicine(Medicine medicine, Model model){
        model.addAttribute("medicine", medicine);
        return "updatemedicine.html";
    }
    
    @RequestMapping("updatemedicinecommit")
    public String updatemedicinecommit(Medicine medicine){
        int result = medicineService.updateMedicine(medicine);
        return "redirect:/index";
    }
    
    @RequestMapping("medicineDetail")
    @ResponseBody
    public Medicine medicineDetail(int id) {
        return medicineService.getMedicineById(id);
    }
}