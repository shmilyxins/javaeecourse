package com.task2.c202301020241.controller;

import com.github.pagehelper.PageInfo;
import com.task2.c202301020241.model.Physician;
import com.task2.c202301020241.service.PhysicianService;
import com.task2.c202301020241.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class PhysicianController {
    @Autowired
    PhysicianService physicianService;
    @RequestMapping("physicianList")
    public Result index(){
        List<Physician> physicianList = physicianService.getAllPhysician();
        return Result.ok().put("data", physicianList);
    }

    @RequestMapping("physicianListByPage")
    public Result physicianListByPage(int pageNum, int pageSize){
        PageInfo<Physician> physicianList = physicianService.getAllPhysicianByPage(pageNum, pageSize);
        return Result.ok().put("data", physicianList);
    }
    @RequestMapping("physicianListByName")
    public Result physicianListByName(String name){
        List<Physician> physicianList = physicianService.getAllPhysicianByName(name);
        return Result.ok().put("data", physicianList);
    }
    @RequestMapping("addPhysicianCommit")
    public Result addPhysicianCommit(Physician physician){
        int result = physicianService.addPhysician(physician);
        if (result > 0){
            return Result.ok("添加成功");
        }
        return Result.error(100,"添加失败");
    }
    @RequestMapping("deletePhysician")
    public Result deletePhysician(int id){
        int result = physicianService.deletePhysician(id);
        if (result > 0){
            return Result.ok("删除成功");
        }
        return Result.error(100,"删除失败");
    }
    @RequestMapping("updatePhysician")
    public Result updatePhysician(Physician physician){
        int result = physicianService.updatePhysician(physician);
        if (result > 0){
            return Result.ok("修改成功");
        }
        return Result.error(100,"修改失败");
    }
}
