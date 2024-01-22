package com.generateToken.generateToken.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generateToken.generateToken.Enum.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prescription")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    @Column(name = "currDate")
    private LocalDate currDate ;

    @Enumerated(EnumType.STRING)
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

  @ManyToOne()
  @JoinColumn(name = "patient_contact_number")
  private Appointment appointment;
  //cascade = CascadeType.ALL

  @JsonIgnore
  @ManyToOne()
  @JoinColumn(name = "clinicId")
  private Clinic clinic;

  @ManyToOne
  @JoinColumn(name = "doctorId")
  private Doctor doctor;

  @Transient
  List<MedicinePrescription> medicines =  new ArrayList<>();

  @Transient
  private LocalTime currentTime;


}
