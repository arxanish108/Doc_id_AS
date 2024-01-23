package com.generateToken.generateToken.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private List<String> specialization;
    private List<String> degree;
    private int experience;
    private List<String> research_journal;
    private List<String> citations;
    private List<String> achievements;
    private String licenceNumber;

    @Column(unique = true, length = 10)
    @Size(min = 10, max = 10, message = "Contact length must be exactly 10 characters")
    private String contact;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Clinic> clinics = new ArrayList<>();

    public void addClinic(Clinic clinic) {
        this.clinics.add(clinic);
    }

    public void removeClinic(Clinic clinic) {
        this.clinics.remove(clinic);
        clinic.setDoctor(null);
    }

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointmentPatientList = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Prescription> prescriptionList = new ArrayList<>();

    public void addAppointmentPatient1(Appointment appointment) {
        this.appointmentPatientList.add(appointment);
    }

    @Transient
    public List<DoctorInterface> docIntr;

}
