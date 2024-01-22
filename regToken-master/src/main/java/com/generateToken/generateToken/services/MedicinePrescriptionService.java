package com.generateToken.generateToken.services;

import java.util.List;

import com.generateToken.generateToken.entities.MedicinePrescription;

public interface MedicinePrescriptionService {

    MedicinePrescription createMedicinePrescription(Long prescriptionId, MedicinePrescription medicinePrescription);
    List<MedicinePrescription> getMedicinePrescriptionsByPrescriptionId(Long prescriptionId);
    List<MedicinePrescription> getAllMedicinePrescriptions();
    String deleteMedicinePrescription(Long medicinePrescriptionId);

}
