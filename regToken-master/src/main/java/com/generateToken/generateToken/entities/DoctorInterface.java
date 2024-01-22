package com.generateToken.generateToken.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctorInter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorInterface {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalTime startTime;
  private LocalTime endTime;
  private String clinicName;
  private LocalDate stDate;
  private LocalDate endDate;
  private Long doctorId;
  @Transient
  private List<Clinic> clinicList;

}
