package com.generateToken.generateToken.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.generateToken.generateToken.dto.DoctorDTO;
import com.generateToken.generateToken.dto.SignupRequest;
import com.generateToken.generateToken.entities.ApiResponse;
import com.generateToken.generateToken.entities.Doctor;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface DoctorService {
    DoctorDTO createUser(SignupRequest signupRequest);
    List<Doctor> getAllDoctors();
    DoctorDTO getDoctor(String email);
    Double findAmt(String email,Date startDate, Date endDate);
    Doctor updateDoctor(String email,Doctor doctor);
    String deleteDoctor(String email);
    ApiResponse forgotPassword(String email,String newPassword,String confirmPassword);

    Doctor updateByFields(String email, Map<String, Object> fields);
    //

}
