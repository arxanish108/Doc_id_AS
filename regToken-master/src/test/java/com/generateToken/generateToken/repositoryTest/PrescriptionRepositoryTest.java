package com.generateToken.generateToken.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.generateToken.generateToken.entities.Prescription;
import com.generateToken.generateToken.repositories.PrescriptionRepository;

@SpringBootTest
class PrescriptionRepositoryTest {

    @MockBean
    private PrescriptionRepository prescriptionRepository;

    @Test
    void testFindByPrescriptionId() {
        // Arrange
        PrescriptionRepositoryTest prescriptionRepoTest = new PrescriptionRepositoryTest();

        Long prescriptionId = 1L;
        Prescription prescription = mock(Prescription.class);

        when(prescriptionRepository.findByPrescriptionId(prescriptionId)).thenReturn(prescription);

        // Act
        Prescription result = prescriptionRepository.findByPrescriptionId(prescriptionId);

        // Assert
        // Add assertions based on your expectations
        assertEquals(prescription, result);
        verify(prescriptionRepository).findByPrescriptionId(prescriptionId);
    }
}
