package com.generateToken.generateToken.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.generateToken.generateToken.entities.MedicinePrescription;
import com.generateToken.generateToken.repositories.MedicinePrescriptionRepository;

@SpringBootTest
class MedicinePrescriptionRepositoryTest {

    @MockBean
    private MedicinePrescriptionRepository medicinePrescriptionRepository;

    @Test
    void testFindByPrescriptionId() {
        // Arrange
        MedicinePrescriptionRepositoryTest medicinePrescriptionRepoTest = new MedicinePrescriptionRepositoryTest();

        Long prescriptionId = 1L;
        MedicinePrescription medicinePrescription = mock(MedicinePrescription.class);

        when(medicinePrescriptionRepository.findByPrescriptionId(prescriptionId)).thenReturn(List.of(medicinePrescription));

        // Act
        List<MedicinePrescription> result = medicinePrescriptionRepository.findByPrescriptionId(prescriptionId);

        // Assert
        // Add assertions based on your expectations
        assertEquals(1, result.size());
        verify(medicinePrescriptionRepository).findByPrescriptionId(prescriptionId);
    }
}
