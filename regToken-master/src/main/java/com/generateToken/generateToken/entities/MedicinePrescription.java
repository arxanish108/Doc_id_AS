package com.generateToken.generateToken.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "medicinePrescriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicinePrescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;

    @Column(name = "medicineName")
    private String medicineName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "prescriptionId")
    private Long prescriptionId;


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonIgnore
//    @JoinColumn(name = "prescription_id")
//    private Prescription prescription;
;



    // Constructors, getters, setters, etc.
}
