package com.generateToken.generateToken.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.entities.Clinic;

public interface ClinicService {

    ClinicDto addClinic(String email, ClinicDto clinicDto);

    Optional<Clinic> getClinicByClinicName(String email);

    List<AppointmentDTOs> getAppointments(Long clinicId);

    List<AppointmentDTOs> getAppointmentBetweenDate(Long clinicId, LocalDate startDate, LocalDate endDate);

    Double findAmountForClinicInDateRange(Long clinicId, Date startDate, Date endDate);

    List<Clinic> getAllClinics();

    String deleteClinic(Long doctor_id,Long id);

    ClinicDto updateClinic(Long id, ClinicDto updatedClinicDto);

    String deleteAppointment(Long appointmentId);
}
