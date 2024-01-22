package com.generateToken.generateToken.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.generateToken.generateToken.entities.Appointment;
import com.generateToken.generateToken.repositories.AppointmentRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AppointmentRepositoryTest {

    @Mock
    private AppointmentRepository mockAppointmentRepository;
        
     @Test
    void testFindByContact() {
        // Arrange
        String contact = "123456789";
        List<Appointment> expectedAppointments = new ArrayList<>();  // Add your expected appointments to this list

        // Mock the behavior of the repository method
        when(mockAppointmentRepository.findByContact(contact)).thenReturn(expectedAppointments);

        // Act
        List<Appointment> actualAppointments = mockAppointmentRepository.findByContact(contact);

        // Assert
        assertEquals(expectedAppointments, actualAppointments);
    }

}