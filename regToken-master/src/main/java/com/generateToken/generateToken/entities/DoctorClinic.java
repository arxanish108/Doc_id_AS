package com.generateToken.generateToken.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliDoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorClinic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  //@JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @ManyToOne
  //@JoinColumn(name = "clinic_id")
  private Clinic clinic;

  //private Long clinicId;

}
