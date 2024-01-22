package com.generateToken.generateToken.services;

import java.time.LocalDate;
import java.util.List;

import com.generateToken.generateToken.dto.DoctorDTO;
import com.generateToken.generateToken.entities.DoctorInterface;

public interface DoctorInterfaceService {
  DoctorInterface addInt(DoctorInterface doctorInterfaceDto,DoctorDTO doctor);
  List<DoctorInterface> getInt(LocalDate currentDate,DoctorDTO doctor);
  DoctorInterface updateInt(DoctorInterface doctorInterface,LocalDate currentDate,DoctorDTO doctor);
  String deleteInt(LocalDate currentDate, String clinicName, DoctorDTO doctor);
}
