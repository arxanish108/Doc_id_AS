package com.generateToken.generateToken.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.generateToken.generateToken.repositories.DocClinicRepository;
import com.generateToken.generateToken.services.Impl.DocClinicServiceImpl;

@SpringBootTest
class DocClinicServiceImplTest {

    @Autowired
    private DocClinicServiceImpl docClinicService;

    @MockBean
    private DocClinicRepository docClinicRepository;

    @Test
    void testDeleteRel() {
        // Arrange
        Long clinicId = 1L;

        // Mock the void method
        doNothing().when(docClinicRepository).deleteClinicDoc(clinicId);

        // Act
        String result = docClinicService.deleteRel(clinicId);

        // Assert
        assertEquals("deleted", result);

        // Verify interactions with the repository
        verify(docClinicRepository).deleteClinicDoc(clinicId);
    }
}
