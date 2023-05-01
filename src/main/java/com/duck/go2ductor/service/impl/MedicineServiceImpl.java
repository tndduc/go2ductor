package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Medicine;
import com.duck.go2ductor.repository.MedicineRepository;
import com.duck.go2ductor.service.MedicineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/28/2023
 */
@Service
@Slf4j
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    public ApiResponse addMedicine(Medicine medicine) {
        Medicine newMedicine = new Medicine();
        newMedicine.setName(medicine.getName());
        newMedicine.setManufacturer(medicine.getManufacturer());
        newMedicine.setDosage_form(medicine.getDosage_form());
        newMedicine.setStrength(medicine.getStrength());
        newMedicine.setComposition(medicine.getComposition());
        newMedicine.setIndications(medicine.getIndications());
        newMedicine.setContraindications(medicine.getContraindications());
        newMedicine.setSide_effects(medicine.getSide_effects());
        newMedicine.setStorage_instructions(medicine.getStorage_instructions());
        newMedicine.setPrice(medicine.getPrice());
        newMedicine.setImage(medicine.getImage());
        Medicine savedMedicine = medicineRepository.save(newMedicine);
        if (savedMedicine != null) {
            return new ApiResponse(true, "Medicine added successfully.", HttpStatus.CREATED);
        } else {
            return new ApiResponse(false, "Failed to add medicine.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ApiResponse editMedicine(Medicine medicine) {
        Optional<Medicine> existingMedicine = medicineRepository.findById(medicine.getId());
        if (existingMedicine.isPresent()) {
            Medicine updatedMedicine = existingMedicine.get();
            updatedMedicine.setName(medicine.getName());
            updatedMedicine.setManufacturer(medicine.getManufacturer());
            updatedMedicine.setDosage_form(medicine.getDosage_form());
            updatedMedicine.setStrength(medicine.getStrength());
            updatedMedicine.setComposition(medicine.getComposition());
            updatedMedicine.setIndications(medicine.getIndications());
            updatedMedicine.setContraindications(medicine.getContraindications());
            updatedMedicine.setSide_effects(medicine.getSide_effects());
            updatedMedicine.setStorage_instructions(medicine.getStorage_instructions());
            updatedMedicine.setPrice(medicine.getPrice());
            updatedMedicine.setImage(medicine.getImage());

            Medicine savedMedicine = medicineRepository.save(updatedMedicine);

            if (savedMedicine != null) {
                return new ApiResponse(true, "Medicine updated successfully.", HttpStatus.OK);
            } else {
                return new ApiResponse(false, "Failed to update medicine.", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ApiResponse(false, "Medicine not found.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    @Override
    public List<Medicine> getByName(String nameMedicine) {
        return medicineRepository.findByNameContaining(nameMedicine);
    }
}
