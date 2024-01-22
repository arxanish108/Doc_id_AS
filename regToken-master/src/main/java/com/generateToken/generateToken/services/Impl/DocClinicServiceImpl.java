package com.generateToken.generateToken.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generateToken.generateToken.repositories.DocClinicRepository;
import com.generateToken.generateToken.services.DocClinicService;

@Service
public class DocClinicServiceImpl implements DocClinicService {

  @Autowired
  private DocClinicRepository docClinicRepository;
  @Override
  public String deleteRel(Long clinicId) {

       docClinicRepository.deleteClinicDoc(clinicId);
       return "deleted";
  }
}
