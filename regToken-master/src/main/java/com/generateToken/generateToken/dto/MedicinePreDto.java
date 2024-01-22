package com.generateToken.generateToken.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicinePreDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long medicineId;
  @Column(name = "medicineName")
  private String medicineName;

  @Column(name = "quantity")
  private Integer quantity;
  @Column(name = "prescriptionId")
  private Long prescriptionId;

//  @Column(name = "pre_id")
//  private Long pre_id;

}
