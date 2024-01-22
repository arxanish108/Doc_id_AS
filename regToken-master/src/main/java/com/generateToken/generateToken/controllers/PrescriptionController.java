package com.generateToken.generateToken.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generateToken.generateToken.dto.PrescriptionDto;
import com.generateToken.generateToken.services.PrescriptionService;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("getByAbhaNumber")
    public List<PrescriptionDto> getPrescriptionByAbhaNumber(@RequestParam String abhaNumber) {
        return prescriptionService.listPrescriptionByAbhaNumber(abhaNumber);
    }
    

  @PostMapping("/addPrescription")
  public PrescriptionDto addPrescription(@RequestParam Long doctorId,
                                         @RequestParam Long clinicId,
                                         @RequestParam Long appoinId,
                                         @RequestBody PrescriptionDto prescriptionDto
  ) {

    return prescriptionService.bookPrescription(doctorId, clinicId,appoinId, prescriptionDto);
  }



//    @PostMapping("/addPrescription/{phoneNumber}")
//    public ResponseEntity<PrescriptionDto> createPrescription(@RequestBody Prescription prescription) {
//        PrescriptionDto createdPrescription = prescriptionService.createPrescription(prescription);
//        return new ResponseEntity<>(createdPrescription, HttpStatus.CREATED);
//    }
//
   @GetMapping("/get/{prescriptionId}/{contactPatient}")
   public ResponseEntity<PrescriptionDto> getPrescription(@PathVariable Long prescriptionId,@PathVariable String contactPatient) {
       PrescriptionDto prescription = prescriptionService.getPrescriptionById(prescriptionId,contactPatient);
       if (prescription != null) {
           return new ResponseEntity<>(prescription, HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
//
//    @GetMapping
//    public ResponseEntity<List<PrescriptionDto>> getAllPrescriptions() {
//        List<PrescriptionDto> prescriptions = prescriptionService.getAllPrescriptions();
//        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
//    }
//
//    @PutMapping("/{prescriptionId}")
//    public ResponseEntity<PrescriptionDto> updatePrescription(@PathVariable Long prescriptionId,@RequestBody PrescriptionDto prescriptionDto) {
//        PrescriptionDto updatedPrescription = prescriptionService.updatePrescription(prescriptionId, prescriptionDto);
//        if (updatedPrescription != null) {
//            return new ResponseEntity<>(updatedPrescription, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
   @DeleteMapping("/delete/{prescriptionId}")
   public ResponseEntity<String> deletePrescription(@PathVariable Long prescriptionId) {
       String s = prescriptionService.deletePrescription(prescriptionId);
       return new ResponseEntity<>(s,HttpStatus.OK);
   }
}
