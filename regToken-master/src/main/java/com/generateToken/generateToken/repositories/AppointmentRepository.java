package com.generateToken.generateToken.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generateToken.generateToken.entities.Appointment;



@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    @Query(value = "select count(*) from appointment where clinic_id = :clinicId  and  appointment_date <= :endDate and  appointment_date >= :startDate ",nativeQuery = true)
    public int findByAppointmentDateBetween(Long clinicId, Date startDate, Date endDate);

    List<Appointment> findByContact(String contact);
    List<Appointment> findByAadharNumber(String aadharNumber);

     List<Appointment> findByAbhaNumber(String abhaNumber);


}
