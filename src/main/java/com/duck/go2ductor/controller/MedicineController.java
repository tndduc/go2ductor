package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Medicine;
import com.duck.go2ductor.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/28/2023
 */
@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @GetMapping("/get-all")
    public List<Medicine> getAll(){
        return medicineService.getAll();
    }
    @GetMapping("/get-by-name")
    public List<Medicine> getByName(@RequestParam String medicineName){
        return medicineService.getByName(medicineName);
    }
    @PostMapping("/update")
    public ApiResponse update(@RequestBody Medicine medicine){
        return medicineService.editMedicine(medicine);
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody Medicine medicine){
        return medicineService.addMedicine(medicine);
    }
}
