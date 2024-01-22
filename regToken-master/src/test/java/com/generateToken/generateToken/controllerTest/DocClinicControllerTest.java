package com.generateToken.generateToken.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.generateToken.generateToken.controllers.DocClinicController;
import com.generateToken.generateToken.services.DocClinicService;

class DocClinicControllerTest {

    @Mock
    private DocClinicService docClinicService;

    @InjectMocks
    private DocClinicController docClinicController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteRel() {
        // Arrange
        Long id = 1L;
        String expectedResult = "Deletion successful";
        when(docClinicService.deleteRel(anyLong())).thenReturn(expectedResult);

        // Act
        String result = docClinicController.deleteRel(id);

        // Assert
        assertEquals(expectedResult, result);
        verify(docClinicService, times(1)).deleteRel(anyLong());
    }
}
