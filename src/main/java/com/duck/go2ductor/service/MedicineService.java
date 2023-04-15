package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Medicine;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/14/2023
 */
public interface MedicineService {
    ApiResponse  addMedicine(Medicine medicine);
    ApiResponse  editMedicine(Medicine medicine);
}
