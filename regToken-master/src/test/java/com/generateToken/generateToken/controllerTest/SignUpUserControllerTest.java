package com.generateToken.generateToken.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

import com.generateToken.generateToken.controllers.SignUpUserController;
import com.generateToken.generateToken.dto.DoctorDTO;
import com.generateToken.generateToken.dto.SignupRequest;
import com.generateToken.generateToken.entities.Doctor;
import com.generateToken.generateToken.services.DoctorService;

class SignUpUserControllerTest {

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private SignUpUserController signUpUserController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void signupUser() {
        // Arrange
        SignupRequest signupRequest = new SignupRequest();
        DoctorDTO createdUser = new DoctorDTO();
        when(doctorService.createUser(any(SignupRequest.class))).thenReturn(createdUser);

        // Act
        ResponseEntity<?> responseEntity = signUpUserController.signupUser(signupRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdUser, responseEntity.getBody());
        verify(doctorService, times(1)).createUser(any(SignupRequest.class));
    }

    // Add more test methods for other controller methods

    @Test
    void getAllDoctors() {
        // Arrange
        List<Doctor> doctors = List.of(new Doctor(), new Doctor());
        when(doctorService.getAllDoctors()).thenReturn(doctors);

        // Act
        List<Doctor> result = signUpUserController.getAllDoctors();

        // Assert
        assertEquals(doctors, result);
        verify(doctorService, times(1)).getAllDoctors();
    }

//    @Test
//    void getAmount() {
//        // Arrange
//        Long docId = 1L;
//        Date startDate = new Date();
//        Date endDate = new Date();
//        Double amt = 100.0;
//        when(doctorService.findAmt(anyLong(), any(Date.class), any(Date.class))).thenReturn(amt);
//
//        // Act
//        ResponseEntity<?> responseEntity = signUpUserController.getAmount(docId, startDate, endDate);
//
//        // Assert
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(amt, responseEntity.getBody());
//        verify(doctorService, times(1)).findAmt(anyLong(), any(Date.class), any(Date.class));
//    }

//    @Test
//    void updateDoctor() {
//        // Arrange
//        Long id = 1L;
//        Doctor doctor = new Doctor();
//        when(doctorService.updateDoctor(anyLong(), any(Doctor.class))).thenReturn(doctor);
//
//        // Act
//        Doctor result = signUpUserController.putMethodName(id, doctor);
//
//        // Assert
//        assertEquals(doctor, result);
//        verify(doctorService, times(1)).updateDoctor(anyLong(), any(Doctor.class));
//    }

//    @Test
//    void deleteDoctor() {
//        // Arrange
//        Long id = 1L;
//        String expectedResult = "Deleted successfully";
//        when(doctorService.deleteDoctor(anyLong())).thenReturn(expectedResult);
//
//        // Act
//        String result = signUpUserController.deleteMethodName(id);
//
//        // Assert
//        assertEquals(expectedResult, result);
//        verify(doctorService, times(1)).deleteDoctor(anyLong());
//    }

    @Test
    void redirectToYoutube() {
        // Act
        RedirectView redirectView = signUpUserController.payment();

        // Assert
        assertEquals("http://localhost:9090/", redirectView.getUrl());
    }
}
