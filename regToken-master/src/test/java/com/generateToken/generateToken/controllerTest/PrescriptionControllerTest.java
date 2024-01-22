package com.generateToken.generateToken.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generateToken.generateToken.controllers.PrescriptionController;
import com.generateToken.generateToken.dto.PrescriptionDto;
import com.generateToken.generateToken.services.PrescriptionService;

class PrescriptionControllerTest {

    @Mock
    private PrescriptionService prescriptionService;

    @InjectMocks
    private PrescriptionController prescriptionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void bookAppointment() {
//        // Arrange
//        Long doctorId = 1L;
//        Long clinicId = 2L;
//        Long appointmentId = 3L;
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        when(prescriptionService.bookPrescription(anyLong(), anyLong(), anyLong(), any(PrescriptionDto.class)))
//                .thenReturn(prescriptionDto);
//
//        // Act
//        PrescriptionDto result = prescriptionController.bookAppointment(doctorId, clinicId, appointmentId, prescriptionDto);
//
//        // Assert
//        assertEquals(prescriptionDto, result);
//        verify(prescriptionService, times(1)).bookPrescription(anyLong(), anyLong(), anyLong(), any(PrescriptionDto.class));
//    }

    @Test
    void getPrescription() {
        // Arrange
        Long prescriptionId = 1L;
        String contactPatient = "1234567890";
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        when(prescriptionService.getPrescriptionById(anyLong(), anyString())).thenReturn(prescriptionDto);

        // Act
        ResponseEntity<PrescriptionDto> responseEntity = prescriptionController.getPrescription(prescriptionId, contactPatient);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(prescriptionDto, responseEntity.getBody());
        verify(prescriptionService, times(1)).getPrescriptionById(anyLong(), anyString());
    }

    @Test
    void deletePrescription() {
        // Arrange
        Long prescriptionId = 1L;
        when(prescriptionService.deletePrescription(anyLong())).thenReturn("Deleted");

        // Act
        ResponseEntity<String> responseEntity = prescriptionController.deletePrescription(prescriptionId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Deleted", responseEntity.getBody());
        verify(prescriptionService, times(1)).deletePrescription(anyLong());
    }
}
