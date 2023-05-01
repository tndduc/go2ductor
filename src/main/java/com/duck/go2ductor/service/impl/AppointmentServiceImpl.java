package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.AppointmentRequest;
import com.duck.go2ductor.entity.Appointment;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.entity.Room;
import com.duck.go2ductor.repository.AppointmentRepository;
import com.duck.go2ductor.repository.PatientRepository;
import com.duck.go2ductor.repository.PhysicianRepository;
import com.duck.go2ductor.repository.RoomRepository;
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
    @Autowired
    private RoomRepository roomRepository;
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
        Physician physician = physicianRepository.findByUsername(physicianUserName);
        Long id_physician = physician.getId();
        return appointmentRepository.fillAllByPhysicianStartEnd(dateStart,dateEnd,id_physician);
    }

    @Override
    public List<Appointment> getAppointmentPatient(String startDtTimeStr, String endDtTimeStr,String patientUserName) throws ParseException{
        List<Timestamp> timestampList = new ArrayList<>(dateFormat(startDtTimeStr,endDtTimeStr));
        Timestamp dateStart = timestampList.get(0);
        Timestamp dateEnd = timestampList.get(1);
        Patient patient = patientRepository.findByUsername(patientUserName);
        Long id_patient = patient.getId();
        return appointmentRepository.fillAllByPatentStartEnd(dateStart,dateEnd,id_patient);
    }

    @Override
    public ResponseEntity<Appointment> addAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = new Appointment();
        Room room = roomRepository.findById(appointmentRequest.getId_room()).orElseThrow();
        if (appointmentRequest.getId_patient()!=null){
            Patient patient = patientRepository.findById(appointmentRequest.getId_patient()).orElse(null);
            appointment.setPatient(patient);
        }
        Physician physician = physicianRepository.findById(appointmentRequest.getId_physician()).orElse(null);
        appointment.setRoom(room);
        appointment.setPhysician(physician);
        appointment.setStatus(appointmentRequest.getStatus());
        appointment.setStart_dt_time(appointmentRequest.getStart_dt_time());
        appointment.setEnd_dt_time(appointmentRequest.getEnd_dt_time());
        Appointment appointmentNew = appointmentRepository.save(appointment);
        return new ResponseEntity<>(appointmentNew, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Appointment> editAppointment(AppointmentRequest appointmentRequest) {
        try {
            Appointment appointment = new Appointment();
            Room room = roomRepository.findById(appointmentRequest.getId_room()).orElseThrow();
            Patient patient = patientRepository.findById(appointmentRequest.getId_patient()).orElse(null);
            Physician physician = physicianRepository.findById(appointmentRequest.getId_physician()).orElse(null);
            appointment.setId(appointment.getId());
            appointment.setPatient(patient);
            appointment.setRoom(room);
            appointment.setPhysician(physician);
            appointment.setStatus(appointmentRequest.getStatus());
            appointment.setStart_dt_time(appointmentRequest.getStart_dt_time());
            appointment.setEnd_dt_time(appointmentRequest.getEnd_dt_time());
            Appointment appointmentNew = appointmentRepository.save(appointment);
            return new ResponseEntity<>(appointmentNew, HttpStatus.CREATED);
        } catch (DataAccessException ex) {
            // Xử lý ngoại lệ và trả về phản hồi lỗi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ApiResponse cancelAppointmentByPatient(AppointmentRequest appointmentRequest) {
        String status = "PatientCanCal";
        Long id = appointmentRequest.getId();
        int checkCancel= appointmentRepository.cancelAppointment(id,status);
        if (checkCancel==0) {
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Failed to update appointment status with id :"+id);
            return apiResponse;
        }
        return new ApiResponse(Boolean.TRUE, "Successfully updated status for appointment with id :"+id);
    }

    @Override
    public ApiResponse cancelAppointmentByPhysician(AppointmentRequest appointmentRequest) {
        String status = "PhysicianCanCal";
        Long id = appointmentRequest.getId();
       int checkCancel= appointmentRepository.cancelAppointment(id,status);
        if (checkCancel==0) {
            return new ApiResponse(Boolean.FALSE, "Failed to update appointment status with id :"+id);
        }
        return new ApiResponse(Boolean.TRUE, "Successfully updated status for appointment with id :"+id);
    }

    @Override
    public ApiResponse deleteAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = new Appointment();
        Room room = roomRepository.findById(appointmentRequest.getId_room()).orElseThrow();
        Patient patient = patientRepository.findById(appointmentRequest.getId_patient()).orElse(null);
        Physician physician = physicianRepository.findById(appointmentRequest.getId_physician()).orElse(null);
        appointment.setId(appointment.getId());
        appointment.setPatient(patient);
        appointment.setRoom(room);
        appointment.setPhysician(physician);
        appointment.setStatus(appointmentRequest.getStatus());
        appointment.setStart_dt_time(appointmentRequest.getStart_dt_time());
        appointment.setEnd_dt_time(appointmentRequest.getEnd_dt_time());
         appointmentRepository.delete(appointment);
        Long id = appointment.getId();
        boolean isDeleted = !appointmentRepository.existsById(appointment.getId());
        if (isDeleted) {
            return new ApiResponse(Boolean.TRUE, "Successfully delete appointment with id :"+id);

        }
        return new ApiResponse(Boolean.FALSE, "Failed to delete appointment with id :"+id);
    }
}
