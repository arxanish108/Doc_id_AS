package com.generateToken.generateToken.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generateToken.generateToken.Enum.Gender;
import com.generateToken.generateToken.dto.AppointmentDTOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Appointment")
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;
    private String aadharNumber;
    private String abhaNumber;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private  String clinicLocation;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "clinicId")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    public Appointment() {
    }

    @OneToMany(mappedBy = "appointment",cascade = CascadeType.ALL)
    private List<Prescription> prescriptionList = new ArrayList<>();

  public AppointmentDTOs getAppointmentDto(){
    AppointmentDTOs appointmentDTOs = new AppointmentDTOs();
    appointmentDTOs.setName(this.getName());
    //appointmentDTOs.setContact_number(this.contact_number);
    appointmentDTOs.setAadharNumber(this.aadharNumber);
    appointmentDTOs.setAge(this.age);
    appointmentDTOs.setGender(this.gender);
    appointmentDTOs.setAppointmentDate(this.appointmentDate);
    appointmentDTOs.setAppointmentTime(this.appointmentTime);
    appointmentDTOs.setClinicLocation(this.clinicLocation);
    return appointmentDTOs;
  }

}
