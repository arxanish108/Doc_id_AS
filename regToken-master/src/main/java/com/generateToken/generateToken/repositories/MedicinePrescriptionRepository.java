package com.generateToken.generateToken.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generateToken.generateToken.entities.MedicinePrescription;


public interface MedicinePrescriptionRepository extends JpaRepository<MedicinePrescription, Long> {
  //List<MedicinePrescription> findBypre_id(Long preId);
  List<MedicinePrescription> findByPrescriptionId(Long prescriptionId);
}
