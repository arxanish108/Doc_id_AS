package com.generateToken.generateToken.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generateToken.generateToken.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findFirstByEmail(String email);
    @Query(value = "SELECT SUM(c.fees * a.count) FROM clinic AS c  INNER JOIN ( SELECT clinic_id, COUNT(*) AS count  FROM appointment WHERE doctor_id = :doctorId and  appointment_date <= :endDate and  appointment_date >= :startDate  GROUP BY clinic_id) AS a ON c.id = a.clinic_id; ",nativeQuery = true)
    public Double findByTotalAmount(Long doctorId, Date startDate, Date endDate);



}

