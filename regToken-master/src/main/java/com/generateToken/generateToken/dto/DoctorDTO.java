package com.generateToken.generateToken.dto;

import java.util.ArrayList;
import java.util.List;

import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.entities.DoctorInterface;

import jakarta.persistence.Column;
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
public class DoctorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    private List<String> degree;

    private List<String> specialization;
    // private String degree;
    private int experience;
    private List<String> research_journal;
    private List<String> citations;

    private List<String> achievements;
    private String licenceNumber;
    @Column(unique = true, length = 10)
    private String contact;
    @Column(unique = true)
    private String email;
    private String password;

    @Transient
    private List<DoctorInterface> docIntr;

    private List<Clinic> clinics = new ArrayList<>();

    public void addClinic(Clinic clinic) {
        this.clinics.add(clinic);
    }
}
