package com.generateToken.generateToken.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.generateToken.generateToken.Enum.Gender;
import com.generateToken.generateToken.entities.MedicinePrescription;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    private LocalDate currDate ;

    private Gender gender;


    @Transient
    private String docName;

    @Transient
    private List<String> degree;
    @Transient
    private List<String> speciality;

  @Transient
  private LocalTime startTime;

  private String abhaNumber;

  @Transient
  private LocalTime endTime;

  @Transient
  private String contact;

  @Transient
  private String patient_Name;

  @Transient
  private int age;

  @Transient
  private String location;

  @Transient
  List<MedicinePrescription> medicines =  new ArrayList<>();

  @Transient
  private LocalTime currentTime;



}
