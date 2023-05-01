package com.duck.go2ductor.dao;

import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.entity.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/23/2023
 */
@Data
public class AppointmentRequest {
    private Long id;
    @NotNull(message = "id_physician must not be null")
    private Long id_physician;
    private Long id_patient;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Timestamp start_dt_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Timestamp end_dt_time;
    @NotNull(message = "id_physician must not be null")
    private Long id_room;
    private String status;
}
