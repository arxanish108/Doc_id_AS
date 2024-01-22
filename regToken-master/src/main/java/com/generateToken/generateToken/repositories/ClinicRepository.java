package com.generateToken.generateToken.repositories;


import com.generateToken.generateToken.dto.ClinicDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generateToken.generateToken.entities.Clinic;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Long> {

//    void delete(Clinic byId);
//    List<AppointmentDTOs> findByAppointmentDateBetween(Long clinicId, LocalDate startDate, LocalDate endDate);

//  @Query(value = "SELECT SUM(c.fees * a.count) FROM clinic AS c  INNER JOIN ( SELECT clinic_id, COUNT(*) AS count  FROM appointment WHERE doctor_id = :doctorId and  appointment_date <= :endDate and  appointment_date >= :startDate  GROUP BY clinic_id) AS a ON c.id = a.clinic_id; ",nativeQuery = true)
//  public Double findByTotalAmount(Long doctorId, Date startDate, Date endDate);
  //@Query(value = "Select * from clinic where clinicName = :cliName; ",nativeQuery = true)

  public Optional<Clinic> getByClinicName(String cliName);

}
