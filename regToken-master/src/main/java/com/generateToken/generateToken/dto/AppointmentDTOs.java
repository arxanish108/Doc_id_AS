package com.generateToken.generateToken.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.generateToken.generateToken.Enum.Gender;
import com.generateToken.generateToken.entities.Clinic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentDTOs {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    private String name;
    private String contact;
    private String abhaNumber;
    private String aadharNumber;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private  String clinicLocation;
    private Clinic clinic;

}
