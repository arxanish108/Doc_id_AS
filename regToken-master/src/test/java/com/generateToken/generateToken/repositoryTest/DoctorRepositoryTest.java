package com.generateToken.generateToken.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.generateToken.generateToken.repositories.DoctorRepository;

@SpringBootTest
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @MockBean
    private DoctorRepository mockDoctorRepository;

    @Test
    void testFindByTotalAmount() {
        // Arrange
        Long doctorId = 1L;
        Date startDate = new Date(); // Set your start date
        Date endDate = new Date(); // Set your end date

        Double expectedAmount = 100.0; // Set your expected total amount

        DoctorRepositoryTest doctorRepoTest = new DoctorRepositoryTest();

        // Mock the behavior of the repository method
        when(mockDoctorRepository.findByTotalAmount(doctorId, startDate, endDate)).thenReturn(expectedAmount);

        // Act
        Double result = mockDoctorRepository.findByTotalAmount(doctorId, startDate, endDate);

        // Assert
        assertEquals(expectedAmount, result);
    }
}
