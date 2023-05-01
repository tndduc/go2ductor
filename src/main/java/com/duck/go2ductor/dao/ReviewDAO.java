package com.duck.go2ductor.dao;

import com.duck.go2ductor.entity.MedicalHistory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/29/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDAO {

    private Long id;
    private Long id_medicalHistory;
    private String review;
    private Integer star;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Timestamp date;

}
