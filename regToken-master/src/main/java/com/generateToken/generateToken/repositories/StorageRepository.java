package com.generateToken.generateToken.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generateToken.generateToken.entities.ImageData;

public interface StorageRepository extends JpaRepository<ImageData,Long> {

    Optional<ImageData> findByName(String fileName);
}