package com.generateToken.generateToken.repositoryTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.generateToken.generateToken.repositories.DocClinicRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DocClinicRepositoryTest {

    @Mock
    private DocClinicRepository mockDocClinicRepository;

    @Test
    void testDeleteClinicDoc() {
        // Arrange
        Long clinicId = 1L;

        // Act
        mockDocClinicRepository.deleteClinicDoc(clinicId);

        // Assert
        verify(mockDocClinicRepository, times(1)).deleteClinicDoc(clinicId);
    }

    // Add more test methods if needed
}
