package com.generateToken.generateToken.services;
import java.util.List;

import com.generateToken.generateToken.dto.PrescriptionDto;

public interface PrescriptionService {

    // Create
//    PrescriptionDto createPrescription(Prescription prescription);
//
//    // Read
   PrescriptionDto getPrescriptionById(Long prescriptionId,String patientContact);

   List<PrescriptionDto> listPrescriptionByAbhaNumber(String abhaNumber);
//    List<PrescriptionDto> getAllPrescriptions();
//
//    // Update
//    PrescriptionDto updatePrescription(Long prescriptionId, PrescriptionDto prescriptionDto);
//
//    // Delete
   String deletePrescription(Long prescriptionId);

    PrescriptionDto bookPrescription(Long doctorId, Long clinicId,Long appointId, PrescriptionDto prescriptionDto);
}

