package com.generateToken.generateToken.repositories;

import com.generateToken.generateToken.entities.DoctorClinic;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocClinicRepository extends JpaRepository<DoctorClinic,Long> {
  @Transactional
  @Modifying
  @Query(value = "DELETE FROM users_clinics WHERE clinics_id = :clinicId", nativeQuery = true)
  public void deleteClinicDoc(@Param("clinicId") Long clinicId);
}
