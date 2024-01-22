package com.generateToken.generateToken.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generateToken.generateToken.controllers.MedicinePrescriptionController;
import com.generateToken.generateToken.entities.MedicinePrescription;
import com.generateToken.generateToken.services.MedicinePrescriptionService;

class MedicinePrescriptionControllerTest {
    @Mock
    private MedicinePrescriptionService medicinePrescriptionService;

    @InjectMocks
    private MedicinePrescriptionController medicinePrescriptionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createMedicinePrescription() {
        // Arrange
        MedicinePrescription medicinePrescription = new MedicinePrescription();
        when(medicinePrescriptionService.createMedicinePrescription(anyLong(), any(MedicinePrescription.class)))
                .thenReturn(medicinePrescription);

        // Act
        ResponseEntity<MedicinePrescription> responseEntity = medicinePrescriptionController
                .createMedicinePrescription(1L, medicinePrescription);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(medicinePrescription, responseEntity.getBody());
        verify(medicinePrescriptionService, times(1)).createMedicinePrescription(anyLong(), any(MedicinePrescription.class));
    }

    // Add more test methods for other controller methods

    @Test
    void getAllMedicinePrescriptions() {
        // Arrange
        List<MedicinePrescription> medicinePrescriptions = new ArrayList<>();
        when(medicinePrescriptionService.getAllMedicinePrescriptions()).thenReturn(medicinePrescriptions);

        // Act
        ResponseEntity<List<MedicinePrescription>> responseEntity = medicinePrescriptionController.getAllMedicinePrescriptions();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(medicinePrescriptions, responseEntity.getBody());
        verify(medicinePrescriptionService, times(1)).getAllMedicinePrescriptions();
    }

    @Test
    void deleteMedicinePrescription() {
        // Arrange
        Long medicinePrescriptionId = 1L;
        String resultMessage = "Deleted successfully";
        when(medicinePrescriptionService.deleteMedicinePrescription(anyLong())).thenReturn(resultMessage);

        // Act
        ResponseEntity<String> responseEntity = medicinePrescriptionController.deleteMedicinePrescription(medicinePrescriptionId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(resultMessage, responseEntity.getBody());
        verify(medicinePrescriptionService, times(1)).deleteMedicinePrescription(anyLong());
    }
}
