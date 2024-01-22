package com.generateToken.generateToken.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.generateToken.generateToken.entities.MedicinePrescription;
import com.generateToken.generateToken.repositories.MedicinePrescriptionRepository;
import com.generateToken.generateToken.services.Impl.MedicinePrescriptionServiceImpl;

@SpringBootTest
class MedicinePrescriptionServiceImplTest {

    @Autowired
    private MedicinePrescriptionServiceImpl medicinePrescriptionService;

    @MockBean
    private MedicinePrescriptionRepository medicinePrescriptionRepository;

    @Test
    void testCreateMedicinePrescription() {
        // Arrange
        Long prescriptionId = 1L;

        MedicinePrescription medicinePrescription = new MedicinePrescription();
        medicinePrescription.setMedicineName("Paracetamol");
        medicinePrescription.setQuantity(2);

        when(medicinePrescriptionRepository.save(any(MedicinePrescription.class))).thenReturn(medicinePrescription);

        // Act
        MedicinePrescription createdPrescription = medicinePrescriptionService.createMedicinePrescription(prescriptionId, medicinePrescription);

        // Assert
        assertEquals(prescriptionId, createdPrescription.getPrescriptionId());
        assertEquals(medicinePrescription.getMedicineName(), createdPrescription.getMedicineName());
        assertEquals(medicinePrescription.getQuantity(), createdPrescription.getQuantity());

        // Verify interactions with the repository
        verify(medicinePrescriptionRepository).save(any(MedicinePrescription.class));
    }

    @Test
    void testGetAllMedicinePrescriptions() {
        // Arrange
        MedicinePrescription prescription1 = new MedicinePrescription();
        MedicinePrescription prescription2 = new MedicinePrescription();

        when(medicinePrescriptionRepository.findAll()).thenReturn(Arrays.asList(prescription1, prescription2));

        // Act
        List<MedicinePrescription> allPrescriptions = medicinePrescriptionService.getAllMedicinePrescriptions();

        // Assert
        assertEquals(2, allPrescriptions.size());

        // Verify interactions with the repository
        verify(medicinePrescriptionRepository).findAll();
    }
}

