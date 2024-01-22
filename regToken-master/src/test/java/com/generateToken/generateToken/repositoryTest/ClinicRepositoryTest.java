package com.generateToken.generateToken.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.repositories.ClinicRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ClinicRepositoryTest {

    @Mock
    private ClinicRepository mockClinicRepository;

    @Test
    void testSaveClinic() {
        // Arrange
        Clinic clinic = new Clinic();
        clinic.setLocation("Test Location");

        // Mock the behavior of the repository method
        when(mockClinicRepository.save(clinic)).thenReturn(clinic);

        // Act
        Clinic savedClinic = mockClinicRepository.save(clinic);

        // Assert
        assertEquals("Test Location", savedClinic.getLocation());
    }
}

