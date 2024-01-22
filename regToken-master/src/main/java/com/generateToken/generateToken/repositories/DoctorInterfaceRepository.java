package com.generateToken.generateToken.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generateToken.generateToken.entities.DoctorInterface;


@Repository
public interface DoctorInterfaceRepository extends JpaRepository<DoctorInterface,Long> {

    List<DoctorInterface> findByDoctorId(Long doctorId);
}
