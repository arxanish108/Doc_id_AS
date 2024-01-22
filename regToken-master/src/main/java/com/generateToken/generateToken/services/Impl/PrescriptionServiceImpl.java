package com.generateToken.generateToken.services.Impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generateToken.generateToken.dto.PrescriptionDto;
import com.generateToken.generateToken.entities.Appointment;
import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.entities.Doctor;
import com.generateToken.generateToken.entities.MedicinePrescription;
import com.generateToken.generateToken.entities.Prescription;
import com.generateToken.generateToken.repositories.AppointmentRepository;
import com.generateToken.generateToken.repositories.ClinicRepository;
import com.generateToken.generateToken.repositories.DoctorRepository;
import com.generateToken.generateToken.repositories.MedicinePrescriptionRepository;
import com.generateToken.generateToken.repositories.PrescriptionRepository;
import com.generateToken.generateToken.services.PrescriptionService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private MedicinePrescriptionRepository medicinePrescriptionRepository;

  @Override
  public PrescriptionDto bookPrescription(Long doctorId, Long clinicId,Long appointId, PrescriptionDto prescriptionDto) {
    Clinic clinic = clinicRepository.findById(clinicId)
      .orElseThrow(() -> new EntityNotFoundException("Clinic not found"));

    Doctor doctor = doctorRepository.findById(doctorId)
      .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));

    Appointment appointment = appointmentRepository.findById(appointId)
      .orElseThrow(() -> new EntityNotFoundException("Appointment not found"));

    Prescription prescription = new Prescription();
    prescription.setGender(prescriptionDto.getGender());
    prescription.setCurrDate(prescriptionDto.getCurrDate());
    prescription.setClinic(clinic);
    prescription.setDoctor(doctor);
    prescription.setSpeciality(doctor.getSpecialization());
    LocalTime currentTime = LocalTime.now();
    prescription.setCurrentTime(currentTime);
    //prescription.setDegree(doctor.getDegree());
    ;
    prescription.setSpeciality(doctor.getSpecialization());
//    prescription.setStartTime(clinic.getStartTime());
//    prescription.setEndTime(clinic.getEndTime());
    prescription.setAge(appointment.getAge());


    prescription = prescriptionRepository.save(prescription);

    PrescriptionDto prescriptionDto1 = new PrescriptionDto();
    prescriptionDto1.setGender(prescription.getGender());
    prescriptionDto1.setCurrDate(prescription.getCurrDate());
    prescriptionDto1.setCurrentTime(prescription.getCurrentTime());
    //prescriptionDto1.setSpeciality(prescription.getSpeciality());

    prescription = prescriptionRepository.save(prescription);
    clinic = clinicRepository.save(clinic);
    doctor = doctorRepository.save(doctor);

    return prescriptionDto1;
  }

  @Override
  public PrescriptionDto getPrescriptionById(Long prescriptionId,String patientContact) {
    Prescription prescription= prescriptionRepository.findById(prescriptionId).orElseThrow(() -> new EntityNotFoundException("Prescription not found"));
    PrescriptionDto prescriptionDto = new PrescriptionDto();
        BeanUtils.copyProperties(prescription, prescriptionDto);
         List<MedicinePrescription> medicines = medicinePrescriptionRepository.findByPrescriptionId(prescriptionId);
        prescriptionDto.setMedicines(medicines);
        Long did = prescription.getDoctor().getId();
        Doctor d = doctorRepository.findById(did).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        prescriptionDto.setSpeciality(d.getSpecialization());
        prescriptionDto.setDocName(d.getFirstName());
        prescriptionDto.setDegree(d.getDegree());
        Long cid = prescription.getClinic().getId();
        Clinic c = clinicRepository.findById(cid).orElseThrow(()-> new EntityNotFoundException("Clinic not found"));
        prescriptionDto.setLocation(c.getLocation());
       // prescriptionDto.setStartTime(c.getStartTime());
        prescriptionDto.setContact(c.getDoctor().getContact());
        LocalTime currentTime = LocalTime.now();
        prescriptionDto.setCurrentTime(currentTime);
       // prescriptionDto.setEndTime(c.getEndTime());
        List<Appointment> appointments = appointmentRepository.findByContact(patientContact);
        if (!appointments.isEmpty()) {
          Appointment firstAppointment = appointments.get(0);
          prescriptionDto.setAge(firstAppointment.getAge());
          prescriptionDto.setPatient_Name(firstAppointment.getName());
          prescriptionDto.setAbhaNumber(firstAppointment.getAbhaNumber());
        }else{
          throw new EntityNotFoundException("Not Proper mapping of phone number or wrong phone number according to appointment");
        }
        return prescriptionDto;

  }

  @Override
  public String deletePrescription(Long prescriptionId) {
    Prescription prescription = prescriptionRepository.findByPrescriptionId(prescriptionId);
    prescriptionRepository.delete(prescription);
        return "Prescription with id " + prescriptionId + " deleted successfully";
  }

  @Override
  public List<PrescriptionDto> listPrescriptionByAbhaNumber(String abhaNumber) {
    List<Prescription> prescriptions =  prescriptionRepository.findByAbhaNumber(abhaNumber);
    List<PrescriptionDto> newpre = new ArrayList<>();
    
    for(Prescription prescription: prescriptions){
      PrescriptionDto prescriptionDto = new PrescriptionDto();
        BeanUtils.copyProperties(prescription, prescriptionDto);
         List<MedicinePrescription> medicines = medicinePrescriptionRepository.findByPrescriptionId(prescription.getPrescriptionId());
        prescriptionDto.setMedicines(medicines);
        Long did = prescription.getDoctor().getId();
        Doctor d = doctorRepository.findById(did).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        prescriptionDto.setSpeciality(d.getSpecialization());
        prescriptionDto.setDocName(d.getFirstName());
        prescriptionDto.setDegree(d.getDegree());
        Long cid = prescription.getClinic().getId();
        Clinic c = clinicRepository.findById(cid).orElseThrow(()-> new EntityNotFoundException("Clinic not found"));
        prescriptionDto.setLocation(c.getLocation());
       // prescriptionDto.setStartTime(c.getStartTime());
        prescriptionDto.setContact(c.getDoctor().getContact());
        LocalTime currentTime = LocalTime.now();
        prescription.setCurrentTime(currentTime);
       // prescriptionDto.setEndTime(c.getEndTime());
        List<Appointment> appointments = appointmentRepository.findByAbhaNumber(abhaNumber);
        if (!appointments.isEmpty()) {
          Appointment firstAppointment = appointments.get(0);
          prescriptionDto.setAge(firstAppointment.getAge());
          prescriptionDto.setPatient_Name(firstAppointment.getName());
          prescriptionDto.setAbhaNumber(firstAppointment.getAbhaNumber());
        }else{
          throw new EntityNotFoundException("Not Proper mapping of phone number or wrong phone number according to appointment");
        }
        newpre.add(prescriptionDto);
    }
    return newpre;
  }
}
