package com.generateToken.generateToken.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generateToken.generateToken.entities.MedicinePrescription;
import com.generateToken.generateToken.repositories.MedicinePrescriptionRepository;
import com.generateToken.generateToken.services.MedicinePrescriptionService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MedicinePrescriptionServiceImpl implements MedicinePrescriptionService {

    @Autowired
    private MedicinePrescriptionRepository medicinePrescriptionRepository;

    @Override
    public MedicinePrescription createMedicinePrescription(Long prescriptionId,MedicinePrescription medicinePrescription) {
        MedicinePrescription m = new MedicinePrescription();
        m.setPrescriptionId(prescriptionId);
        m.setMedicineName(medicinePrescription.getMedicineName());
        m.setQuantity(medicinePrescription.getQuantity());
          return medicinePrescriptionRepository.save(m);
    }



    @Override
    public List<MedicinePrescription> getAllMedicinePrescriptions() {
        return  medicinePrescriptionRepository.findAll();
    }

    @Override
    public String deleteMedicinePrescription(Long medicinePrescriptionId) {
        MedicinePrescription medicinePrescription = medicinePrescriptionRepository.findById(medicinePrescriptionId)
        .orElseThrow(() -> new EntityNotFoundException("MedicinePrescription not found with id: " + medicinePrescriptionId));
        medicinePrescriptionRepository.delete(medicinePrescription);
        return "MedicinePrescription with id " + medicinePrescriptionId + " deleted successfully";
    }



    @Override
    public List<MedicinePrescription> getMedicinePrescriptionsByPrescriptionId(Long prescriptionId) {
        return medicinePrescriptionRepository.findByPrescriptionId(prescriptionId);
    }

}
