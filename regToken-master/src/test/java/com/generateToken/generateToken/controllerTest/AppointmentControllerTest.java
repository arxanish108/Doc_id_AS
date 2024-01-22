package com.generateToken.generateToken.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.generateToken.generateToken.controllers.AppointmentController;
import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.entities.Appointment;
import com.generateToken.generateToken.services.AppointmentService;

class AppointmentControllerTest {

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void bookAppointment() {
//        // Arrange
//        Long doctorId = 1L;
//        Long clinicId = 2L;
//        AppointmentDTOs appointmentDTOs = new AppointmentDTOs();
//        when(appointmentService.bookAppointment(anyLong(), anyLong(), any(AppointmentDTOs.class))).thenReturn(appointmentDTOs);
//
//        // Act
//        AppointmentDTOs result = appointmentController.bookAppointment(doctorId, clinicId, appointmentDTOs);
//
//        // Assert
//        assertEquals(appointmentDTOs, result);
//        verify(appointmentService, times(1)).bookAppointment(anyLong(), anyLong(), any(AppointmentDTOs.class));
//    }

    @Test
    public void testGetPatientByAadhar() {
        // Mock data
        String aadharCardNumber = "1234567890";
        List<Appointment> appointments = Collections.singletonList(new Appointment());
        when(appointmentService.getByAadhar(aadharCardNumber)).thenReturn(appointments);

        // Perform the test
        ResponseEntity<List<Appointment>> result = appointmentController.getPatientByAadhar(aadharCardNumber);

        // Verify the interactions
        verify(appointmentService, times(1)).getByAadhar(aadharCardNumber);
        // Add more assertions based on the expected behavior of your controller method and the mocked data
    }
}
