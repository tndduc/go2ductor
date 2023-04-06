package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Appointment;
import com.duck.go2ductor.repository.AppointmentRepository;
import com.duck.go2ductor.repository.PatientRepository;
import com.duck.go2ductor.repository.PhysicianRepository;
import com.duck.go2ductor.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PhysicianRepository physicianRepository;
    @Autowired
    private PatientRepository patientRepository;
    public List<Timestamp> dateFormat(String startDtTimeStr, String endDtTimeStr)throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDtTime = dateFormat.parse(startDtTimeStr);
            Date endDtTime = dateFormat.parse(endDtTimeStr);
            Timestamp startTimestamp = new Timestamp(startDtTime.getTime());
            Timestamp endTimestamp = new Timestamp(endDtTime.getTime());
            List<Timestamp> statEnd = new ArrayList<>();
            statEnd.add(startTimestamp);
            statEnd.add(endTimestamp);
            return statEnd;
    }

    @Override
    public List<Appointment> getAllAppointment(String startDtTimeStr, String endDtTimeStr) throws ParseException {
        List<Timestamp> timestampList = new ArrayList<>(dateFormat(startDtTimeStr,endDtTimeStr));
        Timestamp startTimestamp = timestampList.get(0);
        Timestamp endTimestamp = timestampList.get(1);
        return appointmentRepository.fillAllByStartEnd(startTimestamp,endTimestamp);
    }

    @Override
    public List<Appointment> getAppointmentPhysician(String startDtTimeStr, String endDtTimeStr,String physicianUserName) throws ParseException {
        List<Timestamp> timestampList = new ArrayList<>(dateFormat(startDtTimeStr,endDtTimeStr));
        Timestamp dateStart = timestampList.get(0);
        Timestamp dateEnd = timestampList.get(1);
        return appointmentRepository.fillAllByPhysicianStartEnd(dateStart,dateEnd,physicianUserName);
    }

    @Override
    public List<Appointment> getAppointmentPatient(String startDtTimeStr, String endDtTimeStr,String patientUserName) throws ParseException{
        List<Timestamp> timestampList = new ArrayList<>(dateFormat(startDtTimeStr,endDtTimeStr));
        Timestamp dateStart = timestampList.get(0);
        Timestamp dateEnd = timestampList.get(1);
        return appointmentRepository.fillAllByPatentStartEnd(dateStart,dateEnd,patientUserName);
    }

    @Override
    public ResponseEntity<Appointment> addAppointment(Appointment appointment) {
        Appointment appointmentNew = appointmentRepository.save(appointment);
        return new ResponseEntity<>(appointmentNew, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Appointment> editAppointment(Appointment appointment) {
        try {
            // Cập nhật bản ghi Appointment trong cơ sở dữ liệu
            Appointment updatedAppointment = appointmentRepository.save(appointment);
            // Tạo đối tượng ResponseEntity chứa bản ghi đã cập nhật và mã trạng thái HTTP 200 OK
            return ResponseEntity.ok(updatedAppointment);
        } catch (DataAccessException ex) {
            // Xử lý ngoại lệ và trả về phản hồi lỗi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ApiResponse cancelAppointmentByPatient(Appointment appointment) {
        String status = "PatientCanCal";
        Long id = appointment.getId();
        int checkCancel= appointmentRepository.cancelAppointment(id,status);
        if (checkCancel==0) {
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Failed to update appointment status with id :"+id);
            return apiResponse;
        }
        return new ApiResponse(Boolean.TRUE, "Successfully updated status for appointment with id :"+id);
    }

    @Override
    public ApiResponse cancelAppointmentByPhysician(Appointment appointment) {
        String status = "PhysicianCanCal";
        Long id = appointment.getId();
       int checkCancel= appointmentRepository.cancelAppointment(id,status);
        if (checkCancel==0) {
            return new ApiResponse(Boolean.FALSE, "Failed to update appointment status with id :"+id);
        }
        return new ApiResponse(Boolean.TRUE, "Successfully updated status for appointment with id :"+id);
    }

    @Override
    public ApiResponse deleteAppointment(Appointment appointment) {
         appointmentRepository.delete(appointment);
        Long id = appointment.getId();
        boolean isDeleted = !appointmentRepository.existsById(appointment.getId());
        if (isDeleted) {
            return new ApiResponse(Boolean.TRUE, "Successfully delete appointment with id :"+id);

        }
        return new ApiResponse(Boolean.FALSE, "Failed to delete appointment with id :"+id);
    }
}
