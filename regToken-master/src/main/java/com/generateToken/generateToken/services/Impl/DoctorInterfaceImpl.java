package com.generateToken.generateToken.services.Impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generateToken.generateToken.dto.DoctorDTO;
import com.generateToken.generateToken.entities.Doctor;
import com.generateToken.generateToken.entities.DoctorInterface;
import com.generateToken.generateToken.repositories.DoctorInterfaceRepository;
import com.generateToken.generateToken.repositories.DoctorRepository;
import com.generateToken.generateToken.services.DoctorInterfaceService;


@Service
public class DoctorInterfaceImpl implements DoctorInterfaceService {


  @Autowired
  private DoctorInterfaceRepository doctorInterfaceRepository;

  @Autowired
  private DoctorRepository doctorRepository;

  @Override
  public DoctorInterface addInt(DoctorInterface doctorInterfaceDto,DoctorDTO doctor) {
    DoctorInterface newDoctorInterface = new DoctorInterface();
    Doctor d = doctorRepository.findFirstByEmail(doctor.getEmail());
    newDoctorInterface.setDoctorId(d.getId());
    newDoctorInterface.setClinicList(doctor.getClinics());
    newDoctorInterface.setClinicName(doctorInterfaceDto.getClinicName());
    newDoctorInterface.setEndDate(doctorInterfaceDto.getEndDate());
    newDoctorInterface.setStDate(doctorInterfaceDto.getStDate());
    newDoctorInterface.setStartTime(doctorInterfaceDto.getStartTime());
    newDoctorInterface.setEndTime(doctorInterfaceDto.getEndTime());
    DoctorInterface newDoc = doctorInterfaceRepository.save(newDoctorInterface);
    return newDoc;
  }

  @Override
  public List<DoctorInterface> getInt(LocalDate currentDate, DoctorDTO doctor) {
      Doctor d = doctorRepository.findFirstByEmail(doctor.getEmail());
      List<DoctorInterface> getAllApp = new ArrayList<>();
      if (d != null) {
          List<DoctorInterface> getApp = doctorInterfaceRepository.findByDoctorId(d.getId());
          for (DoctorInterface di : getApp) {
              LocalDate stDate = di.getStDate();
              LocalDate endDate = di.getEndDate();
              if ((stDate.isEqual(currentDate) || stDate.isBefore(currentDate))
                  && (endDate.isEqual(currentDate) || endDate.isAfter(currentDate))) {
                  getAllApp.add(di);
              }
          }
      }
      return getAllApp;
    }

    @Override
    public DoctorInterface updateInt(DoctorInterface doctorInterface, LocalDate currentDate, DoctorDTO doctor) {
        Doctor d = doctorRepository.findFirstByEmail(doctor.getEmail());

        if (d != null) {
            List<DoctorInterface> getApp = doctorInterfaceRepository.findByDoctorId(d.getId());

            for (DoctorInterface di : getApp) {
                if (di.getClinicName().equals(doctorInterface.getClinicName())) {
                    LocalDate stDate = di.getStDate();
                    LocalDate endDate = di.getEndDate();

                    // Check if currentDate is within the range [stDate, endDate]
                    if ((stDate.isEqual(currentDate) || stDate.isBefore(currentDate))
                        && (endDate.isEqual(currentDate) || endDate.isAfter(currentDate))) {
                        di.setEndDate(doctorInterface.getEndDate());
                        di.setStDate(doctorInterface.getStDate());
                        di.setEndTime(doctorInterface.getEndTime());
                        di.setStartTime(doctorInterface.getStartTime());
                        // Assuming you may want to update other fields as well

                        // Save the updated DoctorInterface to the repository
                        return doctorInterfaceRepository.save(di);
                    }
                }
            }
        }

        return null; // Return null if no matching DoctorInterface is found
    }

    @Override
  public String deleteInt(LocalDate currentDate, String clinicName, DoctorDTO doctor) {
      Doctor d = doctorRepository.findFirstByEmail(doctor.getEmail());

      if (d != null) {
          List<DoctorInterface> getApp = doctorInterfaceRepository.findByDoctorId(d.getId());

          for (DoctorInterface di : getApp) {
              if (di.getClinicName().equals(clinicName)) {
                  LocalDate stDate = di.getStDate();
                  LocalDate endDate = di.getEndDate();

                  // Check if currentDate is within the range [stDate, endDate]
                  if ((stDate.isEqual(currentDate) || stDate.isBefore(currentDate))
                      && (endDate.isEqual(currentDate) || endDate.isAfter(currentDate))) {
                      String s = "Delete Appointment for Doctor id "+ doctor.getId() + " and clinic "+ di.getClinicName();
                      // Delete the DoctorInterface from the repository
                      doctorInterfaceRepository.delete(di);
                      return s; // Indicate successful deletion
                  }
              }
          }
      }
      String s = "No appointment deleted for Doctor id "+ doctor.getId() + " and clinic "+ clinicName;

      return s; // Indicate that no matching DoctorInterface was found or deletion failed
  }


}
