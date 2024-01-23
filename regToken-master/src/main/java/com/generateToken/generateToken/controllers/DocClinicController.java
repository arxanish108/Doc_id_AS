package com.generateToken.generateToken.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generateToken.generateToken.services.DocClinicService;

@RestController
@RequestMapping("/doc")
@CrossOrigin("http://localhost:3000")
public class DocClinicController {

  @Autowired
  private DocClinicService docClinicService;

  @RequestMapping("/del")
  public String deleteRel(@RequestParam Long id) {
    String mess = docClinicService.deleteRel(id);
    return mess;
  }

}
