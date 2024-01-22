package com.generateToken.generateToken.services;
import java.util.List;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.entities.Appointment;

public interface AppointmentService {
    //String bookAppointment(AppointmentDTOs appointmentDto);
    List<Appointment> getByAadhar(String aadharCard);

    List<Appointment>  getByAbhaNumber(String abhaNumber);

    AppointmentDTOs bookAppointment(String email,Long clinicId,AppointmentDTOs appointmentPatient );

 //   List<AppointmentDTOs> getAppointmentBetweenDate(Long clinicId, LocalDate startDate, LocalDate endDate);
}
