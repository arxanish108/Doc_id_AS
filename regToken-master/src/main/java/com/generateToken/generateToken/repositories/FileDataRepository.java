package com.generateToken.generateToken.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generateToken.generateToken.entities.FileData;

public interface FileDataRepository extends JpaRepository<FileData,Long> {
    Optional<FileData> findByName(String fileName);
}
