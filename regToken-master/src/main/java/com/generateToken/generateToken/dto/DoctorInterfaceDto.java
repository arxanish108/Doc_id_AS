package com.generateToken.generateToken.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.generateToken.generateToken.entities.Clinic;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorInterfaceDto {

  private LocalTime startTime;
  private LocalTime endTime;
  private String clinicName;
  private LocalDate stDate;

  private LocalDate endDate;
  //@Enumerated(EnumType.STRING)
  private Long doctorId;

  @Transient
  private List<Clinic> clinicList;
}
